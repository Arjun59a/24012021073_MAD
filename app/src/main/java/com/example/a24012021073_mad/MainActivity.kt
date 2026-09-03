package com.example.a24012021073_mad

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val arrayList = arrayOf(
            Contact("Anubhav" , "8519075190")
        )
        val rv = findViewById<RecyclerView>(R.id.rv_contact)

        rv.adapter = ContactAdapter(arrayList)
    }
    fun storeString(activity: Activity,key:String,value: String){
        val sharePref = activity.getSharedPreferences("app_setting_data",Context.MODE_PRIVATE)
        val editor = sharePref.edit()
        editor.putString()
    }
}