package kr.ac.kpu.ce2017152024.KotlinPractice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    final override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onCreateBaseActivity(savedInstanceState)
    }
    abstract fun onCreateBaseActivity(savedInstanceState: Bundle?)
}