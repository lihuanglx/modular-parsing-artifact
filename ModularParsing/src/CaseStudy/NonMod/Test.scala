package CaseStudy.NonMod

import CaseStudy.NonMod.Print._
import CaseStudy.NonMod.arith.{ArithParsers, ArithPrinter}
import CaseStudy.NonMod.bot.{BotParsers, BotPrinter}
import CaseStudy.NonMod.equirec.{EquiRecParsers, EquiRecPrinter}
import CaseStudy.NonMod.fullequirec.{FullEquiRecParsers, FullEquiRecPrinter}
import CaseStudy.NonMod.fullerror.{FullErrorParsers, FullErrorPrinter}
import CaseStudy.NonMod.fullisorec.{FullIsoRecParsers, FullIsoRecPrinter}
import CaseStudy.NonMod.fullomega.{FullOmegaParsers, FullOmegaPrinter}
import CaseStudy.NonMod.fullpoly.{FullPolyParsers, FullPolyPrinter}
import CaseStudy.NonMod.fullrecon.{FullReconParsers, FullReconPrinter}
import CaseStudy.NonMod.fullref.{FullRefParsers, FullRefPrinter}
import CaseStudy.NonMod.fullsimple.{FullSimpleParsers, FullSimplePrinter}
import CaseStudy.NonMod.fullsub.{FullSubParsers, FullSubPrinter}
import CaseStudy.NonMod.fulluntyped.{FullUntypedParsers, FullUntypedPrinter}
import CaseStudy.NonMod.rcdsubbot.{RcdSubBotParsers, RcdSubBotPrinter}
import CaseStudy.NonMod.recon.{ReconParsers, ReconPrinter}
import CaseStudy.NonMod.simplebool.{SimpleBoolParsers, SimpleBoolPrinter}
import CaseStudy.NonMod.tyarith.{TyArithParsers, TyArithPrinter}
import CaseStudy.NonMod.untyped.{UntypedParsers, UntypedPrinter}

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
