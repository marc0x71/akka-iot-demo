package org.example

import DeviceManager._

import akka.actor.testkit.typed.scaladsl.ScalaTestWithActorTestKit
import org.scalatest.wordspec.AnyWordSpecLike

class DeviceManagerSpec extends ScalaTestWithActorTestKit with AnyWordSpecLike {
  "DeviceManager actor" must {

    "reply to registration requests" in {
      val probe = createTestProbe[DeviceRegistered]()
      val managerActor = spawn(DeviceManager())

      managerActor ! RequestTrackDevice("group1", "device", probe.ref)
      val registered1 = probe.receiveMessage()

      // another group
      managerActor ! RequestTrackDevice("group2", "device", probe.ref)
      val registered2 = probe.receiveMessage()

      registered1.device should !==(registered2.device)
    }

  }
}
