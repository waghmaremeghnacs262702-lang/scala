package prac15

import scala.io.Source
import breeze.plot._

object s129meghna_p15 {

  def main(args: Array[String]): Unit = {

    val source = Source.fromFile("AUBANK.NS.csv")
    val data = source.getLines().drop(1).take(50).toList
    source.close()

    // X-axis: record number
    val x = data.indices.map(_.toDouble)

    // Y-axis: Closing Price
    val closePrice = data.map { line =>
      line.split("[,\t]")(4).toDouble
    }

    val figure = Figure()
    val graph = figure.subplot(0)

    // Line graph
    graph += plot(x, closePrice)

    graph.xlabel = "Trading Day"
    graph.ylabel = "Closing Price"
    graph.title = "AU Bank Closing Price Trend"

    figure.refresh()
  }
}