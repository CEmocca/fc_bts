package controllers

import play.api._
import play.api.libs.json.Json
import play.api.mvc._
import models._
import schema.StationTable
import models.StationUtil._

object StationController extends Controller {

  def getAllStation = Action {

    Ok(Json.toJson(StationTable.getAllStation))
  }

  def getStationById(id: Int) = Action {
    val station = StationTable.getStationById(id).headOption

    station match {
      case Some(x) => Ok(stationWriter.writes(x))
      case None => NotFound
    }
  }

  def getStationByName(name: String) = Action {
    val station = StationTable.getStationByName(name).headOption

    station match {
      case Some(x) => Ok(stationWriter.writes(x))
      case None => NotFound
    }
  }
}