package CaseStudy.ModClass.EquiRec

import CaseStudy.ModClass.FullSimple.TypeVar
import CaseStudy.ModClass.Lib._
import CaseStudy.ModClass.SimpleBool.Typed
import CaseStudy.ModClass.FullEquiRec.RecType


object EquiRec {

  trait Parser extends Typed.Parser with RecType.Parser with TypeVar.Parser {

    val pEquiRecE: PackratParser[Term] = pTypedE
    val pEquiRecT: PackratParser[Ty] = pTypedT ||| pRecTypeT ||| pTypeVarT

    override val pE: PackratParser[Term] = pEquiRecE
    override val pT: PackratParser[Ty] = pEquiRecT
  }

}

object TestEquiRec {

  def parseAndPrint(inp: String): Unit = {
    val p = new EquiRec.Parser {}
    println(parse(p.pE)(inp))
  }

}