package com.code.damahe.feature.model

data class MaterialDemo(
    val name: String,
    val navRoute: String,
    val list: List<MaterialList> = emptyList(),
)

data class MaterialList(
    val name: String,
    val navRoute: String
)
