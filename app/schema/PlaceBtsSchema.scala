package schema

import models.PlaceBts
import play.api.db.DB
import scala.slick.driver.PostgresDriver.simple._
import scala.slick.lifted.Tag
import play.api.Play.current

/**
  * Created by aputtaraksa on 12/27/2015.
  */
class PlaceBtsSchema(tag: Tag) extends Table[PlaceBts](tag, "place_near_bts"){
  def btsId = column[Short]("bts_id", O.PrimaryKey)
  def placeId = column[Int]("place_id", O.PrimaryKey)
  def rank = column[Short]("rank")
  def distance = column[Short]("distance")
  def created = column[String]("created")
  def created_by = column[String]("created_by")
  def modified = column[Option[String]]("modified")
  def modified_by = column[Option[String]]("modified_by")

  override def * = (btsId, placeId, rank, distance, created, created_by, modified, modified_by) <> (PlaceBts.tupled, PlaceBts.unapply)
}

object PlaceBtsTable {
  val placeBts = TableQuery[PlaceBtsSchema]

  def getBtsNearPlaceById(placeId: Int): List[PlaceBts]= {
    Database.forDataSource(DB.getDataSource()) withSession { implicit session =>
      val selectedBts = placeBts.filter(_.placeId === placeId).sortBy(_.distance)
      selectedBts.list
    }
  }

  def getPlaceNearBtsById(btsId: Short): List[PlaceBts]= {
    Database.forDataSource(DB.getDataSource()) withSession { implicit session =>
      val selectedBts = placeBts.filter(_.btsId === btsId).sortBy(_.rank).sortBy(_.distance)
      selectedBts.list
    }
  }
}
