package ru.irlix.android

import android.content.Intent.EXTRA_TEXT
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import com.example.les_4.R
import com.example.les_4.databinding.ActivityMainIrlixBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainIrlixBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener(){
            intent.putExtra("RETURNED_EXTRA",1)
            setResult(RESULT_OK,intent)
            finish()
        }
        binding.button2.setOnClickListener(){
            intent.putExtra("RETURNED_EXTRA",2)
            setResult(RESULT_OK,intent)
            finish()
        }
        binding.button3.setOnClickListener(){
            intent.putExtra("RETURNED_EXTRA",3)
            setResult(RESULT_OK,intent)
            finish()
        }

    }

}