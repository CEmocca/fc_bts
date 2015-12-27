package schema

import models.Station
import play.api.db.DB

import scala.slick.driver.PostgresDriver.simple._
import scala.slick.lifted.Tag
import play.api.Play.current

/**
  * Created by aputtaraksa on 12/26/2015.
  */
class StationSchema(tag: Tag) extends Table[Station](tag, "bts_station"){
  def id = column[Int]("id", O.PrimaryKey)
  def name = column[String]("name")
  def image = column[Option[String]]("image")

  override def * = (id, name, image) <> (Station.tupled, Station.unapply)

}

object StationTable {
  val station = TableQuery[StationSchema]

  def getAllStation: List[Station] = {
    Database.forDataSource(DB.getDataSource()) withSession { implicit session =>
      station.list
    }
  }

  def getStationById(stationId: Int): List[Station]= {
    Database.forDataSource(DB.getDataSource()) withSession { implicit session =>
      val selectedStation = station.filter(_.id === stationId)
      selectedStation.list
    }
  }

  def getStationByName(stationName: String): List[Station]= {
    Database.forDataSource(DB.getDataSource()) withSession { implicit session =>
      val selectedStation = station.filter(_.name.toLowerCase === stationName.toLowerCase)
      selectedStation.list
    }
  }
}
//val stationTable = TableQuery[StationSchema]

