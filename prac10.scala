import com.github.tototoshi.csv._

object Practical10 {

  def main(args: Array[String]): Unit = {

    val file = new java.io.File("Titanic-Dataset.csv")

    val reader = CSVReader.open(file)
    val data = reader.allWithHeaders()
    reader.close()

    // Set threshold
    val threshold = 50.0

    // Filter rows where Fare > 50
    val filteredData = data.filter { row =>

      row.get("Fare") match {

        case Some(value) =>
          try {
            value.toDouble > threshold
          } catch {
            case _: NumberFormatException => false
          }

        case None =>
          false
      }
    }

    println("Passengers with Fare greater than 50")
    println("====================================")

    filteredData.foreach { row =>

      val passengerId =
        row.getOrElse("PassengerId", "")

      val name =
        row.getOrElse("Name", "")

      val age =
        row.getOrElse("Age", "")

      val fare =
        row.getOrElse("Fare", "")

      println(
        "ID: " + passengerId +
          " | Name: " + name +
          " | Age: " + age +
          " | Fare: " + fare
      )
    }

    println("\nTotal rows satisfying condition: " +
      filteredData.size)
  }
}