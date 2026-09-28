object PolynomialFeatures {

  def main(args: Array[String]): Unit = {

    // Input data
    val numbers = List(1, 2, 3)

    // Maximum polynomial degree
    val degree = 3

    println("Original Data:")
    println(numbers)

    // Generate polynomial features
    val polynomialFeatures = numbers.flatMap { x =>
      (1 to degree).map { d =>
        Math.pow(x, d).toInt
      }
    }

    println("\nPolynomial Features up to Degree 3:")
    println(polynomialFeatures)
  }
}
