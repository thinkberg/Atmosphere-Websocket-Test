package twimpact.jersey

import com.sun.jersey.api.view.Viewable
import javax.ws.rs.{Path, GET}
import javax.servlet.http.HttpServletRequest
import javax.ws.rs.core.Context
import grizzled.slf4j.Logging
import collection.JavaConverters._

/**
 * Test Handler
 *
 * @author Matthias L. Jugel
 */

@Path("/")
class Controller(@Context request: HttpServletRequest) extends Logging {

  @GET
  def view = {
    debug(request)
    new Viewable("/index.jsp", Map("sometext" -> "Some Text").asJava)
  }
}
