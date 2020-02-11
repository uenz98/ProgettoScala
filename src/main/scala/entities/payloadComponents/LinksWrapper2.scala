package entities.payloadComponents

case class LinksWrapper2(comments:HrefWrapper = null,
                         commits:HrefWrapper = null,
                         html:HrefWrapper = null,
                         issue:HrefWrapper = null,
                         review_comment:HrefWrapper = null,
                         review_comments:HrefWrapper = null,
                         self:HrefWrapper = null,
                         statuses:HrefWrapper = null
                        ) extends Serializable
