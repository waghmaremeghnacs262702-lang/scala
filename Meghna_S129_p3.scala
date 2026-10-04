object Meghna_S129_p3
import scala.io.Source


  def main(args: Array[String]): Unit = {

    // Read the text file
    val source = Source.fromFile("input.txt")

    val text = source.getLines().mkString(" ")

    source.close()

    // Tokenize the text into words
    val words = text
      .toLowerCase
      .replaceAll("[^a-zA-Z0-9\\s]", "")
      .split("\\s+")
      .filter(_.nonEmpty)

    // Count frequency of each word
    val wordFrequency = words
      .groupBy(identity)
      .view
      .mapValues(_.length)
      .toMap

    // Display words
    println("Tokens:")
    words.foreach(println)

    // Display word frequency
    println("\nWord Frequency:")
    println("----------------")

    wordFrequency.toSeq
      .sortBy(_._1)
      .foreach {
        case (word, count) =>
          println(word + " : " + count)
      }
  }
