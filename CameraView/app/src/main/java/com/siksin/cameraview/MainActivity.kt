package com.siksin.cameraview

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.siksin.cameraview.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    val CAMERA_PERMISSION=arrayOf(Manifest.permission.CAMERA)
    val CAMERA_PERMISSION_REQUEST=100

    val STORAGE_PERMISSION= arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE,
    Manifest.permission.WRITE_EXTERNAL_STORAGE)
    val STORAGE_PERMISSION_REQUEST=200
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        binding.btnCameraPermission.setOnClickListener {
            checkPermission(CAMERA_PERMISSION, CAMERA_PERMISSION_REQUEST)
        }

        binding.btnStoragePermission.setOnClickListener {
            checkPermission(STORAGE_PERMISSION, STORAGE_PERMISSION_REQUEST)
        }
    }

    fun checkPermission(permissions: Array<String>, permissionRequestNumber:Int){
        val permissionResult= ContextCompat.checkSelfPermission(this,permissions[0])

        when(permissionResult){
            PackageManager.PERMISSION_GRANTED->{
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show()
            }
            PackageManager.PERMISSION_DENIED->{
                ActivityCompat.requestPermissions(this, permissions, permissionRequestNumber)
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when(requestCode){
            CAMERA_PERMISSION_REQUEST->{
                if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Camera Permission Granted", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "Camera Permission Denied", Toast.LENGTH_SHORT).show()
                }
            }
            STORAGE_PERMISSION_REQUEST->{
                if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Storage Permission Granted", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "Storage Permission Denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}