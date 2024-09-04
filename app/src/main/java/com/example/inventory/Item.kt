
data class StockInfo(
    val stockOnHand: Double,
    val committedStock: Double,
    val availableForSale: Double
)

data class StockDetail(
    val physicalStock: StockInfo,
    val accountingStock: StockInfo
)


data class AdditionalInfo(
    val length: Double,
    val breadth: Double,
    val height: Double,
    val dimensionUnit: String,
    val weight: Double,
    val weightUnit: String,
    val mpn: String,
    val isbn: String,
    val upc: String
)



data class Item (
    val id: String,
    val name: String,
    val sellingPrice: Double,
    val costPrice: Double,
    val quantity: Double,
    val stockSummary: StockDetail,
    val itemAccount: String,
    val openingStock: Double,
    val reorderLevel: Double,
    val additionalInfo: AdditionalInfo?
)



