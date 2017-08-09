package CaseStudy.ModClass.FullSub

import CaseStudy.ModClass.Lib._
import CaseStudy.ModClass.Bot.Top
import CaseStudy.ModClass.FullSimple.Simple


object FullSub {

  trait Parser extends Simple.Parser with Top.Parser {

    val pFullSubE: PackratParser[Term] = pSimpleE
    val pFullSubT: PackratParser[Ty] = pSimpleT ||| pTopT

    override val pE: PackratParser[Term] = pFullSubE
    override val pT: PackratParser[Ty] = pFullSubT
  }

}

object TestFullSub {
  def parseAndPrint(inp: String): Unit = {
    val p = new FullSub.Parser {}
    println(parse(p.pE)(inp))
  }

}
