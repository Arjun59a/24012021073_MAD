package com.example.a24012021073_mad

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.sql.SQLException

class ContactDatabaseHelper(context: Context) : SQLiteOpenHelper(context,DB_NAME,null,DB_VER){
    override fun onCreate(db: SQLiteDatabase?) {
        val createTableSQLQuery = "CREATE TABLE $TABLE_CONTACT(id INTEGER PRIMARY KEY AUTOINCREMENT,$KEY_NAME TEXT,$KEY_PHONE  TEXT)"
        db!!.execSQL(createTableSQLQuery)

    }

    override fun onUpgrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) {
        val dropQuery = "DROP TABLE IF EXISTS $TABLE_CONTACT"
        db!!.execSQL(dropQuery)
        onCreate(db)
    }

    companion object{
        private val DB_NAME = "ContactDatabase.db"
        private val DB_VER = 1
        private val TABLE_CONTACT = "contacts"
        private val KEY_NAME = "name"
        private val KEY_PHONE = "phone_no"

    }

    fun addContact(contact: Contact)
    {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(KEY_NAME, contact.name)
        values.put(KEY_PHONE,contact.phone)
        db.insert(TABLE_CONTACT,null,values)
        db.close()
    }

    fun getContactByName(name:String): Contact?
    {
        val db = readableDatabase
        try {
            val cursor = db.query(TABLE_CONTACT,arrayOf("id",KEY_NAME,KEY_PHONE),
                "$KEY_NAME=?",arrayOf(name),null,null,null)
            cursor.moveToFirst()
            val returnContact = Contact(
                cursor.getLong(cursor.getColumnIndexOrThrow("id")),
                cursor.getString(cursor.getColumnIndexOrThrow(KEY_NAME)),
                cursor.getString(cursor.getColumnIndexOrThrow(KEY_PHONE))
                )
            cursor.close()
            return returnContact
        }catch (e : SQLException){

        }

        return null

    }

}