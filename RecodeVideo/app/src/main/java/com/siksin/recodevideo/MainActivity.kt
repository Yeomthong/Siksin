package com.siksin.recodevideo

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.siksin.recodevideo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    private val CAMERA_PERMISSION = arrayOf(Manifest.permission.CAMERA)
    private val CAMERA_PERMISSION_FLAG = 100
    private val STORAGE_PERMISSION = arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE)
    private val STORAGE_PERMISSION_FLAG = 200

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(checkPermission(CAMERA_PERMISSION, CAMERA_PERMISSION_FLAG)){
            checkPermission(STORAGE_PERMISSION, STORAGE_PERMISSION_FLAG)
        }
    }

    private fun checkPermission(permissions: Array<out String>, flag: Int):Boolean{
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M) {
            for (permission in permissions) {
                if (ContextCompat.checkSelfPermission(
                                this,
                                permission
                        ) != PackageManager.PERMISSION_GRANTED
                ) {
                    ActivityCompat.requestPermissions(this, permissions, flag)
                    return false
                }
            }
        }
        return true
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            CAMERA_PERMISSION_FLAG->{
                for(grant in grantResults){
                    if(grant!=PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(this, "카메라 권한을 승인해야지만 앱을 사용 할 수 있습니다.",
                        Toast.LENGTH_LONG).show()
                        finish()
                    }else{
                        checkPermission(STORAGE_PERMISSION, STORAGE_PERMISSION_FLAG)
                    }
                }
            }
        }
    }
}