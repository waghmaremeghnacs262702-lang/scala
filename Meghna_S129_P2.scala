object Meghna_S129_P2 {

  def main(args: Array[String]): Unit = {

    val numbers = List(10, 20, 20, 30, 40, 20, 50)

    // Mean
    val mean = numbers.sum.toDouble / numbers.size

    // Median
    val sorted = numbers.sorted
    val median =
      if (sorted.size % 2 == 1)
        sorted(sorted.size / 2).toDouble
      else
        (sorted(sorted.size / 2 - 1) + sorted(sorted.size / 2)).toDouble / 2

    println("Numbers: " + numbers)
    println("Mean: " + mean)
    println("Median: " + median)
  }
}
