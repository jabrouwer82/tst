package tst

@main def problem1(): Unit =
  println(getBestGroupPrices(inputRates, inputCabinPrices))

def getBestGroupPrices(
    rates: Seq[Rate],
    prices: Seq[CabinPrice],
): Seq[BestGroupPrice] = {
  val rateGroups = rates.map(Tuple.fromProductTyped).toMap
  prices
    .flatMap(p => rateGroups.get(p.rateCode).map(rg => BestGroupPrice(p.cabinCode, p.rateCode, p.price, rg)))
    .groupBy(p => (p.cabinCode, p.rateGroup))
    .map((k, v) => v.minBy(_.price))
    .toSeq
}

// Provided Code
case class Rate(
    rateCode: String,
    rateGroup: String,
)
case class CabinPrice(
    cabinCode: String,
    rateCode: String,
    price: BigDecimal,
)
case class BestGroupPrice(
    cabinCode: String,
    rateCode: String,
    price: BigDecimal,
    rateGroup: String,
)

val inputRates = List(
  Rate("M1", "Military"),
  Rate("M2", "Military"),
  Rate("S1", "Senior"),
  Rate("S2", "Senior"),
)

val inputCabinPrices = List(
  CabinPrice("CA", "M1", BigDecimal("200.00")),
  CabinPrice("CA", "M2", BigDecimal("250.00")),
  CabinPrice("CA", "S1", BigDecimal("225.00")),
  CabinPrice("CA", "S2", BigDecimal("260.00")),
  CabinPrice("CB", "M1", BigDecimal("230.00")),
  CabinPrice("CB", "M2", BigDecimal("260.00")),
  CabinPrice("CB", "S1", BigDecimal("245.00")),
  CabinPrice("CB", "S2", BigDecimal("270.00")),
)
