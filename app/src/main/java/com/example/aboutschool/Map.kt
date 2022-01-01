package com.example.aboutschool

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_map.*
import java.util.*

class Map : AppCompatActivity() {
    private val NeedPermissions =
        arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION)
    private val PERMISSION_REQUEST_CODE = 487

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)


        setup()
    }
    @RequiresApi(Build.VERSION_CODES.M)
    private fun setup() {
        if (!requestAllNeedPermissions())
            return;
        var btn_update = findViewById<Button>(R.id.btn_update)
        btn_update.setOnClickListener { requestLocation() }
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
        var d01_01 = findViewById<RadioButton>(R.id.d01_01)
        var d01_02 = findViewById<RadioButton>(R.id.d01_02)
        var d01_03 = findViewById<RadioButton>(R.id.d01_03)
        var d01_04 = findViewById<RadioButton>(R.id.d01_04)
        var d02_01 = findViewById<RadioButton>(R.id.d02_01)
        var d02_02 = findViewById<RadioButton>(R.id.d02_02)
        var d02_03 = findViewById<RadioButton>(R.id.d02_03)
        var d02_04 = findViewById<RadioButton>(R.id.d02_04)

        val whichBuilding = when{
            d01_01.isChecked -> "$SomeoneLocation&destination=24.957138159394777,121.24356760342127"
            d01_02.isChecked -> "$SomeoneLocation&destination=24.957682531605716, 121.24353029667215"
            d01_03.isChecked -> "$SomeoneLocation&destination=24.957682531605716, 121.24353029667215"
            d01_04.isChecked -> "$SomeoneLocation&destination=24.957682531605716, 121.24353029667215"
            d02_01.isChecked -> "$SomeoneLocation&destination=24.956148388743816, 121.24346169667218"
            d02_02.isChecked -> "$SomeoneLocation&destination=24.955987567232828, 121.24496801178871"
            d02_03.isChecked -> "$SomeoneLocation&destination=24.955987567232828, 121.24496801178871"
            else -> "$SomeoneLocation&destination=24.955987567232828, 121.24496801178871"
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
        val permissionsList = ArrayList<String>()
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

