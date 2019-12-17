package entities

import entities.payloadComponents.{Comment, Commits, Forkee, Issue, Pages, PullRequest, Release, User}

case class Payload(action:String,
                   before:String,
                   comment: Comment,
                   commits:Array[Commits],
                   description:String,
                   distinct_size:Long,
                   forkee:Forkee,
                   head:String,
                   issue: Issue,
                   master_branch:String,
                   member:User,
                   number:Long,
                   pages: Array[Pages],
                   pull_request:PullRequest,
                   push_id:Long,
                   pusher_type:String,
                   ref:String,
                   ref_type:String,
                   release: Release,
                   size:Long
                  )
