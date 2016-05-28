import java.io.File

import org.junit.Test

class SchemaGenerator {

  @Test
  def testCodeGenerate() {
    val cur = new File(".")
    println(cur.getAbsolutePath)

    val slickDriver = "slick.driver.MySQLDriver"
    val jdbcDriver = "com.mysql.jdbc.Driver"
    val url = "jdbc:mysql://localhost/slick_sample2"
    val outputFolder = "./app"
    val user = "root"
    val password = ""
    val pkg = "models"

    slick.codegen.SourceCodeGenerator.main(
      Array(slickDriver, jdbcDriver, url, outputFolder, pkg, user, password)
    )
  }
}