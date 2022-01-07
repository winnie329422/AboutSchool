package com.example.aboutschool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.aboutschool.databinding.ActivityViewDepartmentBinding

class ViewDepartmentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewDepartmentBinding
    private lateinit var DArrayList :ArrayList<Data>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewDepartmentBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val imageId = intArrayOf(

            R.drawable.d01,R.drawable.d02,R.drawable.d03,R.drawable.d04,R.drawable.d05

        )
        val name = arrayOf(
            "資管系","企管系","國貿系","會計系","財金系"
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

            val i =Intent(this,Detail::class.java)
            i.putExtra("name",name)
            i.putExtra("imageId",imageId)
            startActivity(i)
        }


    }
}