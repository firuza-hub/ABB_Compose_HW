package com.example.compose

data class ChatMessage (val author:Author, val body:String)

data class Author(val name: String, val imageRes: Int)