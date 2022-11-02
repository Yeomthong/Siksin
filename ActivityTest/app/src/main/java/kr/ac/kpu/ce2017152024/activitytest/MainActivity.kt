package kr.ac.kpu.ce2017152024.activitytest


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.ac.kpu.ce2017152024.activitytest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var toggle:Boolean=true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(binding.root)

        binding.button.setOnClickListener{
            if (toggle) binding.textView.text="Bye Bye~!"
            else binding.textView.text="Hello World!"
            toggle=!toggle
        }
    }
}