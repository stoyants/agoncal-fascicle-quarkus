package org.agoncal.fascicle.quarkus.firststep;

// tag::adocSnippet[]
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

// tag::adocSkip[]
/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// end::adocSkip[]
@Path("/authors")
@Produces(MediaType.TEXT_PLAIN)
public class AuthorResource {

  String[] scifiAuthors = {"Isaac Asimov", "Nora Jemisin", "Douglas Adams"};

  @GET
  public String getAllScifiAuthors() {
    return String.join(", ", scifiAuthors);
  }

  @GET
  @Path("/{index}")
  public String getScifiAuthor(@PathParam("index") int index) {
    return scifiAuthors[index];
  }
}
// end::adocSnippet[]
