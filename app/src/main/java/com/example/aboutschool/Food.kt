package com.example.aboutschool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.fragment.app.Fragment

class Food :Fragment() {

    private lateinit var adapter: ArrayAdapter<String>
    private var items: ArrayList<String> = ArrayList()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view: View = inflater.inflate(R.layout.activity_food, container, false)

        adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, items)
        view?.findViewById<ListView>(R.id.listView).adapter =adapter


        setListener()

        return view

    }

    private fun setListener(){

        view?.findViewById<Button>(R.id.btn_random)?.setOnClickListener{

        }

        view?.findViewById<Button>(R.id.btn_food_road)?.setOnClickListener{

        }

    }

}