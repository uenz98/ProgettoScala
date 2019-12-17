package entities.payloadComponents

case class Asset(browser_download_url:String,
                 content_type:String,
                 created_at:String,
                 download_count:Long,
                 id:Long,
                 label:String,
                 name:String,
                 size:Long,
                 state:String,
                 updated_at:String,
                 uploader:User,
                 url:String
                )
