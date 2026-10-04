import scala.io.Source

object Practical4 {

  def main(args: Array[String]): Unit = {

    // Read dataset from CSV file
    val data = Source.fromFile("students.csv")
      .getLines()
      .drop(1)
      .map { line =>
        val parts = line.split(",")
        (parts(0), parts(1).toInt)
      }
      .toList

    // Sort by Marks in descending order
    val sortedData = data.sortBy(-_._2)

    // Extract top 5 rows
    val top5 = sortedData.take(5)

    // Display result
    println("Top 5 Students by Marks")
    println("-----------------------")
    println("Name\tMarks")

    for ((name, marks) <- top5) {
      println(s"$name\t$marks")
    }
  }
}