package schema

import models.Place
import play.api.Play.current
import play.api.db.DB

import scala.slick.driver.PostgresDriver.simple._
import scala.slick.lifted.Tag

/**
  * Created by aputtaraksa on 12/27/2015.
  */
class PlaceSchema(tag: Tag) extends Table[Place](tag, "place"){
  def id = column[Int]("id", O.PrimaryKey)
  def name = column[String]("name")
  def description = column[Option[String]]("description")
  def rating = column[Option[Short]]("rating")
  def url = column[Option[String]]("url")
  def image = column[Option[String]]("image")

  override def * = (id, name, description, rating, url, image) <> (Place.tupled, Place.unapply)
}

object PlaceTable {
  val place = TableQuery[PlaceSchema]

  def getAllPlace: List[Place] = {
    Database.forDataSource(DB.getDataSource()) withSession { implicit session =>
      place.list
    }
  }

  def getPlaceById(placeId: Int): List[Place]= {
    Database.forDataSource(DB.getDataSource()) withSession { implicit session =>
      val selectedPlace = place.filter(_.id === placeId)
      selectedPlace.list
    }
  }

  def getPlaceByName(placeName: String): List[Place]= {
    Database.forDataSource(DB.getDataSource()) withSession { implicit session =>
      val selectedPlace = place.filter(_.name.toLowerCase === placeName.toLowerCase)
      selectedPlace.list
    }
  }
}
