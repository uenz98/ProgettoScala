package entities.payloadComponents

case class Key(key:String = null,
               name:String = null,
               spdx_id:String = null,
               url:String = null
              ) extends Serializable
