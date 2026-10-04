import breeze.linalg._

object Practical6 {

  def main(args: Array[String]): Unit = {

    // Create a 4 x 4 matrix
    val matrix = DenseMatrix(
      (1.0, 2.0, 3.0, 4.0),
      (5.0, 6.0, 7.0, 8.0),
      (9.0, 10.0, 11.0, 12.0),
      (13.0, 14.0, 15.0, 16.0)
    )

    println("Original Matrix:")
    println(matrix)

    // Extract sub-matrix: rows 1 to 2 and columns 1 to 2
    val subMatrix = matrix(1 to 2, 1 to 2)

    println("\nSub-Matrix:")
    println(subMatrix)

    // Calculate row sums
    val rowSums = sum(subMatrix(*, ::))

    // Calculate column sums
    val columnSums = sum(subMatrix(::, *))

    println("\nRow Sums:")
    println(rowSums)

    println("\nColumn Sums:")
    println(columnSums)
  }
}