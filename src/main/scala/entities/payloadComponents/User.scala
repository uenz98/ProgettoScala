package entities.payloadComponents

case class User(
                 avatar_url:String = null,
                 events_url:String = null,
                 followers_url:String = null,
                 following_url:String = null,
                 gists_url:String = null,
                 gravatar_id:String = null,
                 html_url:String = null,
                 id:BigInt = 0,
                 login:String = null,
                 organizations_url:String = null,
                 received_events_url:String = null,
                 repos_url:String = null,
                 site_admin:java.lang.Boolean = false,
                 starred_url:String = null,
                 subscriptions_url:String = null,
                 `type`:String = null,
                 url:String = null
               )
