package twimpact

import javax.ws.rs.core.MediaType._
import javax.ws.rs._
import core.Response
import org.atmosphere.cpr.{BroadcasterFactory, Broadcaster}
import java.util.UUID
import org.atmosphere.annotation.Suspend
import org.atmosphere.jersey.{Broadcastable, JerseyBroadcaster, SuspendResponse}
import java.util.concurrent.TimeUnit

@Path("/stream")
class Stream {

  @GET
  @Produces(Array(APPLICATION_JSON))
  @Suspend
  def stream = {
    val broadcaster = BroadcasterFactory.getDefault.get(classOf[JerseyBroadcaster], UUID.randomUUID().toString)

    println("%s: streaming ...".format(broadcaster.getID))

    broadcaster.delayBroadcast("DELAYED", 10, TimeUnit.SECONDS)
    new Broadcastable("READY\n", broadcaster)
  }
}
