package entities.payloadComponents

case class Comment(_links:LinksWrapper = null,
                   author_association:String = null,
                   body:String = null,
                   commit_id:String = null,
                   created_at:String = null,
                   diff_hunk:String = null,
                   html_url:String = null,
                   id:BigInt = 0,
                   in_reply_to_id:BigInt = 0,
                   issue_url:String = null,
                   line:BigInt = 0,
                   original_commit_id:String = null,
                   original_position:BigInt = 0,
                   path:String = null,
                   position:BigInt = 0,
                   pull_request_review_id:BigInt = 0,
                   pull_request_url:String = null,
                   updated_at:String = null,
                   url:String = null,
                   user:User = null
                  ) extends Serializable
