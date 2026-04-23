package com.alecdorrington

import com.alecdorrington.scalgebra.*
import com.alecdorrington.scalgebra.ordered.*

object Test:

  @main
  def main(): Unit = println(g(4))



  def g[X : EuclideanMonoid](x: X): X = x ** 3
