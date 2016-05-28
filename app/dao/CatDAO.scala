package dao

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

import javax.inject.Inject

import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider

import slick.driver.JdbcProfile

//import models.Cat
import models.Tables.Cat
import models.Tables.CatRow

class CatDao @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)
  extends HasDatabaseConfigProvider[JdbcProfile] {

  import driver.api._

  //private val cats = TableQuery[CatsTable]
  // ddl
  db.run(Cat.schema.create)

  def all(): Future[Seq[CatRow]] = db.run(Cat.result)

  def insert(cat: CatRow): Future[Unit] = db.run(Cat += cat).map { _ => () }

  /*
  private class CatsTable(tag: Tag) extends Table[Cat](tag, "CAT") {
    def name  = column[String]("name", O.PrimaryKey)
    def color = column[String]("color")

    def * = (name, color) <> (Cat.tupled, Cat.unapply _)
  }
  */

}