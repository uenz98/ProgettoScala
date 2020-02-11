package entities.payloadComponents

case class UserInfo(email:String = null,
                    name:String = null
                   ) extends Serializable
