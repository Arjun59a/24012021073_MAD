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
            Contact("Anubhav" , "8519075190"),
                Contact("Arjun","820624169"))

        val rv = findViewById<RecyclerView>(R.id.rv_contact)

        rv.adapter = ContactAdapter(arrayList)
    }
    fun getString(activity: Activity,key: String) : String?{
        val sharedPref = activity.getSharedPreferences("app_setting_data", Context.MODE_PRIVATE)
        return sharedPref.getString(key,"")


    }
    fun storeString(activity: Activity,key:String,value: String){
        val sharePref = activity.getSharedPreferences("app_setting_data",Context.MODE_PRIVATE)
        val editor = sharePref.edit()
        editor.putString(key,value)
        editor.commit()
    }

    fun clearString(activity: Activity)
    {
        val sharePref = activity.getSharedPreferences("app_setting_data", Context.MODE_PRIVATE)
        val editor = sharePref.edit()
        editor.clear()
        editor.commit()
    }
}