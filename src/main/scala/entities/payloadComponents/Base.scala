package entities.payloadComponents

case class Base(label:String = null,
                ref:String = null,
                repo:Repo = null,
                sha:String = null,
                user: User = null
               ) extends Serializable
