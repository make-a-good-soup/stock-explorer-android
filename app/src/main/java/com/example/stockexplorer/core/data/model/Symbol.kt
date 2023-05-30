package com.example.stockexplorer.core.data.model

data class Symbol(
    val symbolId: String,
    val name: String,
    val price: Double,
    val isTrial: Boolean,
    val change: Double,
    val changePercent: Double,
    val at: String,
)
