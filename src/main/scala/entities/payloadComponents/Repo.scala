package entities.payloadComponents

class Repo(archive_url       : String = null,
           archived          : java.lang.Boolean = false,
           assignees_url     : String = null,
           blobs_url         : String = null,
           branches_url      : String = null,
           clone_url         : String = null,
           collaborators_url : String = null,
           comments_url      : String = null,
           commits_url       : String = null,
           compare_url       : String = null,
           contents_url      : String = null,
           contributors_url  : String = null,
           created_at        : String = null,
           default_branch    : String = null,
           deployments_url   : String = null,
           description       : String = null,
           downloads_url     : String = null,
           events_url        : String = null,
           fork              : java.lang.Boolean = false,
           forks             : BigInt = 0,
           forks_count       : BigInt = 0,
           forks_url         : String = null,
           full_name         : String = null,
           git_commits_url   : String = null,
           git_refs_url      : String = null,
           git_tags_url      : String = null,
           git_url           : String = null,
           has_downloads     : java.lang.Boolean = false,
           has_issues        : java.lang.Boolean = false,
           has_pages         : java.lang.Boolean = false,
           has_projects      : java.lang.Boolean = false,
           has_wiki          : java.lang.Boolean = false,
           homepage          : String = null,
           hooks_url         : String = null,
           html_url          : String = null,
           id                : BigInt = 0,
           issue_comment_url : String = null,
           issue_events_url  : String = null,
           issues_url        : String = null,
           keys_url          : String = null,
           labels_url        : String = null,
           language          : String = null,
           languages_url     : String = null,
           license           :Key = null,
           merges_url        :String = null,
           milestones_url    :String = null,
           mirror_url        :String = null,
           name              :String = null,
           notifications_url :String = null,
           open_issues       :BigInt = 0,
           open_issues_count :BigInt = 0,
           owner             :User = null,
           privateField      :java.lang.Boolean = false,
           pulls_url         :String = null,
           pushed_at         :String = null,
           releases_url      :String = null,
           size              :BigInt = 0,
           ssh_url           :String = null,
           stargazers_count  :BigInt = 0,
           stargazers_url    :String = null,
           statuses_url      :String = null,
           subscribers_url   :String = null,
           subscription_url  :String = null,
           svn_url           :String = null,
           tags_url          :String = null,
           teams_url         :String = null,
           trees_url         :String = null,
           updated_at        :String = null,
           url               :String = null,
           watchers          :BigInt = 0,
           watchers_count    :BigInt = 0
                 )
extends Serializable
with Product {
  override def productArity: Int = 72;

  override def productElement(n: Int): Any = n match {
    case 0 =>archive_url
    case 1 =>archived
    case 2 =>assignees_url
    case 3 =>blobs_url
    case 4 =>branches_url
    case 5 =>clone_url
    case 6 =>collaborators_url
    case 7 =>comments_url
    case 8 =>commits_url
    case 9 =>compare_url
    case 10 =>contents_url
    case 11 =>contributors_url
    case 12 =>created_at
    case 13 =>default_branch
    case 14 =>deployments_url
    case 15 =>description
    case 16 =>downloads_url
    case 17 =>events_url
    case 18 =>fork
    case 19 =>forks
    case 20 =>forks_count
    case 21 =>forks_url
    case 22 =>full_name
    case 23 =>git_commits_url
    case 24 =>git_refs_url
    case 25 =>git_tags_url
    case 26 =>git_url
    case 27 =>has_downloads
    case 28 =>has_issues
    case 29 =>has_pages
    case 30 =>has_projects
    case 31 =>has_wiki
    case 32 =>homepage
    case 33 =>hooks_url
    case 34 =>html_url
    case 35 =>id
    case 36 =>issue_comment_url
    case 37 =>issue_events_url
    case 38 =>issues_url
    case 39 =>keys_url
    case 40 =>labels_url
    case 41 =>language
    case 42 =>languages_url
    case 43 =>license
    case 44 =>merges_url
    case 45 =>milestones_url
    case 46 =>mirror_url
    case 47 =>name
    case 48 =>notifications_url
    case 49 =>open_issues
    case 50 =>open_issues_count
    case 51 =>owner
    case 52 =>privateField
    case 53 =>pulls_url
    case 54 =>pushed_at
    case 55 =>releases_url
    case 56 =>size
    case 57 =>ssh_url
    case 58 =>stargazers_count
    case 59 =>stargazers_url
    case 60 =>statuses_url
    case 61 =>subscribers_url
    case 62 =>subscription_url
    case 63 =>svn_url
    case 64 =>tags_url
    case 65 =>teams_url
    case 66 =>trees_url
    case 67 =>updated_at
    case 68 =>url
    case 69 =>watchers
    case 70 =>watchers_count
  }

  override def canEqual(that: Any): Boolean = that.isInstanceOf[Repo]
}