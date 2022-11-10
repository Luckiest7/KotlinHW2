package com.example.lab6

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                val dialog = AlertDialog.Builder(this@MainActivity)
                dialog.setTitle("請選擇功能")
                dialog.setMessage("請根據下方按鈕選擇要顯示的物件")

                dialog.setNeutralButton("取消") {
                        dialog, which ->
                    Toast.makeText(this@MainActivity, "dialog關閉", Toast.LENGTH_SHORT).show()
                }
                dialog.setNegativeButton("自定義Toast") {
                        dialog, which -> showToast()
                }
                dialog.setPositiveButton("顯示list") {
                        dialog, which -> showListDialog()
                }
                dialog.show()
            }

            private fun showToast() {
                val toast = Toast(this@MainActivity)
                toast.setGravity(Gravity.TOP, 0, 50)
                toast.duration = Toast.LENGTH_SHORT
                val inflater = layoutInflater
                toast.view = layoutInflater.inflate(R.layout.custom_toast, null)
                toast.show()
            }

            private fun showListDialog() {
                val list = arrayOf("message1", "message2", "message3", "message4", "message5")
                val dialog_List = AlertDialog.Builder(this@MainActivity)
                dialog_List.setTitle("使用LIST呈現")
                dialog_List.setItems(
                    list
                ) { dialog, i ->
                    Toast.makeText(this@MainActivity, "你選擇的是" + list[i], Toast.LENGTH_SHORT).show()
                }
                dialog_List.show()
            }
        })
    }
}