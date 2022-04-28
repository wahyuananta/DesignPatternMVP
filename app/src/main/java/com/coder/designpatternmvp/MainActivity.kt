package com.coder.designpatternmvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.coder.designpatternmvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {
    private lateinit var binding: ActivityMainBinding
    lateinit var presenterImp: MainPresenterImp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenterImp = MainPresenterImp(this)

        binding.btnAdd.setOnClickListener {
            presenterImp.addNumber(
                binding.etFirstNumber.text.toString(),
                binding.etSecondNumber.text.toString()
            )
        }

        binding.btnShow.setOnClickListener {
            presenterImp.loadData()
        }
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun showData(data: String) {
        AlertDialog.Builder(this)
            .setTitle("History")
            .setNegativeButton("close"){dialog,_->
                dialog.dismiss()

            }
            .setMessage(data)
            .create()
            .show()

    }

    override fun clearField() {
        binding.etFirstNumber.text.clear()
        binding.etSecondNumber.text.clear()
    }
}