import breeze.stats.regression.leastSquares
import scala.io.Source
import breeze.linalg.{DenseMatrix, DenseVector}
import breeze.stats.regression.leastSquares

object Practical5 {

  def main(args: Array[String]): Unit = {

    // Read dataset from CSV file
    val data = Source.fromFile("study_data.csv")
      .getLines()
      .drop(1)
      .map { line =>
        val parts = line.split(",")
        (parts(0).toDouble, parts(1).toDouble)
      }
      .toList

    // Separate X and Y values
    val x = DenseVector(data.map(_._1).toArray)
    val y = DenseVector(data.map(_._2).toArray)

    println("Original Dataset:")
    println("Study Hours\tScore")

    for ((hours, score) <- data) {
      println(s"$hours\t\t$score")
    }

    // Create intercept column
    val ones = DenseVector.ones[Double](x.length)

    // Create design matrix
    val X = DenseMatrix.horzcat(
      ones.asDenseMatrix.t,
      x.asDenseMatrix.t
    )

    // Apply linear regression using least squares
    val regressionResult = leastSquares(X, y)

    // Get coefficients
    val coefficients = regressionResult.coefficients

    println("\nLinear Regression Coefficients:")
    println(s"Intercept: ${coefficients(0)}")
    println(s"Slope: ${coefficients(1)}")

    // Predict score for 6 study hours
    val newX = 6.0

    val predictedY =
      coefficients(0) + coefficients(1) * newX

    println(s"\nPrediction for $newX study hours:")
    println(s"Predicted Score: $predictedY")
  }
}