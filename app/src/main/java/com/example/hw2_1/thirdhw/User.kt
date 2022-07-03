package com.example.hw2_1.thirdhw

data class User(
    val id: Int,
    val name: String,
    val lastName : String,
    val information: String,
    val url:String = ""
    ){
    override fun toString(): String {
        return "Id: $id, Name: $name, LastName: $lastName, Information: $information"
    }
}