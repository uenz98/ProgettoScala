package util

import java.io.{File, FileInputStream, FileOutputStream}
import java.net.{HttpURLConnection, URL}
import java.util.zip.GZIPInputStream

import entities.JsonToParse
import entities.schemas.JsonToParseForSchema
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{Dataset, SQLContext}
import org.apache.spark.sql.catalyst.ScalaReflection
import org.apache.spark.sql.types.{ArrayType, StructType}

object Utility {


  def fromFilePathJSONToDataframe(filePath:String, sqlContext: SQLContext):Dataset[JsonToParse] = {

    val schema = ScalaReflection.schemaFor[JsonToParseForSchema].dataType.asInstanceOf[StructType]

    import sqlContext.implicits._
    val jsonDF = sqlContext.read.schema(schema).json(filePath)
    jsonDF.show
    val jsonRenamed = jsonDF.withColumnRenamed("private", "privateField")
      .withColumnRenamed("public", "publicField")
      .withColumnRenamed("default", "defaultField")
    jsonRenamed.as[JsonToParse]
  }

  def fileDownloader(fileURL: String): String = {
    if(!new File(getFileNameFromURL(fileURL)).exists()) {
      var fileNameToUnzip = ""
      val url = new URL(fileURL)
      var httpConn = url.openConnection.asInstanceOf[HttpURLConnection]
      httpConn.addRequestProperty("Accept-Language", "en-US,en;q=0.8")
      httpConn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36")
      httpConn.addRequestProperty("Referer", "google.com")
      var responseCode = httpConn.getResponseCode
      // always check HTTP response code first
      var redirect = false
      if (responseCode == HttpURLConnection.HTTP_MOVED_TEMP
        || responseCode == HttpURLConnection.HTTP_MOVED_PERM
        || responseCode == HttpURLConnection.HTTP_SEE_OTHER)
        redirect = true;
      if (redirect) { // get redirect url from "location" header field
        val newUrl = httpConn.getHeaderField("Location")
        // get the cookie if need, for login
        val cookies = httpConn.getHeaderField("Set-Cookie")
        // open the new connnection again
        httpConn = new URL(newUrl).openConnection.asInstanceOf[HttpURLConnection]
        httpConn.setRequestProperty("Cookie", cookies)
        httpConn.addRequestProperty("Accept-Language", "en-US,en;q=0.8")
        httpConn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36")
        httpConn.addRequestProperty("Referer", "google.com")
        responseCode = httpConn.getResponseCode
        System.out.println("Redirect to URL : " + newUrl)
      }
      if (responseCode == HttpURLConnection.HTTP_OK) {

        val disposition = httpConn.getHeaderField("Content-Disposition")
        val contentType = httpConn.getContentType
        val contentLength = httpConn.getContentLength
        if (disposition != null) { // extracts file name from header field
          val index = disposition.indexOf("filename=")
          if (index > 0) fileNameToUnzip = disposition.substring(index + 10, disposition.length - 1)
        }
        else { // extracts file name from URL
          fileNameToUnzip = fileURL.substring(fileURL.lastIndexOf("/") + 1, fileURL.length)
        }
        System.out.println("Content-Type = " + contentType)
        System.out.println("Content-Disposition = " + disposition)
        System.out.println("Content-Length = " + contentLength)
        System.out.println("fileName = " + fileNameToUnzip)
        // opens input stream from the HTTP connection
        val inputStream = httpConn.getInputStream
        val saveFilePath = fileNameToUnzip
        // opens an output stream to save into file
        val outputStream = new FileOutputStream(saveFilePath)
        var bytesRead = -1
        val buffer = new Array[Byte](4096)
        while ( {
          bytesRead = inputStream.read(buffer)
          bytesRead != -1
        }) {
          outputStream.write(buffer, 0, bytesRead)
        }
        outputStream.close()
        inputStream.close()
        System.out.println("File downloaded")
      }
      else System.out.println("No file to download. Server replied HTTP code: " + responseCode)
      httpConn.disconnect()
    } else{
      println("skipping, file already downloaded")
    }
    getFileNameFromURL(fileURL)
  }

  def decompressGzipFile(newFile: String, fileNameToUnzip:String): Unit = {
    val fis = new FileInputStream(fileNameToUnzip)
    val gis = new GZIPInputStream(fis)
    val fos = new FileOutputStream(newFile)
    val buffer = new Array[Byte](1024)
    var len = 0
    var reader = -1
    while ({
      reader = gis.read(buffer)
      reader != -1
    }) {
      len = reader
      fos.write(buffer, 0, len)
    }
    //close resources
    fos.close()
    gis.close()
  }

  def getFileNameFromURL(url:String): String ={
    url.substring(url.lastIndexOf("/") + 1)
  }
}
