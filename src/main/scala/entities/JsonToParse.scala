package entities

case class JsonToParse(
                      actor: Actor,
                      created_at: String,
                      id: String,
                      org: Org,
                      payload: Payload,
                      public: java.lang.Boolean,
                      repo: Repo,
                      `type`:String
                      )
