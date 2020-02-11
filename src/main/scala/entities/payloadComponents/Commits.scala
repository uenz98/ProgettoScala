package entities.payloadComponents

case class Commits(author:UserInfo = null,
                   distinct:java.lang.Boolean = false,
                   message:String = null,
                   sha:String = null,
                   url:String = null
                  ) extends Serializable
