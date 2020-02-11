package entities.payloadComponents

import scala.beans.BeanProperty

class PullRequest(@BeanProperty _links:LinksWrapper2 = LinksWrapper2(),
                  @BeanProperty additions:BigInt = 0,
                  @BeanProperty assignee:User = User(),
                  @BeanProperty assignees:Array[User] = new Array[User](0),
                  @BeanProperty author_association:String = null,
                  @BeanProperty base:Base = null,
                  @BeanProperty body:String = null,
                  @BeanProperty changed_files:BigInt = 0,
                  @BeanProperty closed_at:String = null,
                  @BeanProperty comments:BigInt = 0,
                  @BeanProperty comments_url:String = null,
                  @BeanProperty commits:BigInt = 0,
                  @BeanProperty commits_url:String = null,
                  @BeanProperty created_at:String = null,
                  @BeanProperty deletions:BigInt = 0,
                  @BeanProperty diff_url:String = null,
                  @BeanProperty head:Base = null,
                  @BeanProperty html_url:String = null,
                  @BeanProperty id:BigInt = 0,
                  @BeanProperty issue_url:String = null,
                  @BeanProperty labels:Array[LabelsWrapper] = new Array[LabelsWrapper](0),
                  @BeanProperty locked:java.lang.Boolean = false,
                  @BeanProperty maintainer_can_modify:java.lang.Boolean = false,
                  @BeanProperty merge_commit_sha:String = null,
                  @BeanProperty mergeable:java.lang.Boolean = false,
                  @BeanProperty mergeable_state:String = null,
                  @BeanProperty merged:java.lang.Boolean = false,
                  @BeanProperty merged_at:String = null,
                  @BeanProperty merged_by:User = null,
                  @BeanProperty milestone: Milestone = Milestone(),
                  @BeanProperty number:BigInt = 0,
                  @BeanProperty patch_url:String = null,
                  @BeanProperty rebaseable:java.lang.Boolean = false,
                  @BeanProperty requested_reviewers:Array[User] = new Array[User](0),
                  @BeanProperty requested_teams:Array[Team] = new Array[Team](0),
                  @BeanProperty review_comment_url:String = null,
                  @BeanProperty review_comments:BigInt = 0,
                  @BeanProperty review_comments_url:String = null,
                  @BeanProperty state:String = null,
                  @BeanProperty statuses_url:String = null,
                  @BeanProperty title:String = null,
                  @BeanProperty updated_at:String = null,
                  @BeanProperty url:String = null,
                  @BeanProperty user: User = null
                      )
extends Serializable
with Product {
  override def canEqual(that: Any):Boolean = that.isInstanceOf[PullRequest]

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
    case _ => throw new IndexOutOfBoundsException(n.toString)
  }

  override def productArity: Int = 43
}