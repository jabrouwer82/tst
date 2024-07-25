package tst

class Problem2Suite extends munit.FunSuite {
  test("part 1 sample inputs produce sample outputs") {
    val samplePromoCombos = List(
      PromotionCombo(List("P1", "P2")),
      PromotionCombo(List("P1", "P4", "P5")),
      PromotionCombo(List("P2", "P3")),
      PromotionCombo(List("P3", "P4", "P5")),
    ).map(p => p.copy(p.promotionCodes.sorted))
      .sortBy(_.##)
    val actualOutput = allCombinablePromotions(inputPromos)
      .sortBy(_.##)
    assertEquals(actualOutput, samplePromoCombos)
  }
  test("part 2 P1 sample inputs produce sample outputs") {
    val samplePromoCombosP1 = List(
      PromotionCombo(List("P1", "P2")),
      PromotionCombo(List("P1", "P4", "P5")),
    ).map(p => p.copy(p.promotionCodes.sorted))
      .sortBy(_.##)
    val actualOutput = combinablePromotions("P1", inputPromos)
      .sortBy(_.##)
    assertEquals(actualOutput, samplePromoCombosP1)
  }
  test("part 2 P3 sample inputs produce sample outputs") {
    val samplePromoCombosP3 = List(
      PromotionCombo(List("P3", "P2")),
      PromotionCombo(List("P3", "P4", "P5")),
    ).map(p => p.copy(p.promotionCodes.sorted))
      .sortBy(_.##)
    val actualOutput = combinablePromotions("P3", inputPromos)
      .sortBy(_.##)
    assertEquals(actualOutput, samplePromoCombosP3)
  }
  test("part 1 empty inputs produce empty outputs") {
    val expected = Nil
    val actualOutput = allCombinablePromotions(Nil)
    assertEquals(actualOutput, expected)
  }
  test("part 2 empty inputs produce empty outputs") {
    val expected = Nil
    val actualOutput = combinablePromotions("P3", Nil)
    assertEquals(actualOutput, expected)
  }
}
