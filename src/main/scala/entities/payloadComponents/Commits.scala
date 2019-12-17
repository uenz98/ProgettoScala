package entities.payloadComponents

case class Commits(author:UserInfo,
                   distinct:Boolean,
                   message:String,
                   sha:String,
                   url:String)
