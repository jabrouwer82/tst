package tst

@main def problem2(): Unit =
  println(allCombinablePromotions(inputPromos))
  println(combinablePromotions("P1", inputPromos))
  println(combinablePromotions("P3", inputPromos))

def allCombinablePromotions(allPromotions: Seq[Promotion]): Seq[PromotionCombo] = {
  val promos = allPromotions.map(Tuple.fromProductTyped).toMap
  allPromotions.flatMap(p => combinablePromotions(p.code, allPromotions)).distinct
}

def combinablePromotions(
    promotionCode: String,
    allPromotions: Seq[Promotion],
): Seq[PromotionCombo] =
  if (allPromotions.exists(_.code == promotionCode))
    combinablePromos(promotionCode, allPromotions.toList).distinct
      .map(p => PromotionCombo(p.toList.sorted))
  else Nil

// Helper method using slightly more convenient types.
def combinablePromos(
    promoCode: String,
    allPromos: List[Promotion],
): List[Set[String]] = {
  val validPromos = allPromos.filter(p => p.code != promoCode && !p.notCombinableWith.contains(promoCode))
  if (validPromos.isEmpty) List(Set(promoCode))
  else {
    validPromos
      .flatMap(p => combinablePromos(p.code, validPromos))
      .map(_ + promoCode)
  }
}

// Provided Code:
case class Promotion(code: String, notCombinableWith: Seq[String])
case class PromotionCombo(promotionCodes: Seq[String])

val inputPromos = List(
  Promotion("P1", Seq("P3")),
  Promotion("P2", Seq("P4", "P5")),
  Promotion("P3", Seq("P1")),
  Promotion("P4", Seq("P2")),
  Promotion("P5", Seq("P2")),
)
