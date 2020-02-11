package entities.payloadComponents

case class Milestone(closed_at:String=null,
                     closed_issues:BigInt=0,
                     created_at:String=null,
                     creator:User=null,
                     description:String=null,
                     due_on:String=null,
                     html_url:String=null,
                     id:BigInt=0,
                     labels_url:String=null,
                     number:BigInt=0,
                     open_issues:BigInt=0,
                     state:String=null,
                     title:String=null,
                     updated_at:String=null,
                     url:String=null
                    ) extends Serializable
