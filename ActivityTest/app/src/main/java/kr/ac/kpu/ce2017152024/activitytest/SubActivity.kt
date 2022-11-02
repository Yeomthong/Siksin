package kr.ac.kpu.ce2017152024.activitytest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.ac.kpu.ce2017152024.activitytest.databinding.ActivitySubBinding

class TestFragment : Fragment() {
    private var _binding: ActivitySubBinding? = null
    private val binding get() = _binding!!
    var toggle: Boolean = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = ActivitySubBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            if(toggle) binding.textView.text = "Bye Bye~!"
            else binding.textView.text = "Hello World!"
            toggle = !toggle
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
