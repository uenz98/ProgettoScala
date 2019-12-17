package entities.payloadComponents

case class Base(label:String,
                ref:String,
                repo:Forkee,
                sha:String,
                user: User
               )
