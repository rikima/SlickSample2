package controllers

import javax.inject.Inject

import play.api.data._
import play.api.data.Forms._
import play.api.mvc._
import play.api.libs.concurrent.Execution.Implicits.defaultContext

import dao.CatDao
//import models.Cat

import models.Tables.CatRow


class Application @Inject() (cats: CatDao) extends Controller {
  val catForm = Form(
    mapping(
      "name" -> text(),
      "color" -> text()
    )(CatRow.apply)(CatRow.unapply)
  )

  def index = Action.async {
    cats.all.map { case cs => Ok(views.html.index(cs)) }
  }

  def insertCat = Action.async { implicit rs =>
    val cat: CatRow = catForm.bindFromRequest.get
    cats.insert(cat).map(_ => Redirect(routes.Application.index))
  }

}
