package controllers

import models.BtsMoveUtil._
import controllers.PlaceController._
import play.api.libs.json.Json
import play.api.mvc.Action
import schema.BtsMoveTable

/**
  * Created by aputtaraksa on 12/28/2015.
  */
object BtsMoveController {
  def getBtsMove() = Action {
    val btsMove = BtsMoveTable.getBtsMove

    Ok(
      Json.toJson(btsMove)
    )
  }

  def getBtsDetail(id: Int) = Action {

    Ok(
      "todo: prepare data"
    )
  }
}
