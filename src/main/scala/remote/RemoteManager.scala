package remote

import akka.actor._
import common.Message

object RemoteManager extends App  {
  val system = ActorSystem("HelloRemoteSystem")
  val remoteActor = system.actorOf(Props[RemoteManagerActor], name = "RemoteManagerActor")
  //remoteActor ! Message("The RemoteManagerActor is alive")
}

class RemoteManagerActor extends Actor {
  def receive = {
    case Message(msg) =>
      println(s"RemoteActor received message '$msg'")
      sender ! Message("Hello from the RemoteActor")
    case _ =>
      println("RemoteActor got something unexpected.")

  }
}