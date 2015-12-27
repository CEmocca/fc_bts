package models

import play.api.libs.json.Json

/**
  * Created by aputtaraksa on 12/27/2015.
  */
case class BtsMove(start_id: Short, terminal_id: Short, cost: Double, created: String, created_by: String, modified: Option[String], modified_by: Option[String])

object BtsMoveUtil {
    implicit val btsMoveWriter = Json.writes[BtsMove]

    implicit val btsMoveReader = Json.reads[BtsMove]

    implicit val btsMoveFormat = Json.format[BtsMove]
}
