package entities.schemas

import entities.{Actor, Org, Repo}

case class JsonToParseForSchema(
                      actor: Actor,
                      created_at: String,
                      id: String,
                      org: Org,
                      payload: PayloadForSchema,
                      public: java.lang.Boolean,
                      repo: Repo,
                      `type`:String
                      )
