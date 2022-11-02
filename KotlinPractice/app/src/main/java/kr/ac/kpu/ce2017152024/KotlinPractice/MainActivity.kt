package kr.ac.kpu.ce2017152024.KotlinPractice

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class MainActivity : Application() {
    override fun onCreate() {
        super.onCreate()
        instance=this
    }

     companion object{
         var instance:MainActivity?=null
     }
}
