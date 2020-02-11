package entities.payloadComponents

case class Release(assets: Array[Asset] = null,
                   assets_url:String = null,
                   author:User = null,
                   body:String = null,
                   created_at:String = null,
                   draft:java.lang.Boolean = false,
                   html_url:String = null,
                   id:BigInt = 0,
                   name:String = null,
                   prerelease:java.lang.Boolean = false,
                   published_at:String = null,
                   tag_name:String = null,
                   tarball_url:String = null,
                   target_commitish:String = null,
                   upload_url:String = null,
                   url:String = null,
                   zipball_url:String = null
                  ) extends Serializable
