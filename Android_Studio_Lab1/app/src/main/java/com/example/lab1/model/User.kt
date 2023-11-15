package com.example.lab1.model

import com.example.lab1.R
data class User(
    val id: Int,
    val name: String,
    val avatar: Int,
    val posts: Int,
    val numberOfFollowers: Int,
    val numberOfFollowing: Int,
    val location: String,
    val description: String,

) {
    companion object{
        val example = User(
            1,
            "Emma Watson",
            R.drawable.emma,
            172,
            324,
            119,
            "Paris, France",
            "My name is Emma. And I am collector of flowers"
        )
    }
}
