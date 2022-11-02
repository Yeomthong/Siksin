package com.siksin.listmap

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.siksin.listmap.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var edtName: EditText
    private lateinit var listButton: Button
    private lateinit var mapButton: Button
    val MAP_BOUNDARY_NUM: Int=10000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setTitle("리스트와 맵 정렬")

        edtName=findViewById(R.id.edtName) as EditText
        listButton=findViewById(R.id.listButton) as Button
        mapButton=findViewById(R.id.mapButton) as Button
        val nameList: List<String> = listOf("$", "aespa", "girlgroup2", "girlgroup3", "girlgroup4", "girlgroup5",
                "$", "bts", "boygroup2", "boygroup3", "boygroup4", "boygroup5",
                "$", "iu", "girlsolo2", "girlsolo3", "girlsolo4", "girlsolo5",
                "$", "beo", "boysolo2", "boysolo3", "boysolo4", "boysolo5"
        )
        val nameMap: MutableMap<Int, String> = mutableMapOf()
        var mapMainNum:Int=0
        var mapSubNum:Int=0
        for(name in nameList){
            if (name!="$") {
                mapSubNum += 1
                nameMap.put(mapMainNum+mapSubNum, name)
            }
            else{
                mapMainNum+=MAP_BOUNDARY_NUM
                mapSubNum=0
            }
        }
        binding.listButton.setOnClickListener{
            var listNum:Int=0
            var listBoundaryNum:Int=0
            for(name in nameList){
                if (name!="$") listNum += 1
                else listBoundaryNum += 1
                if ((edtName.getText().toString()!="$")&&(name==edtName.getText().toString())){
                    Toast.makeText(this, "$name 는(은) $listNum 번째입니다", Toast.LENGTH_SHORT).show()
                    break
                }
            }
            if(listNum>nameList.size-listBoundaryNum){
                Toast.makeText(this, "그런 사람은 없습니다.", Toast.LENGTH_SHORT).show()
            }
        }
        binding.mapButton.setOnClickListener{
            var keyNum:Int=0
            var valueName:String=edtName.getText().toString()
            var hashStr = valueName.hashCode()
            if ((valueName=="$")||(!nameMap.containsValue(valueName))){
                Toast.makeText(this, "그런 사람은 없습니다.", Toast.LENGTH_SHORT).show()
            }
            else{
                for(key in nameMap.keys){
                    if (nameMap.get(key)==valueName){
                        keyNum=key
                    }
                }
                when(keyNum){
                    in MAP_BOUNDARY_NUM+1..MAP_BOUNDARY_NUM*2 -> Toast.makeText(this, "$valueName 은 여성 그룹입니다", Toast.LENGTH_SHORT).show()
                    in MAP_BOUNDARY_NUM*2+1..MAP_BOUNDARY_NUM*3 -> Toast.makeText(this, "$valueName 은 남성 그룹입니다", Toast.LENGTH_SHORT).show()
                    in MAP_BOUNDARY_NUM*3+1..MAP_BOUNDARY_NUM*4 -> Toast.makeText(this, "$valueName 은 여성 솔로입니다", Toast.LENGTH_SHORT).show()
                    in MAP_BOUNDARY_NUM*4+1..MAP_BOUNDARY_NUM*5 -> Toast.makeText(this, "$valueName 은 남성 솔로입니다", Toast.LENGTH_SHORT).show()
                }
            }
        }


    }

}