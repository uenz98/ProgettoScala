package entities.schemas

import entities.Repo
import entities.payloadComponents.User

case class BaseForSchema(label:String = null,
                         ref:String = null,
                         repo:Repo = null,
                         sha:String = null,
                         user: User = null
               ) extends Serializable
