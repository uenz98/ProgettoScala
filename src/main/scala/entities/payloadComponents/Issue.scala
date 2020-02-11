package entities.payloadComponents

import scala.runtime.ScalaRunTime

class Issue(     assignee:User = null,
                 assignees:Array[User] = null,
                 author_association:String = null,
                 body:String = null,
                 closed_at:String = null,
                 comments:BigInt = 0,
                 comments_url:String = null,
                 created_at:String = null,
                 events_url:String = null,
                 html_url:String = null,
                 id:BigInt = 0,
                 labels:Array[LabelsWrapper] = null,
                 labels_url:String = null,
                 locked:java.lang.Boolean = false,
                 milestone: Milestone = null,
                 number:BigInt = 0,
                 pull_request:PullRequestWrapper = null,
                 repository_url:String = null,
                 state:String = null,
                 title:String = null,
                 updated_at:String = null,
                 url:String = null,
                 user: User = null
                )
extends Serializable
with Product {
  override def productArity: Int = 23

  override def productElement(n: Int): Any = n match {
    case 0 => assignee
    case 1 => assignees
    case 2 => author_association
    case 3 => body
    case 4 => closed_at
    case 5 => comments
    case 6 => comments_url
    case 7 => created_at
    case 8 => events_url
    case 9 => html_url
    case 10 => id
    case 11 => labels
    case 12 => labels_url
    case 13 => locked
    case 14 => milestone
    case 15 => number
    case 16 => pull_request
    case 17 => repository_url
    case 18 => state
    case 19 => title
    case 20 => updated_at
    case 21 => url
    case 22 => user
    case _ => throw new IndexOutOfBoundsException(n.toString)
  }

  def copy(assignee: User = null,
           assignees: Array[User] = null,
           author_association: String = null,
           body: String = null,
           closed_at: String = null,
           comments: BigInt = 0,
           comments_url: String = null,
           created_at: String = null,
           events_url: String = null,
           html_url: String = null,
           id: BigInt = 0,
           labels: Array[LabelsWrapper] = null,
           labels_url: String = null,
           locked: java.lang.Boolean = false,
           milestone: Milestone = null,
           number: BigInt = 0,
           pull_request: PullRequestWrapper = null,
           repository_url: String = null,
           state: String = null,
           title: String = null,
           updated_at: String = null,
           url: String = null,
           user: User = null) = {
    new Issue(assignee = this.assignee,
      assignees = this.assignees,
      author_association = this.author_association,
      body = this.body,
      closed_at = this.closed_at,
      comments = this.comments,
      comments_url = this.comments_url,
      created_at = this.created_at,
      events_url = this.events_url,
      html_url = this.html_url,
      id = this.id,
      labels = this.labels,
      labels_url = this.labels_url,
      locked = this.locked,
      milestone = this.milestone,
      number = this.number,
      pull_request = this.pull_request,
      repository_url = this.repository_url,
      state = this.state,
      title = this.title,
      updated_at = this.updated_at,
      url = this.url,
      user = this.user)
  }

  override def canEqual(that: Any): Boolean = that.isInstanceOf[Issue]

  override def equals(that: Any): Boolean = ScalaRunTime._equals(this, that)

  override def hashCode(): Int = ScalaRunTime._hashCode(this)

  override def toString: String = ScalaRunTime._toString(this)
}

object Issue{
  def apply(assignee: User, assignees: Array[User], author_association: String, body: String, closed_at: String, comments: BigInt, comments_url: String, created_at: String, events_url: String, html_url: String, id: BigInt, labels: Array[LabelsWrapper], labels_url: String, locked: java.lang.Boolean, milestone: Milestone, number: BigInt, pull_request: PullRequestWrapper, repository_url: String, state: String, title: String, updated_at: String, url: String, user: User): Issue = new Issue(assignee, assignees, author_association, body, closed_at, comments, comments_url, created_at, events_url, html_url, id, labels, labels_url, locked, milestone, number, pull_request, repository_url, state, title, updated_at, url, user)
}