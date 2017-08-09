package CaseStudy.ModClass.Recon

import CaseStudy.ModClass.FullSimple.TypeVar
import CaseStudy.ModClass.Lib._
import CaseStudy.ModClass.SimpleBool.Typed
import CaseStudy.ModClass.TyArith.TyArith


object Recon {
  
  trait Parser extends TyArith.Parser with Typed.Parser with TypeVar.Parser {

    val pReconE: PackratParser[Term] = pTypedE ||| pTyArithE
    val pReconT: PackratParser[Ty] = pTypedT ||| pTyArithT ||| pTypeVarT

    override val pE: PackratParser[Term] = pReconE
    override val pT: PackratParser[Ty] = pReconT
  }

}

object TestRecon {

  def parseAndPrint(inp: String): Unit = {
    val p = new Recon.Parser {}
    println(parse(p.pE)(inp))
  }

}