package prac5

import breeze.linalg._

object prac5 {

  def main(args: Array[String]): Unit = {

    // Hardcoded 3x3 Matrix
    val matrix = DenseMatrix(
      (1.0, 2.0, 3.0),
      (4.0, 5.0, 6.0),
      (7.0, 8.0, 9.0)
    )

    // Transpose
    val transpose = matrix.t

    // Determinant
    val determinant = det(matrix)

    println("Original Matrix:")
    println(matrix)

    println("\nTranspose:")
    println(transpose)

    println("\nDeterminant:")
    println(determinant)
  }
}