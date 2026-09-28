import scala.util.Random

object TimeSeriesAnalysis {

  def main(args: Array[String]): Unit = {

    // Generate synthetic daily sales for 30 days
    val random = new Random()

    val sales = (1 to 30).map { day =>
      val amount = 1000 + random.nextInt(1000)
      (day, amount)
    }

    println("===== DAILY SALES DATA =====")

    sales.foreach {
      case (day, amount) =>
        println(s"Day $day : Rs.$amount")
    }

    // Calculate total sales
    val totalSales = sales.map(_._2).sum

    // Calculate average sales
    val averageSales = totalSales.toDouble / sales.length

    // Find maximum sales
    val maximumSale = sales.maxBy(_._2)

    // Find minimum sales
    val minimumSale = sales.minBy(_._2)

    println("\n===== TIME SERIES ANALYSIS =====")

    println(s"Total Sales   : Rs.$totalSales")
    println(f"Average Sales : Rs.$averageSales%.2f")
    println(s"Maximum Sales : Day ${maximumSale._1} = Rs.${maximumSale._2}")
    println(s"Minimum Sales : Day ${minimumSale._1} = Rs.${minimumSale._2}")
  }
}