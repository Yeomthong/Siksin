package com.siksin.webview

import android.content.DialogInterface

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.siksin.webview.databinding.ActivityMainBinding
import com.siksin.webview.databinding.AlertdialogEdittextBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    val positiveButtonClick = { dialogInterface: DialogInterface, i: Int ->
        toast("Positive")
    }
    val negativeButtonClick = { dialogInterface: DialogInterface, i: Int ->
        toast("Negative")
    }
    val neutralButtonClick = { dialogInterface: DialogInterface, i: Int ->
        toast("Neutral")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBasicAlertDialog.setOnClickListener {
            val builder=AlertDialog.Builder(this)
                    .setTitle("Title")
                    .setMessage("Message")
                    .setPositiveButton("Positive",positiveButtonClick)
                    .setNegativeButton("Negative",negativeButtonClick)
                    .setNeutralButton("Neutral",neutralButtonClick)
                    .show()
        }

        binding.btnItemAlertDialog.setOnClickListener{
            val items = arrayOf("Apple", "Orange", "Mango", "Lemon")
            val builder = AlertDialog.Builder(this)
                    .setTitle("Select Item")
                    .setItems(items) { dialog, which ->
                        toast("${items[which]} is Selected")
                    }
                    .show()
        }

        binding.btnRadioAlertDialog.setOnClickListener{
            val items = arrayOf("Apple", "Orange", "Mango", "Lemon")
            var selectedItem: String? = null
            val builder = AlertDialog.Builder(this)
                    .setTitle("Select Item")
                    .setSingleChoiceItems(items, -1) { dialog, which ->
                        selectedItem = items[which]
                    }
                    .setPositiveButton("OK") { dialog, which ->
                        toast("${selectedItem.toString()} is Selected")
                    }
                    .show()
        }

        binding.btnCheckBoxAlertDialog.setOnClickListener {
            val items = arrayOf("Apple", "Orange", "Mango", "Lemon")
            val selectedItemIndex = ArrayList<Int>()
            val builder = AlertDialog.Builder(this)
                    .setTitle("Select Items")
                    .setMultiChoiceItems(items, null){ dialogInterface: DialogInterface, i: Int, b: Boolean ->
                        if(b){
                            selectedItemIndex.add(i)
                        } else if(selectedItemIndex.contains(i)){
                            selectedItemIndex.remove(i)
                        }
                    }
                    .setPositiveButton("OK") { dialogInterface: DialogInterface, i: Int ->
                        val selected = ArrayList<String>()
                        for(j in selectedItemIndex) {
                            selected.add(items[j])
                        }
                        toast("Selected Itmes : $selected")
                    }
                    .show()
        }

        binding.btnEditTextAlertDialog.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val builderItem = AlertdialogEdittextBinding.inflate(layoutInflater)
            val editText = builderItem.editText

            with(builder) {
                setTitle("Input Name")
                setMessage("이름을 입력 하세요")
                setView(builderItem.root)
                setPositiveButton("OK"){ dialogInterface: DialogInterface, i: Int ->
                    if(editText.text != null) toast("입력된 이름 : ${editText.text}")
                }
                show()
            }
        }


    }

    fun toast(message:String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}