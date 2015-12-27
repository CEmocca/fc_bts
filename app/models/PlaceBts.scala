package models

import play.api.libs.json.Json

/**
  * Created by aputtaraksa on 12/27/2015.
  */
case class PlaceBts(btsId: Short, placeId: Int, rank: Short, distance: Short, created: String, created_by: String, modified: Option[String], modified_by: Option[String])

object PlaceBtsUtil {
  implicit val placeBtsWriter = Json.writes[PlaceBts]

  implicit val placeBtsReader = Json.reads[PlaceBts]

  implicit val placeBtsFormat = Json.format[PlaceBts]
}


