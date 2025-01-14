package org.agoncal.fascicle.quarkus.http.openapi.advanced;

import org.eclipse.microprofile.openapi.annotations.ExternalDocumentation;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.servers.Server;
import org.eclipse.microprofile.openapi.annotations.servers.ServerVariable;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/")
// tag::adocInfo[]
@OpenAPIDefinition(
  info = @Info(
    title = "Book API",
    description = "This API allows CRUD operations on books",
    version = "1.0",
    contact = @Contact(name = "@agoncal", url = "https://twitter.com/agoncal"),
    license = @License(
      name = "MIT",
      url = "https://opensource.org/licenses/MIT")),
  externalDocs = @ExternalDocumentation(url = "https://github.com/agoncal/agoncal-fascicle-quarkus", description = "All the Quarkus fascicle code"),
  tags = {
    @Tag(name = "api", description = "Public API that can be used by anybody"),
    @Tag(name = "books", description = "Anybody interested in books")
  }
// end::adocInfo[]
  ,
// tag::adocServer[]
  servers = @Server(
    description = "Vintage Store server 1",
    url = "http://{host}.vintage-store/{port}",
    variables = {
      @ServerVariable(name = "host",
        description = "Vintage Store main server",
        defaultValue = "localhost"),
      @ServerVariable(name = "port",
        description = "Vintage Store listening port",
        defaultValue = "80")
    }
  )
// tag::adocSnippet[]
)
public class BookApplication extends Application {
}
// end::adocSnippet[]
// end::adocServer[]
