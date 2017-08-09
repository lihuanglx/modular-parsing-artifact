package CaseStudy.ModClass

import CaseStudy.ModClass.Arith.TestArith
import CaseStudy.ModClass.Bot.TestBot
import CaseStudy.ModClass.EquiRec.TestEquiRec
import CaseStudy.ModClass.FullEquiRec.TestFullEquiRec
import CaseStudy.ModClass.FullError.TestFullError
import CaseStudy.ModClass.FullIsoRec.TestFullIsoRec
import CaseStudy.ModClass.FullOmega.TestFullOmega
import CaseStudy.ModClass.FullPoly.TestFullPoly
import CaseStudy.ModClass.FullRecon.TestFullRecon
import CaseStudy.ModClass.FullRef.TestFullRef
import CaseStudy.ModClass.FullSimple.TestFullSimple
import CaseStudy.ModClass.FullSub.TestFullSub
import CaseStudy.ModClass.FullUntyped.TestFullUntyped
import CaseStudy.ModClass.RcdSubBot.TestRcdSubBot
import CaseStudy.ModClass.Recon.TestRecon
import CaseStudy.ModClass.SimpleBool.TestSimpleBool
import CaseStudy.ModClass.TyArith.TestTyArith
import CaseStudy.ModClass.Untyped.TestUntyped

import scala.io.{Source, StdIn}

object Test {

  def runTest(name: String, f: => (String => Unit)): Unit = {
    val inputFile = "testsuite/" + name + ".tapl"
    val lines: List[String] = Source.fromFile(inputFile).getLines().toList
    val t0 = System.nanoTime()
    lines.foreach(f)
    val t1 = System.nanoTime()
    println((t1 - t0) / 1000000)
  }

  def main(args: Array[String]): Unit = {
    print("Calculus name: ")
    val name = StdIn.readLine().toLowerCase

    val fn: String => Unit = name match {
      case "arith" => TestArith.parseAndPrint
      case "untyped" => TestUntyped.parseAndPrint
      case "fulluntyped" => TestFullUntyped.parseAndPrint
      case "tyarith" => TestTyArith.parseAndPrint
      case "simplebool" => TestSimpleBool.parseAndPrint
      case "fullsimple" => TestFullSimple.parseAndPrint
      case "bot" => TestBot.parseAndPrint
      case "fullref" => TestFullRef.parseAndPrint
      case "fullerror" => TestFullError.parseAndPrint
      case "rcdsubbot" => TestRcdSubBot.parseAndPrint
      case "fullsub" => TestFullSub.parseAndPrint
      case "fullequirec" => TestFullEquiRec.parseAndPrint
      case "fullisorec" => TestFullIsoRec.parseAndPrint
      case "equirec" => TestEquiRec.parseAndPrint
      case "recon" => TestRecon.parseAndPrint
      case "fullrecon" => TestFullRecon.parseAndPrint
      case "fullpoly" => TestFullPoly.parseAndPrint
      case "fullomega" => TestFullOmega.parseAndPrint
      case _ => sys.error("Incorrect name")
    }
    runTest(name, fn)
  }

}
