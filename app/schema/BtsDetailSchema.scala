package schema

import models.BtsMove
import play.api.Play.current
import play.api.db.DB

import scala.slick.driver.PostgresDriver.simple._
import scala.slick.lifted.Tag

/**
  * Created by aputtaraksa on 12/28/2015.
  */

// TODO: consider we should use this class or not
class BtsDetailSchema(tag: Tag) extends Table[BtsMove](tag, "bts_move"){

  def startId = column[Short]("start_id", O.PrimaryKey)
  def terminalId = column[Short]("terminal_id", O.PrimaryKey)
  def cost = column[Double]("cost")
  def created = column[String]("created")
  def created_by = column[String]("created_by")
  def modified = column[Option[String]]("modified")
  def modified_by = column[Option[String]]("modified_by")

  override def * = (startId, terminalId, cost, created, created_by, modified, modified_by) <> (BtsMove.tupled, BtsMove.unapply)
}

object BtsDetailTable {
  val btsMove = TableQuery[BtsMoveSchema]

  def getBtsMove(): List[BtsMove] = {
    Database.forDataSource(DB.getDataSource()) withSession { implicit session =>
      btsMove.list
    }
  }
}