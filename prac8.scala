import com.github.tototoshi.csv._

object Practical8 {

  def main(args: Array[String]): Unit = {

    val file = new java.io.File("Titanic-Dataset.csv")

    val reader = CSVReader.open(file)

    val data = reader.allWithHeaders()

    reader.close()

    println("Basic Statistics of Numeric Columns")
    println("-----------------------------------")

    val columns = List("Age", "Fare", "SibSp", "Parch", "Pclass")

    for (column <- columns) {

      val values = data
        .flatMap(row => row.get(column))
        .flatMap(value =>
          try {
            Some(value.toDouble)
          } catch {
            case _: NumberFormatException => None
          }
        )

      if (values.nonEmpty) {

        val mean = values.sum / values.size
        val min = values.min
        val max = values.max

        val variance =
          values.map(x => math.pow(x - mean, 2)).sum / values.size

        val standardDeviation = math.sqrt(variance)

        println("\nColumn: " + column)
        println("Count: " + values.size)
        println("Mean: " + mean)
        println("Minimum: " + min)
        println("Maximum: " + max)
        println("Standard Deviation: " + standardDeviation)
      }
    }
  }
}