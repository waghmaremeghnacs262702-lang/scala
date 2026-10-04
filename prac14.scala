package prac14

import scala.io.Source
import breeze.plot._

object s129meghna_p14 {

  def main(args: Array[String]): Unit = {

    // Read Iris.csv
    val source = Source.fromFile("Iris.csv")
    val data = source.getLines().drop(1).toList
    source.close()

    // Get Sepal Length values
    val sepalLength = data.map { line =>
      line.split(",")(1).toDouble
    }

    // Create histogram
    val figure = Figure()
    val plot = figure.subplot(0)

    plot += hist(sepalLength, 10)

    // Labels
    plot.xlabel = "Sepal Length"
    plot.ylabel = "Frequency"
    plot.title = "Histogram of Iris Sepal Length"

    // Display graph
    figure.refresh()
  }
}