import scala.scalajs.js
import js._
//import js.JSConverters._
//import concurrent.ExecutionContext.Implicits.global

object test11 {
  val jsp = new Promise[String](
    (resp: js.Function1[String|Thenable[String], _],
      rej: js.Function1[scala.Any, _]) => {
      resp("blah")
    })
  // val jspfut = jsp.toFuture
  // val jspfut2p = jspfut.toJSPromise

   def main(): Unit = {
  //   jspfut.onComplete(tryString => {
  //     // do something
  //   })
  }
}
