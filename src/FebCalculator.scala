import scala.collection.mutable

object FebCalculator {
  var apr: Seq[Array[Int]] = Seq[Array[Int]]()
  var jan: Seq[Array[Int]] = Seq[Array[Int]]()
  var febPossibles: Seq[Array[Int]] = Seq[Array[Int]]()
  var janMayApr: mutable.ArrayBuffer[Array[Int]] = mutable.ArrayBuffer[Array[Int]]()

  def main(args: Array[String]): Unit = {
    println("Type feb to calculate Feb; ")
    val input = scala.io.StdIn.readLine()
    if(input == "feb") calculate()
  }

  def calculate(): Unit ={
    val t1 = System.nanoTime()
    jan = (124 to 1000 by 31).map(splitNum(_)).filter(noDuplicatesOrZeros _)
    apr = (210 to 1000 by 30).map(splitNum(_)).filter(noDuplicates _)
    febPossibles = (168 to 1000 by 28).map(splitNum(_)).filter(noDuplicatesOrZeros _)
    val feb = getFeb
    val t2 = System.nanoTime()
    println("Feb = " + feb)
    println("Time(microsecs) = " + (t2 - t1) / 1000)
  }

  def getFeb: Int = {
    var seq2 = jan.drop(1)
    for (array1 <- jan) {
      for (array2 <- seq2) {
        if (array1(1) == array2(1) && array1(0) != array2(0) && array1(0) != array2(2) && array1(2) != array2(0) && array1(2) != array2(2)) {
          apr.filter(x => x(2) == array2(1)).filter(array =>
            array(1) != array1(0) && array(1) != array1(2) && array(1) != array2(0) && array(1) != array2(2))
            .map(array => array1 ++ array2 ++ array)
            .map(array1 => for (array2 <- febPossibles) {
              if (array2(0) != array1(0) && array2(0) != array1(1) && array2(0) != array1(2) && array2(0) != array1(3) && array2(0) != array1(5) && array2(0) != array1(6) && array2(0) != array1(7) &&
                array2(1) != array1(0) && array2(1) != array1(1) && array2(1) != array1(2) && array2(1) != array1(3) && array2(1) != array1(5) && array2(1) != array1(6) && array2(1) != array1(7) &&
                array2(2) != array1(0) && array2(2) != array1(1) && array2(2) != array1(2) && array2(2) != array1(3) && array2(2) != array1(5) && array2(2) != array1(6) && array2(2) != array1(7)) {
                return array2(2) * 100 + array2(1) * 10 + array2(0)
              }
            })
        }
      }
      seq2 = seq2.drop(1)
    }
    0
  }

    def noDuplicatesOrZeros(array: Array[Int]): Boolean = {
      array match {
        case (Array(x, y, z)) if y == z => false
        case (Array(x, y, z)) if x == z => false
        case (Array(x, y, z)) if x == y => false
        case (Array(x, y, z)) if array contains 0 => false
        case _ => true
      }
    }

    def noDuplicates(array: Array[Int]): Boolean = {
      array match {
        case (Array(x, y, z)) if y == z => false
        case (Array(x, y, z)) if x == z => false
        case (Array(x, y, z)) if x == y => false
        case _ => true
      }
    }

    def splitNum(numToSplit: Int): Array[Int] = {
      var num = numToSplit
      val splitNum = new Array[Int](3)
      for (i <- 0 to 2) {
        splitNum(i) = num % 10
        num = num / 10
      }
      splitNum
    }

}
