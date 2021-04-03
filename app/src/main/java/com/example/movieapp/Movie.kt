package com.example.movieapp

import java.io.Serializable

data class Movie(
    var title: String = "none title",
    var genre: String = "none genre",
    var author: String = "none actor",
    var creator: String = "none creator",
    var description: String = "none description"
) : Serializable