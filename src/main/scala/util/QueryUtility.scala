package util

import java.io.{File, FileWriter}

object QueryUtility {

  def createFile(filePath:String, query:String):Unit = {
    val file = new File(filePath)
    val print = new FileWriter(file)
    print.write(query)
  }
}
