package twimpact.atmosphere

import org.atmosphere.annotation.Suspend
import javax.ws.rs.core.MediaType
import javax.ws.rs.{Path, Produces, GET}

@Path("/1")
class Stream {

  @GET
  @Suspend
  @Path("/stream")
  def stream = ""

  @GET
  @Path("/json")
  @Produces(Array(MediaType.APPLICATION_JSON))
  def json = "{\"key\":1234567890,\"key1\":\"value\"}"
}
