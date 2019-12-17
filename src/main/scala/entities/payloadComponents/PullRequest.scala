package entities.payloadComponents

class PullRequest(_links:LinksWrapper2,
                       additions:Long,
                       assignee:User,
                       assignees:Array[User],
                       author_association:String,
                       base:Base,
                       body:String,
                       changed_files:Long,
                       closed_at:String,
                       comments:Long,
                       comments_url:String,
                       commits:Long,
                       commits_url:String,
                       created_at:String,
                       deletions:Long,
                       diff_url:String,
                       head:Base,
                       html_url:String,
                       id:Long,
                       issue_url:String,
                       labels:LabelsWrapper,
                       locked:Boolean,
                       maintainer_can_modify:Boolean,
                       merge_commit_sha:String,
                       mergeable:Boolean,
                       mergeable_state:String,
                       merged:Boolean,
                       merged_at:String,
                       merged_by:User,
                       milestone: Milestone,
                       number:Long,
                       patch_url:String,
                       rebaseable:Boolean,
                       requested_reviewers:Array[User],
                       requested_teams:Array[Team],
                       review_comment_url:String,
                       review_comments:Long,
                       review_comments_url:String,
                       state:String,
                       statuses_url:String,
                       title:String,
                       updated_at:String,
                       url:String,
                       user: User
                      )
extends Product
with Serializable{
  override def canEqual(that: Any): Boolean = that.isInstanceOf[PullRequest]

  override def productElement(n: Int): Any = n match{
    case 0 => _links
    case 1 => additions
    case 2 => assignee
    case 3 => assignees
    case 4 => author_association
    case 5 => base
    case 6 => body
    case 7 => changed_files
    case 8 => closed_at
    case 9 => comments
    case 10 => comments_url
    case 11 => commits
    case 12 => commits_url
    case 13 => created_at
    case 14 => deletions
    case 15 => diff_url
    case 16 => head
    case 17 => html_url
    case 18 => id
    case 19 => issue_url
    case 20 => labels
    case 21 => locked
    case 22 => maintainer_can_modify
    case 23 => merge_commit_sha
    case 24 => mergeable
    case 25 => mergeable_state
    case 26 => merged
    case 27 => merged_at
    case 28 => merged_by
    case 29 => milestone
    case 30 => number
    case 31 => patch_url
    case 32 => rebaseable
    case 33 => requested_reviewers
    case 34 => requested_teams
    case 35 => review_comment_url
    case 36 => review_comments
    case 37 => review_comments_url
    case 38 => state
    case 39 => statuses_url
    case 40 => title
    case 41 => updated_at
    case 42 => url
  }

  override def productArity: Int = 43
}