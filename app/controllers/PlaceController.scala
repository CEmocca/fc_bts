package controllers

import models.PlaceUtil._
import play.api.libs.json.Json
import play.api.mvc._
import schema.PlaceTable

object PlaceController extends Controller {

  def getAllPlace = Action {

    Ok(Json.toJson(PlaceTable.getAllPlace))
  }

  def getPlaceById(id: Int) = Action {
    val place = PlaceTable.getPlaceById(id).headOption

    place match {
      case Some(x) => Ok(placeWriter.writes(x))
      case None => NotFound
    }
  }

  def getPlaceByName(name: String) = Action {
    val place = PlaceTable.getPlaceByName(name).headOption

    place match {
      case Some(x) => Ok(placeWriter.writes(x))
      case None => NotFound
    }
  }
}