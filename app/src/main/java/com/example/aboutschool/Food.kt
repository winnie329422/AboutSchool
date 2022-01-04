package com.example.aboutschool

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import kotlinx.android.synthetic.main.activity_food.*

class Food : AppCompatActivity() {

    private var items: ArrayList<String> = ArrayList()
    private lateinit var adapter: ArrayAdapter<String>

    private val NeedPermissions =
        arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION)
    private val PERMISSION_REQUEST_CODE = 487


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        findViewById<ListView>(R.id.listView02).adapter =adapter


//        setListener()
        setup()
    }

//    private fun setListener(){
//
//        findViewById<Button>(R.id.btn_random).setOnClickListener{
//        }
//
//        findViewById<Button>(R.id.btn_food_road).setOnClickListener{
//
//        }
//    }
    //try看看線
    @RequiresApi(Build.VERSION_CODES.M)
    private fun setup() {
        if (!requestAllNeedPermissions())
            return;
        var btn_food_road = findViewById<Button>(R.id.btn_food_road)
        btn_food_road.setOnClickListener { requestLocation() }
        var btn_random = findViewById<Button>(R.id.btn_random)
        btn_random.setOnClickListener { randomresult() }
    }

    fun randomresult(){
        val fd01 = findViewById<RadioButton>(R.id.fd01)
        val fd02 = findViewById<RadioButton>(R.id.fd02)
        val fd03 = findViewById<RadioButton>(R.id.fd03)
        val fd04 = findViewById<RadioButton>(R.id.fd04)
        val txt_resultTitle = findViewById<TextView>(R.id.txt_resultTitle)
        val txt_resultContent =findViewById<TextView>(R.id.txt_resultContent)

        if (fd01.isChecked){
            val randomfood = (Math.random()*3).toInt()
            var RDresult = when(randomfood){
                0->"中原燒臘"
                1->"吉野烤肉飯"
                else->"宜珍快餐"
            }
            txt_resultContent.text = RDresult
        }
        if (fd02.isChecked){
            val randomfood = (Math.random()*4).toInt()
            var RDresult = when(randomfood){
                0->"翔大"
                1->"黑宅"
                else->"麵心無界"
            }
            txt_resultContent.text = RDresult
        }
        if (fd03.isChecked){
            val randomfood = (Math.random()*4).toInt()
            var RDresult = when(randomfood){
                0->"丼心丼"
                1->"雙響丼"
                2->"丼吃丼"
                else->"務農人"
            }
            txt_resultContent.text = RDresult
        }
        if (fd04.isChecked){
            val randomfood = (Math.random()*10).toInt()
            var RDresult = when(randomfood){
                0->"中原燒臘"
                1->"吉野烤肉飯"
                2->"宜珍快餐"
                3->"翔大"
                4->"黑宅"
                5->"麵心無界"
                6->"丼心丼"
                7->"雙響丼"
                8->"丼吃丼"
                else->"務農人"
            }
            txt_resultContent.text = RDresult
        }
        txt_resultTitle.textSize = 22F
        txt_resultTitle.text = "你可以吃看看："
        txt_resultContent.textSize = 20F
    }
    @SuppressLint("MissingPermission")
    fun requestLocation() {
        val mLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        val locationRequest = LocationRequest();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
//         設定更新速度
        locationRequest.setInterval(1000)
//        設定要更新幾次座標
        locationRequest.setNumUpdates(1)
        var a:String?="text"
        a=null
        var SomeoneLocation=""
        a?.let {
            mLocationProviderClient.requestLocationUpdates(locationRequest, object : LocationCallback() {
                public override fun onLocationResult(p0: LocationResult) {
                    p0 ?: return
                    SomeoneLocation ="${p0.lastLocation.longitude},${p0.lastLocation.latitude}"
                    //                tv_location.setText(locationText)

                }
            }, it)
        }
        val txt_resultContent = findViewById<TextView>(R.id.txt_resultContent)
        val whichBuilding = when{
            txt_resultContent.text=="中原燒臘" -> "$SomeoneLocation&destination=24.954101829095833, 121.24197394640808"
            txt_resultContent.text=="吉野烤肉飯" -> "$SomeoneLocation&destination=24.957128665796038, 121.24027931281859"
            txt_resultContent.text=="宜珍快餐" -> "$SomeoneLocation&destination=24.955716158450354, 121.24164540320766"
            txt_resultContent.text=="翔大" -> "$SomeoneLocation&destination=24.955355904075926, 121.24162846396277"
            txt_resultContent.text=="黑宅" -> "$SomeoneLocation&destination=24.957262412187305, 121.23928957763748"
            txt_resultContent.text=="麵心無界" -> "$SomeoneLocation&destination=24.95398436722733, 121.24029808825482"
            txt_resultContent.text=="丼心丼" -> "$SomeoneLocation&destination=24.95503855514437, 121.2429454286036"
            txt_resultContent.text=="雙響丼" -> "$SomeoneLocation&destination=24.95691588707926, 121.24011838024587"
            txt_resultContent.text=="丼吃丼" -> "$SomeoneLocation&destination=24.955957770467354, 121.2413629252413"
            else -> "$SomeoneLocation&destination=24.95511150899216, 121.2420924861134"
        }
        val url = Uri.parse(
            "https://www.google.com/maps/dir/?api=1&origin=$whichBuilding"
        )
        val intent = Intent().apply{
            action = "android.intent.action.VIEW"
            data = url
        }
        startActivity(intent)
    }
    //    回傳是否已經有權限。
    @RequiresApi(Build.VERSION_CODES.M)
    fun requestAllNeedPermissions(): Boolean {
        val permissionsList = java.util.ArrayList<String>()
        for (permission in NeedPermissions)
            if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED)
                permissionsList.add(permission)
        if (permissionsList.size < 1)
            return true

        ActivityCompat.requestPermissions(this, permissionsList.toTypedArray(), PERMISSION_REQUEST_CODE)
        return false
    }
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST_CODE) {
            setup()
        }
    }
}