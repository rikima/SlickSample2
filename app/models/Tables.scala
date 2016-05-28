package models
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.driver.MySQLDriver
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.driver.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Cat.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Cat
   *  @param name Database column name SqlType(VARCHAR), PrimaryKey, Length(254,true)
   *  @param color Database column color SqlType(TEXT) */
  case class CatRow(name: String, color: String)
  /** GetResult implicit for fetching CatRow objects using plain SQL queries */
  implicit def GetResultCatRow(implicit e0: GR[String]): GR[CatRow] = GR{
    prs => import prs._
    CatRow.tupled((<<[String], <<[String]))
  }
  /** Table description of table CAT. Objects of this class serve as prototypes for rows in queries. */
  class Cat(_tableTag: Tag) extends Table[CatRow](_tableTag, "CAT") {
    def * = (name, color) <> (CatRow.tupled, CatRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(name), Rep.Some(color)).shaped.<>({r=>import r._; _1.map(_=> CatRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column name SqlType(VARCHAR), PrimaryKey, Length(254,true) */
    val name: Rep[String] = column[String]("name", O.PrimaryKey, O.Length(254,varying=true))
    /** Database column color SqlType(TEXT) */
    val color: Rep[String] = column[String]("color")
  }
  /** Collection-like TableQuery object for table Cat */
  lazy val Cat = new TableQuery(tag => new Cat(tag))
}
