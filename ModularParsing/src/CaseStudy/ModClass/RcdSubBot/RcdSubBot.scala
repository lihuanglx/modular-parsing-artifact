package CaseStudy.ModClass.RcdSubBot

import CaseStudy.ModClass.Lib._
import CaseStudy.ModClass.Bot.Bot
import CaseStudy.ModClass.FullSimple.TypedRecord


object RcdSubBot {

  trait Parser extends Bot.Parser with TypedRecord.Parser {

    val pRcdSubBotE: PackratParser[Term] = pBotE ||| pTypedRecordE
    val pRcdSubBotT: PackratParser[Ty] = pBotT ||| pTypedRecordT

    override val pE: PackratParser[Term] = pRcdSubBotE
    override val pT: PackratParser[Ty] = pRcdSubBotT
  }

}

object TestRcdSubBot {
  def parseAndPrint(inp: String): Unit = {
    val p = new RcdSubBot.Parser {}
    println(parse(p.pE)(inp))
  }

}