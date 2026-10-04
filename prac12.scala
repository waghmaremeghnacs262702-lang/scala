package prac12

import scala.io.Source

object s129meghna_p12 {

  def main(args: Array[String]): Unit = {

    val source = Source.fromFile("Iris.csv")
    val lines = source.getLines().toList
    source.close()

    val data = lines.tail

    println("One-Hot Encoding of Species")
    println("===========================")

    data.take(10).foreach { line =>

      val columns = line.split(",")

      val id = columns(0)
      val species = columns(5)

      val encoding = species match {
        case "Iris-setosa" =>
          "1, 0, 0"

        case "Iris-versicolor" =>
          "0, 1, 0"

        case "Iris-virginica" =>
          "0, 0, 1"

        case _ =>
          "0, 0, 0"
      }

      println(
        "ID: " + id +
          " | Species: " + species +
          " | One-Hot: " + encoding
      )
    }
  }
}