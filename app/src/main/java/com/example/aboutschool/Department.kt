package com.example.aboutschool

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aboutschool.Models.DepartmentGroup
import com.example.aboutschool.Services.DataService
import java.util.ArrayList



public class Department : Fragment() {

    lateinit var adapter: ArrayAdapter<DepartmentGroup>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_department, container, false)


        //產生資料清單
//        generateListView()
//        setListener()
        val card_Intent = view?.findViewById<CardView>(R.id.card_03)
        card_Intent?.setOnClickListener{
            val intent =Intent(requireContext(),ViewDepartmentActivity::class.java)
            startActivity(intent)
        }

        return view
    }

//    //實作ArrayAdapter
//    fun generateListView(){
//        adapter =  ArrayAdapter(requireContext(),
//            android.R.layout.simple_list_item_1,
//            DataService.groups)

//        view?.findViewById<ListView>(R.id.listview1)?.adapter = adapter
//    }

    private fun setListener(){


    }








}