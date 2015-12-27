package models

import play.api.libs.json.Json

/**
  * Created by aputtaraksa on 12/26/2015.
  */
case class Place(id: Int, name: String, description: Option[String], rating: Option[Short], url: Option[String], image: Option[String])

object PlaceUtil {
  implicit val placeWriter = Json.writes[Place]

  implicit val placeReader = Json.reads[Place]

  implicit val placeFormat = Json.format[Place]
}

