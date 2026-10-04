import breeze.linalg._

object Practical7 {
  def main(args: Array[String]): Unit = {

    val matrixA = DenseMatrix(
      (10.0, 20.0),
      (30.0, 40.0)
    )

    val matrixB = DenseMatrix(
      (2.0, 4.0),
      (5.0, 8.0)
    )

    println("Matrix A:")
    println(matrixA)

    println("\nMatrix B:")
    println(matrixB)

    val addition = matrixA + matrixB
    val subtraction = matrixA - matrixB

    // Element-wise multiplication
    val multiplication = matrixA *:* matrixB

    // Element-wise division
    val division = matrixA /:/ matrixB

    println("\nElement-wise Addition:")
    println(addition)

    println("\nElement-wise Subtraction:")
    println(subtraction)

    println("\nElement-wise Multiplication:")
    println(multiplication)

    println("\nElement-wise Division:")
    println(division)
  }
}