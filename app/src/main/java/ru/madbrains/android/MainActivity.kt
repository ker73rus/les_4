package ru.madbrains.android

import android.app.Activity
import android.content.Intent
import android.content.Intent.EXTRA_TEXT
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import com.example.les_4.R
import com.example.les_4.databinding.ActivityMainMadBinding
import ru.irlix.android.MainActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainMadBinding.inflate(layoutInflater)



        setContentView(binding.root)
        binding.imageView.setImageResource(R.drawable.one)

        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == RESULT_OK){
                val res = it.data?.getIntExtra("RETURNED_EXTRA",0)
                when (res) {
                    1-> binding.imageView.setImageResource(R.drawable.one)
                    2-> binding.imageView.setImageResource(R.drawable.two)
                    3-> binding.imageView.setImageResource(R.drawable.three)
                }
            }
        }

        val intent = Intent(this, MainActivity::class.java)
        binding.button.setOnClickListener(){
            resultLauncher.launch(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        outState?.run {

        }
        super.onSaveInstanceState(outState, outPersistentState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }
}