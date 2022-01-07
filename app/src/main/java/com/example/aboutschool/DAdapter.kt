package com.example.aboutschool

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class DAdapter(private val context: Activity,
               private val arrayList: ArrayList<Data>):ArrayAdapter<Data>
    (context,R.layout.list_item,arrayList) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view :View = inflater.inflate(R.layout.list_item,null)

        val imageView :ImageView = view.findViewById(R.id.department_pic)
        val DepartmentName :TextView = view.findViewById(R.id.department_name)

        imageView.setImageResource(arrayList[position].imageId)
        DepartmentName.text = arrayList[position].name

        return view
    }

}