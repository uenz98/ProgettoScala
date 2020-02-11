package entities.payloadComponents

case class Pages(action:String = null,
                 html_url:String = null,
                 page_name:String = null,
                 sha:String = null,
                 summary:String = null,
                 title:String = null
                ) extends Serializable
