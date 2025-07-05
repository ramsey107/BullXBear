package com.example.bullxbear.core

interface Mapper<I,O>{
    fun mapTo(input: I): O
}