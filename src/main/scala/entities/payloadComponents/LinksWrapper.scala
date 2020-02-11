package entities.payloadComponents

case class LinksWrapper(html:HrefWrapper,
                        pull_request:HrefWrapper,
                        self:HrefWrapper) extends Serializable
