package ru.madbrains.android

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.les_4.R
import com.example.les_4.databinding.ActivityMainMadBinding
import ru.irlix.android.MainActivity

class MainActivity : AppCompatActivity() {

    private lateinit var image : ImageView
    private var num = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainMadBinding.inflate(layoutInflater)
        image = binding.imageView
        setContentView(binding.root)
        setImage(1)

        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == RESULT_OK){
                val res = it.data?.getIntExtra("RETURNED_EXTRA",0) ?: 0
                setImage(res)
            }
        }

        val intent = Intent(this, MainActivity::class.java)
        binding.button.setOnClickListener(){
            resultLauncher.launch(intent)
        }

    }
    fun setImage(res :Int){
        num = res
        when (num) {
            1-> image.setImageResource(R.drawable.one)
            2-> image.setImageResource(R.drawable.two)
            3-> image.setImageResource(R.drawable.three)
            else -> {
                image.setImageResource(R.drawable.one)
            }
        }
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        setImage(savedInstanceState.getInt("IMG"))
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("IMG", num)
    }

}