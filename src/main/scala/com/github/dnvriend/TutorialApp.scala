package com.github.dnvriend

import scala.concurrent.Future
import scala.scalajs.js.JSApp
import org.scalajs.dom
import dom.document

// following the tutorial
object TutorialApp extends JSApp {
  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    val textNode = document.createTextNode(text)
    parNode.appendChild(textNode)
    targetNode.appendChild(parNode)
  }

  def main(): Unit = {
    import scala.concurrent.ExecutionContext.Implicits.global
    appendPar(document.body, "Hello World")
    Future(appendPar(document.body, "first"))
      .flatMap(_ => Future(appendPar(document.body, "second")))

    List("a", "b", "c").zipWithIndex.foreach {
      case (h, i) =>  appendPar(document.body, s"$h$i")
    }

    case class Person(name: String, age: Int)
    val xs = List(Person("Foo", 25), Person("Bar", 30), Person("Baz", 35))
    xs.foreach(println)
    xs.foreach(p => appendPar(document.body, p.toString))

//    (1 to 100).toStream.foreach(i => appendPar(document.body, i.toString))

//    for {
//      a <- "abcdefghijklmnopqrstuvwxyz"
//      b <- "abcdefghijklmnopqrstuvwxyz"
//      c <- "abcdefghijklmnopqrstuvwxyz"
//    } appendPar(document.body, s"$a$b$c")

    println("Hello world!")
  }
}
