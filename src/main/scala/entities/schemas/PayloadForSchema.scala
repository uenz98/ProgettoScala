package entities.schemas

import entities.payloadComponents._

case class PayloadForSchema(action:String = null,
                            before:String = null,
                            comment: Comment = null,
                            commits:Array[Commits] = new Array[Commits](0),
                            description:String = null,
                            distinct_size:BigInt = 0,
                            forkee:ForkeeForSchema = null,
                            head:String = null,
                            issue: Issue = null,
                            master_branch:String = null,
                            member:User = null,
                            number:BigInt = 0,
                            pages: Array[Pages] = new Array[Pages](0),
                            pull_request:PullRequest = null,
                            push_id:BigInt = 0,
                            pusher_type:String = null,
                            ref:String = null,
                            ref_type:String = null,
                            release: Release = null,
                            size:BigInt = 0
                  ) extends Serializable
