import scala.scalajs.js

trait Test3 extends js.Object {
  var x: Int
}

object test3 {
  def main(args: Array[String]): Unit = {
    val test3 = new Test3 {
      var x = 10
    }
  }
}
