package tst

class Problem1Suite extends munit.FunSuite {
  test("sample inputs produce sample outputs") {
    val sampleBestCabinPrices = List(
      BestGroupPrice("CA", "M1", BigDecimal("200.00"), "Military"),
      BestGroupPrice("CA", "S1", BigDecimal("225.00"), "Senior"),
      BestGroupPrice("CB", "M1", BigDecimal("230.00"), "Military"),
      BestGroupPrice("CB", "S1", BigDecimal("245.00"), "Senior"),
    ).sortBy(Tuple.fromProductTyped)
    val actualOutput = getBestGroupPrices(inputRates, inputCabinPrices)
      .sortBy(Tuple.fromProductTyped)
    assertEquals(actualOutput, sampleBestCabinPrices)
  }
  test("empty inputs produce empty outputs") {
    val expected = Nil
    val actualOutput = getBestGroupPrices(Nil, Nil)
    assertEquals(actualOutput, expected)
  }
  test("empty rate inputs produce empty outputs") {
    val expected = Nil
    val actualOutput = getBestGroupPrices(Nil, inputCabinPrices)
    assertEquals(actualOutput, expected)
  }
  test("empty cabin price inputs produce empty outputs") {
    val expected = Nil
    val actualOutput = getBestGroupPrices(inputRates, Nil)
    assertEquals(actualOutput, expected)
  }
}
