import scala.io.Source
import breeze.linalg._
import breeze.numerics.sigmoid

object Practical6 {

  def main(args: Array[String]): Unit = {

    // Read dataset from CSV file
    val data = Source.fromFile("logistic_data.csv")
      .getLines()
      .drop(1)
      .map { line =>
        val parts = line.split(",")

        (
          parts(0).toDouble,
          parts(1).toDouble,
          parts(2).toDouble
        )
      }
      .toList

    val n = data.length

    // Create feature matrix
    val X = DenseMatrix(
      data.map(x => Array(1.0, x._1, x._2)): _*
    )

    // Create target vector
    val y = DenseVector(
      data.map(_._3).toArray
    )

    // Display dataset
    println("Dataset:")
    println("StudyHours\tAttendance\tResult")

    for ((hours, attendance, result) <- data) {
      println(s"$hours\t\t$attendance\t\t$result")
    }

    // Initial weights
    var weights = DenseVector.zeros[Double](3)

    // Learning rate
    val learningRate = 0.01

    // Number of iterations
    val iterations = 10000

    // Train logistic regression
    for (iteration <- 0 until iterations) {

      // Calculate prediction
      val z = X * weights
      val predictions = sigmoid(z)

      // Calculate gradient manually
      val gradient = DenseVector.zeros[Double](3)

      for (j <- 0 until 3) {

        var sum = 0.0

        for (i <- 0 until n) {
          sum += (predictions(i) - y(i)) * X(i, j)
        }

        gradient(j) = sum / n
      }

      // Update weights
      for (j <- 0 until 3) {
        weights(j) =
          weights(j) - learningRate * gradient(j)
      }
    }

    println("\nLogistic Regression Model:")
    println(s"Intercept: ${weights(0)}")
    println(s"Study Hours Weight: ${weights(1)}")
    println(s"Attendance Weight: ${weights(2)}")

    // New student
    val newStudent =
      DenseVector(1.0, 6.0, 85.0)

    // Calculate probability
    val probability =
      sigmoid(newStudent dot weights)

    println("\nPrediction for New Student:")
    println("Study Hours: 6")
    println("Attendance: 85")

    println(
      f"Probability of Passing: $probability%.4f"
    )

    // Classification
    if (probability >= 0.5) {
      println("Predicted Class: 1 (Pass)")
    } else {
      println("Predicted Class: 0 (Fail)")
    }
  }
}