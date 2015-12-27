package controllers

import controllers.PlaceController._
import models.PlaceBtsUtil._
import play.api.libs.json._
import play.api.libs.json.Json
import play.api.mvc.Action
import schema.{PlaceBtsTable, PlaceTable}

/**
  * Created by aputtaraksa on 12/27/2015.
  */
object PlaceBtsController {

  def getPlaceNearBtsById(id: Int) = Action {
    val placeNearBts = PlaceBtsTable.getPlaceNearBtsById(id.toShort)

    Ok(
      Json.toJson(placeNearBts)
    )
  }

  def getBtsNearPlaceById(id: Int) = Action {
    val btsNearPlace = PlaceBtsTable.getBtsNearPlaceById(id).toSeq

    Ok(
      Json.toJson(btsNearPlace)
    )
  }
}
