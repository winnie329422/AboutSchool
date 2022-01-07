package com.example.aboutschool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.aboutschool.databinding.ActivityViewDepartment2Binding
import com.example.aboutschool.databinding.ActivityViewDepartmentBinding

class ViewDepartmentActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityViewDepartment2Binding
    private lateinit var DArrayList :ArrayList<Data>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewDepartment2Binding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val imageId = intArrayOf(

            R.drawable.d201,R.drawable.d202,R.drawable.d203,R.drawable.d204

        )
        val name = arrayOf(
            "建築系","室設系","商設系","地景系"
        )

        DArrayList =ArrayList()
        for (i in name.indices){
            val dd = Data(name[i],imageId[i])
            DArrayList.add(dd)
        }

        //        binding.listView.isClickable =true
        binding.listView.adapter =DAdapter(this,DArrayList)
        binding.listView.setOnItemClickListener { parent, view, positon, id ->

            val name =name[positon]
            val imageId = imageId[positon]

            val i = Intent(this,Detail::class.java)
            i.putExtra("name",name)
            i.putExtra("imageId",imageId)
            startActivity(i)
        }
    }
}