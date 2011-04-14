package twimpact

import javax.ws.rs.core.MediaType._
import org.atmosphere.cpr.Broadcaster
import javax.ws.rs._
import core.Response
import org.atmosphere.jersey.SuspendResponse

@Path("/trend/{id}")
class Stream(@PathParam("id") broadcaster: Broadcaster) {

  @POST
  @Path("start")
  @Produces(Array(APPLICATION_JSON))
  def start = {
    println("START")
    new Thread {
      override def run() {
        while (true) {
          Thread.sleep(10000)
          println("...")
          broadcaster.broadcast("{\"text\":\"message\"}")
        }
      }
    }.start()
    Response.ok.build
  }

  @GET
  @Path("stop")
  @Produces(Array(APPLICATION_JSON))
  def stop = {
    println("STOP")
    Response.ok().build
  }

  @GET
  @Path("stream")
  def stream: SuspendResponse[String] = {
    println("%s: streaming ...".format(broadcaster.getID))
    new SuspendResponse.SuspendResponseBuilder()
    .broadcaster(broadcaster)
    .outputComments(true)
    .build()
  }
}
