----------------------------------------------------------------------------------------
*** Overview ***
----------------------------------------------------------------------------------------

This artifact supplements the paper "Type-Safe Modular Parsing" with its code for case study.

The case study includes 18 calculi from TAPL (Types and Programming Languages):
* Arith
* Untyped
* FullUntyped
* TyArith
* SimpleBool
* FullSimple
* Bot
* FullRef
* FullError
* RcdSubBot
* FullSub
* FullEquiRec
* FullIsoRec
* EquiRec
* Recon
* FullRecon
* FullPoly
* FullOmega

As illustrated in the paper, there are four versions implementing the parsers of the 18 calculi:
- ModOA:    modular version with Object Algebras
- ModClass: modular version with classes
- NonMod:   non-modular version, modified from https://github.com/ilya-klyuchnikov/tapl-scala
- NonModLM: non-modular version with longest-match alternative combinator (|||)

----------------------------------------------------------------------------------------
*** Instructions ***
----------------------------------------------------------------------------------------

The code is in Scala and developed by Scala Eclipse. Therefore Windows is the recommended OS.

The Scala project is self-contained, thus additional library is not needed.

Scala version: 2.11.8
JRE version: 1.8

Please directly import the project "ModularParsing" into Scala Eclipse.

Note: Sometimes Scala Eclipse is problematic with the compilation on-the-fly. Please try to
open the files that give build errors for IDE to recognize.

----------------------------------------------------------------------------------------
*** Folder: ModularParsing\testsuite\ ***
----------------------------------------------------------------------------------------

Randomly generated test cases. Each file contains 500 expressions of one calculus.

----------------------------------------------------------------------------------------
*** Folder: ModularParsing\src\CaseStudy\ModOA\ ***
----------------------------------------------------------------------------------------

1) Run "ModularParsing\src\CaseStudy\ModOA\Test.scala".
2) Input the calculus name: (for example, "arith", "untyped", ...), and press enter.
3) The program will parse and pretty-print all the expressions of that calculus from
   testsuite, and finally output the execution time (ms).

----------------------------------------------------------------------------------------
*** Folder: ModularParsing\src\CaseStudy\ModClass\ ***
----------------------------------------------------------------------------------------

1) Run "ModularParsing\src\CaseStudy\ModClass\Test.scala".
2) Input the calculus name: (for example, "arith", "untyped", ...), and press enter.
3) The program will parse and pretty-print all the expressions of that calculus from
   testsuite, and finally output the execution time (ms).

----------------------------------------------------------------------------------------
*** Folder: ModularParsing\src\CaseStudy\NonMod\ ***
----------------------------------------------------------------------------------------

1) Run "ModularParsing\src\CaseStudy\NonMod\Test.scala".
2) Input the calculus name: (for example, "arith", "untyped", ...), and press enter.
3) The program will parse and pretty-print all the expressions of that calculus from
   testsuite, and finally output the execution time (ms).

----------------------------------------------------------------------------------------
*** Folder: ModularParsing\src\CaseStudy\NonModLM\ ***
----------------------------------------------------------------------------------------

1) Run "ModularParsing\src\CaseStudy\NonModLM\Test.scala".
2) Input the calculus name: (for example, "arith", "untyped", ...), and press enter.
3) The program will parse and pretty-print all the expressions of that calculus from
   testsuite, and finally output the execution time (ms).
