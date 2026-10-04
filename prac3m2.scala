import scala.io.Source

object Practical3 {

  def main(args: Array[String]): Unit = {

    // Read dataset
    val data = Source.fromFile("frequency_data.csv")
      .getLines()
      .drop(1)
      .map(_.toInt)
      .toList

    // Calculate frequency
    val frequency = data.groupBy(identity)
      .view
      .mapValues(_.size)
      .toMap

    // Sort values
    val sortedFrequency = frequency.toSeq.sortBy(_._1)

    println("Value\tFrequency\tCumulative Frequency")

    var cumulative = 0

    for ((value, freq) <- sortedFrequency) {

      cumulative += freq

      println(s"$value\t$freq\t\t$cumulative")
    }
  }
}