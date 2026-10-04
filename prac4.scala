import breeze.linalg.DenseVector

object s129meghna_p4 {
  def main(args: Array[String]): Unit = {

    val vector1 = DenseVector(1.0, 2.0, 3.0, 4.0, 5.0)
    val vector2 = DenseVector(5.0, 4.0, 3.0, 2.0, 1.0)

    val sum = breeze.linalg.sum(vector1)

    val mean = sum / vector1.length

    val dotProduct = vector1 dot vector2

    println("Vector 1: " + vector1)
    println("Vector 2: " + vector2)
    println("Sum of Vector 1: " + sum)
    println("Mean of Vector 1: " + mean)
    println("Dot Product: " + dotProduct)
  }
}