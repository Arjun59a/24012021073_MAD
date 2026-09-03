package com.example.a24012021073_mad

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(val contactList:Array<Contact>):
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder{
        val itemView = LayoutInflater.from(parent.context).
        inflate(R.layout.single_item,parent,false)
        return ContactViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: ContactViewHolder,
        position: Int
    ) {

        val contact = contactList[position]
        holder.tvContactName.text = contact.name
        holder.tvContactPhone.text = contact.phone

    }



    override fun getItemCount(): Int {
      return contactList.size
    }

    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val tvContactName : TextView = itemView.findViewById<TextView>(R.id.text_name)
        val tvContactPhone : TextView = itemView.findViewById<TextView>(R.id.text_mobile_no)

    }
    }


