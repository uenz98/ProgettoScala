package entities.payloadComponents

case class Team(description:String = null,
                id:BigInt = 0,
                members_url:String = null,
                name:String = null,
                permission:String = null,
                privacy:String = null,
                repositories_url:String = null,
                slug:String = null,
                url:String = null
               ) extends Serializable
