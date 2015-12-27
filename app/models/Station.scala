package models

import play.api.libs.json.Json

/**
  * Created by aputtaraksa on 12/17/2015.
  */

case class Station(id: Int, name: String, image: Option[String])

object StationUtil {
  implicit val stationWriter = Json.writes[Station]

  implicit val stationReader = Json.reads[Station]

  implicit val stationFormat = Json.format[Station]
}
