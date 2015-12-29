import play.api.Play.current
import play.api.db.DB
import play.api.http.HeaderNames
import play.api.mvc.{WithFilters, Filter, Result, RequestHeader}
import play.api.{Application, GlobalSettings}
import schema.StationTable._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.slick.driver.PostgresDriver.simple._

object Global extends WithFilters(CorsFilter) with GlobalSettings {

  override def onStart(app: Application) {
    lazy val database = Database.forDataSource(DB.getDataSource())

    database withSession { implicit session =>
      println(station.countDistinct)
//      if (MTable.getTables(users.baseTableRow.tableName).list.isEmpty) {
//      	users.ddl.create
//      }
    }
  }
}


object CorsFilter extends Filter {

  def apply (nextFilter: (RequestHeader) => Future[Result])(requestHeader: RequestHeader): Future[Result] = {

    nextFilter(requestHeader).map { result =>
      result.withHeaders(HeaderNames.ACCESS_CONTROL_ALLOW_ORIGIN -> "*",
        HeaderNames.ALLOW -> "*",
        HeaderNames.ACCESS_CONTROL_ALLOW_METHODS -> "POST, GET, PUT, DELETE, OPTIONS",
        HeaderNames.ACCESS_CONTROL_ALLOW_HEADERS -> "Origin, X-Requested-With, Content-Type, Accept, Referer, User-Agent"
      )
    }
  }
}