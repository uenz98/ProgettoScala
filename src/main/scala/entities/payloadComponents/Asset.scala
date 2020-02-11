package entities.payloadComponents

case class Asset(browser_download_url:String = null,
                 content_type:String = null,
                 created_at:String = null,
                 download_count:BigInt = 0,
                 id:BigInt = 0,
                 label:String = null,
                 name:String = null,
                 size:BigInt = 0,
                 state:String = null,
                 updated_at:String = null,
                 uploader:User = null,
                 url:String = null
                ) extends Serializable
