import com.github.tototoshi.csv._

object Practical9 {

  def main(args: Array[String]): Unit = {

    val file = new java.io.File("Titanic-Dataset.csv")

    val reader = CSVReader.open(file)
    val data = reader.allWithHeaders()
    reader.close()

    // Get valid Age values
    val ageValues = data
      .flatMap(row => row.get("Age"))
      .flatMap(value =>
        try {
          Some(value.toDouble)
        } catch {
          case _: NumberFormatException => None
        }
      )

    // Calculate mean Age
    val meanAge = ageValues.sum / ageValues.size

    println("Mean Age = " + meanAge)

    // Count missing values
    val missingCount = data.count { row =>
      row.get("Age") match {
        case None => true
        case Some(value) =>
          value.trim.isEmpty
      }
    }

    println("Missing Age values = " + missingCount)

    // Replace missing Age with mean
    val updatedData = data.map { row =>

      val age = row.get("Age") match {

        case Some(value) if value.trim.nonEmpty =>
          value

        case _ =>
          meanAge.toString
      }

      row.updated("Age", age)
    }

    println("\nAfter replacing missing values:")
    println("--------------------------------")

    // Display first 10 records
    updatedData.take(10).foreach { row =>
      println(
        "PassengerId: " +
          row.getOrElse("PassengerId", "") +
          " | Age: " +
          row.getOrElse("Age", "")
      )
    }

    println("\nMissing values replaced successfully.")
  }
}