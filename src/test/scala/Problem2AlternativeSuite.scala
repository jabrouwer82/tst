package tst

class Problem2AlternativeSuite extends munit.FunSuite {
  test("sample inputs produce sample outputs") {
    val samplePromoCombos = List(
      PromotionCombo(Seq("P1", "P2")),
      PromotionCombo(Seq("P1", "P4", "P5")),
      PromotionCombo(Seq("P2", "P3")),
      PromotionCombo(Seq("P3", "P4", "P5")),
    ).map(p => p.copy(p.promotionCodes.sorted))
      .sortBy(_.##)
    val actualOutput = allCombinablePromotions2(inputPromos)
      .sortBy(_.##)
    assertEquals(actualOutput, samplePromoCombos.map(p => p.copy(p.promotionCodes.sorted)))
  }
  test("empty inputs produce empty outputs") {
    val expected = Nil
    val actualOutput = allCombinablePromotions2(Nil)
    assertEquals(actualOutput, expected)
  }
}
