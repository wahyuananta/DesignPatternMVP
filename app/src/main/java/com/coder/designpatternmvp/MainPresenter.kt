package com.coder.designpatternmvp

interface MainPresenter {

    // Method untuk menambah data untuk selanjutnya dilakukan perhitungan
    fun addNumber(angka1: String,angka2:String)

    // Method untuk memproses data
    fun loadData()
}