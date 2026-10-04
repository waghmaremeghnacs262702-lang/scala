package prac11

import scala.io.Source

object s129meghna_p11 {

  def main(args: Array[String]): Unit = {

    val source = Source.fromFile("input.txt")
    val text = source.getLines().mkString(" ")
    source.close()

    val words = text
      .toLowerCase
      .replaceAll("[^a-zA-Z0-9\\s]", "")
      .split("\\s+")
      .filter(_.nonEmpty)

    val wordFrequency = words
      .groupBy(identity)
      .view
      .mapValues(_.length)
      .toMap

    println("Tokens:")
    words.foreach(println)

    println("\nWord Frequency:")
    println("----------------")

    wordFrequency.toSeq
      .sortBy(_._1)
      .foreach {
        case (word, count) =>
          println(word + " : " + count)
      }
  }
}