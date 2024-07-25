package tst

@main def problem2Alternative(): Unit =
  println(allCombinablePromotions2(inputPromos))

def allCombinablePromotions2(allPromotions: Seq[Promotion]): Seq[PromotionCombo] = {
  val vertices: Set[String] = allPromotions.map(p => p.code).toSet
  // Invert notCombinableWith to for a graph of combinable promos
  allMaximalCliques(
    allPromotions
      .map(p => (p.code, vertices.diff(p.notCombinableWith.toSet + p.code)))
      .toMap,
  ).map(c => PromotionCombo(c.toList.sorted))
}

// Bron-Kerbosch algorithm
def allMaximalCliques(edges: Map[String, Set[String]]): List[Set[String]] = {

  def amcHelper(r: Set[String], p: Set[String], x: Set[String]): List[Set[String]] =
    if (p.isEmpty && x.isEmpty)
      if (r.isEmpty) Nil
      else List(r)
    else
      p.foldLeft((List.empty[Set[String]], p, x)) { case ((res, pp, xx), cur) =>
        val nv      = edges(cur)
        val cliques = amcHelper(r + cur, pp.intersect(nv), xx.intersect(nv))
        (res ++ cliques, pp - cur, xx + cur)
      }._1
  amcHelper(Set.empty, edges.keySet, Set.empty)
}
