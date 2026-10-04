package prac13

import scala.io.Source
import breeze.plot._

object s129meghna_p13 {

  def main(args: Array[String]): Unit = {

    // Read Iris.csv
    val source = Source.fromFile("Iris.csv")
    val data = source.getLines().drop(1).toList
    source.close()

    // Separate the three species
    val setosa = data.filter(_.contains("Iris-setosa")).map(_.split(","))
    val versicolor = data.filter(_.contains("Iris-versicolor")).map(_.split(","))
    val virginica = data.filter(_.contains("Iris-virginica")).map(_.split(","))

    // Sepal Length = column 1
    // Petal Length = column 3
    val setosaX = setosa.map(row => row(1).toDouble)
    val setosaY = setosa.map(row => row(3).toDouble)

    val versicolorX = versicolor.map(row => row(1).toDouble)
    val versicolorY = versicolor.map(row => row(3).toDouble)

    val virginicaX = virginica.map(row => row(1).toDouble)
    val virginicaY = virginica.map(row => row(3).toDouble)

    // Create figure
    val figure = Figure()
    val plot = figure.subplot(0)

    // Scatter plots
    plot += scatter(
      setosaX,
      setosaY,
      (_: Int) => 0.5,
      (_: Int) => java.awt.Color.RED
    )

    plot += scatter(
      versicolorX,
      versicolorY,
      (_: Int) => 0.5,
      (_: Int) => java.awt.Color.BLUE
    )

    plot += scatter(
      virginicaX,
      virginicaY,
      (_: Int) => 0.5,
      (_: Int) => java.awt.Color.GREEN
    )

    // Labels
    plot.xlabel = "Sepal Length"
    plot.ylabel = "Petal Length"
    plot.title = "Iris Scatter Plot"

    // Display graph
    figure.refresh()
  }
}