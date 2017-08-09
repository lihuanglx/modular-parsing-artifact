package CaseStudy.NonModLM

import CaseStudy.NonModLM.Print._
import CaseStudy.NonModLM.arith.{ArithParsers, ArithPrinter}
import CaseStudy.NonModLM.bot.{BotParsers, BotPrinter}
import CaseStudy.NonModLM.equirec.{EquiRecParsers, EquiRecPrinter}
import CaseStudy.NonModLM.fullequirec.{FullEquiRecParsers, FullEquiRecPrinter}
import CaseStudy.NonModLM.fullerror.{FullErrorParsers, FullErrorPrinter}
import CaseStudy.NonModLM.fullisorec.{FullIsoRecParsers, FullIsoRecPrinter}
import CaseStudy.NonModLM.fullomega.{FullOmegaParsers, FullOmegaPrinter}
import CaseStudy.NonModLM.fullpoly.{FullPolyParsers, FullPolyPrinter}
import CaseStudy.NonModLM.fullrecon.{FullReconParsers, FullReconPrinter}
import CaseStudy.NonModLM.fullref.{FullRefParsers, FullRefPrinter}
import CaseStudy.NonModLM.fullsimple.{FullSimpleParsers, FullSimplePrinter}
import CaseStudy.NonModLM.fullsub.{FullSubParsers, FullSubPrinter}
import CaseStudy.NonModLM.fulluntyped.{FullUntypedParsers, FullUntypedPrinter}
import CaseStudy.NonModLM.rcdsubbot.{RcdSubBotParsers, RcdSubBotPrinter}
import CaseStudy.NonModLM.recon.{ReconParsers, ReconPrinter}
import CaseStudy.NonModLM.simplebool.{SimpleBoolParsers, SimpleBoolPrinter}
import CaseStudy.NonModLM.tyarith.{TyArithParsers, TyArithPrinter}
import CaseStudy.NonModLM.untyped.{UntypedParsers, UntypedPrinter}

import scala.io.{Source, StdIn}
import scala.text.Document

object Test {

  def runTest(name: String, f: => (String => Unit)): Unit = {
    val inputFile = "testsuite/" + name + ".tapl"
    val lines: List[String] = Source.fromFile(inputFile).getLines().toList
    val t0 = System.nanoTime()
    lines.foreach(f)
    val t1 = System.nanoTime()
    println((t1 - t0) / 1000000)
  }

  def parseAndPrint[E](parse: String => E, print: E => Document)(inp: String): Unit = {
    val width = 60
    val e = parse(inp)
    println(printDoc(print(e), width))
  }

  def main(args: Array[String]): Unit = {
    print("Calculus name: ")
    val name = StdIn.readLine().toLowerCase

    val fn: String => Unit = name match {
      case "arith" => parseAndPrint(ArithParsers.input, ArithPrinter.ptm)
      case "untyped" => parseAndPrint(UntypedParsers.input, UntypedPrinter.ptm)
      case "fulluntyped" => parseAndPrint(FullUntypedParsers.input, FullUntypedPrinter.ptm)
      case "tyarith" => parseAndPrint(TyArithParsers.input, TyArithPrinter.ptm)
      case "simplebool" => parseAndPrint(SimpleBoolParsers.input, SimpleBoolPrinter.ptm)
      case "fullsimple" => parseAndPrint(FullSimpleParsers.input, FullSimplePrinter.ptm)
      case "bot" => parseAndPrint(BotParsers.input, BotPrinter.ptm)
      case "fullref" => parseAndPrint(FullRefParsers.input, FullRefPrinter.ptm)
      case "fullerror" => parseAndPrint(FullErrorParsers.input, FullErrorPrinter.ptm)
      case "rcdsubbot" => parseAndPrint(RcdSubBotParsers.input, RcdSubBotPrinter.ptm)
      case "fullsub" => parseAndPrint(FullSubParsers.input, FullSubPrinter.ptm)
      case "fullequirec" => parseAndPrint(FullEquiRecParsers.input, FullEquiRecPrinter.ptm)
      case "fullisorec" => parseAndPrint(FullIsoRecParsers.input, FullIsoRecPrinter.ptm)
      case "equirec" => parseAndPrint(EquiRecParsers.input, EquiRecPrinter.ptm)
      case "recon" => parseAndPrint(ReconParsers.input, ReconPrinter.ptm)
      case "fullrecon" => parseAndPrint(FullReconParsers.input, FullReconPrinter.ptm)
      case "fullpoly" => parseAndPrint(FullPolyParsers.input, FullPolyPrinter.ptm)
      case "fullomega" => parseAndPrint(FullOmegaParsers.input, FullOmegaPrinter.ptm)
      case _ => sys.error("Incorrect name")
    }
    runTest(name, fn)
  }
}
