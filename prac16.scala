package prac16

import scala.io.Source
import breeze.plot._

object s129meghna_p16 {

  def main(args: Array[String]): Unit = {

    // Read AU Bank dataset
    val source = Source.fromFile("AUBANK.NS.csv")
    val data = source.getLines().drop(1).take(50).toList
    source.close()

    // X-axis: record number
    val x = data.indices.map(_.toDouble)

    // Close price is column 4
    val closePrice = data.map { line =>
      line.split("[,\t]")(4).toDouble
    }

    // Create one figure
    val figure = Figure()
    val graph = figure.subplot(0)

    // Line plot
    graph += plot(x, closePrice)

    // Scatter plot
    graph += scatter(
      x,
      closePrice,
      (_: Int) => 0.5,
      (_: Int) => java.awt.Color.RED
    )

    // Labels
    graph.xlabel = "Trading Day"
    graph.ylabel = "Closing Price"
    graph.title = "AU Bank Line and Scatter Plot"

    // Display
    figure.refresh()
  }
}