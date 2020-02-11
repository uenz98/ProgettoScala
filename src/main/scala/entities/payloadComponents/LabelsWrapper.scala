package entities.payloadComponents

case class LabelsWrapper(color:String = null,
                         defaultField:java.lang.Boolean = false,
                         id:BigInt = 0,
                         name:String = null,
                         url:String = null
                        ) extends Serializable
