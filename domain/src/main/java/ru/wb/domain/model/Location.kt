package ru.wb.domain.model

data class Location(
    val city: String,
    val address: String
){
    companion object {
        val defaultObject = Location(
            city = "",
            address = ""
        )
    }
}
