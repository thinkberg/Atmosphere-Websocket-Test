package twimpact.jersey

import com.sun.jersey.api.view.Viewable
import javax.ws.rs.{Path, GET}

/**
 * Test Handler
 *
 * @author Matthias L. Jugel
 */

@Path("/")
class Controller {

  @GET
  def view = new Viewable("/index.jsp")
}
