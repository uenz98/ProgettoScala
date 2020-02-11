package entities.payloadComponents

case class PullRequestWrapper(diff_url:String = null,
                              html_url:String = null,
                              patch_url:String = null,
                              url:String = null
                             ) extends Serializable
