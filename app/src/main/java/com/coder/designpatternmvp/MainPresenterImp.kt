package com.coder.designpatternmvp

import android.text.TextUtils
import com.coder.designpatternmvp.model.Number

// Business logic yang akan mengimplementasikan interface dari main presenter
class MainPresenterImp(private val view:MainView):MainPresenter {
    // Sebuah arraylist untuk menampung data
    private val NUMBER = mutableListOf<Number>()
    // Overide method add number yang ada pada interface
    override fun addNumber(firstNumber: String, secondNumber:String) {
        if(TextUtils.isEmpty(firstNumber)||TextUtils.isEmpty(secondNumber)){
            // Memanggil view untuk menampilkan pesan saat salah satu dari edit text kosong
            view.showMessage("Field tidak boleh kosong")
        }else{
            // Menjumlahkan 2 value pada edit text untuk disimpan kedalam model number
            val hasilHitung = firstNumber.toInt() + secondNumber.toInt()
            NUMBER.run{
                add(Number(hasilHitung))
            }
            // Memanggil view untuk menampilkan pesan saat data telah dihitung penjumlahannya
            view.showMessage("Hasil perhitungan : $hasilHitung" )
            // Memanggil view untuk clear edit text
            view.clearField()
        }
    }

    // Overide method load data yang ada pada interface presenter
    override fun loadData() {
        if (NUMBER.size == 0){
            // Memanggil view untuk menampilkan pesan saat data pada arraylist masih kosong
            view.showMessage("Data masih kosong")
        }else{
            // Sebuah variable string dengan nama allData
            var allData = ""
            // Melakukan for loop untuk mengisi sebuah variabel all data dengan setiap value yang ada pada arraylist
            for(i in 0 until NUMBER.size){
                allData += "hasil penjumlahan : "+ NUMBER[i].hasilHitung +"\n\n"
            }
            // Menampilkan jumlah value yang ada pada arraylist
            allData += "Total : " + NUMBER.size
            // Memanggil view untuk menampilkan data
            view.showData(allData)
        }
    }
}