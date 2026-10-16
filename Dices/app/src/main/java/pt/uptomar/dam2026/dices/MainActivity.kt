package pt.uptomar.dam2026.dices

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import pt.uptomar.dam2026.dices.databinding.ActivityMainBinding
import java.util.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding= ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        binding.bt.setOnClickListener {
            // generate a random value and assign it to dice
            roolTheDice()
            // add a message to screen
            Toast.makeText(this,R.string.toast_text, Toast.LENGTH_SHORT).show()
            // navbar
        }


    }

    /**
     * generate a random number and assign it to dice
     */
    fun roolTheDice() {
        /* Algorithm
         * 1- generate random number from 1 to 6
         * 2- use that value to choose dice image
         * 3- update the number on screen
         */

        // 1.
        var randomNumber = Random().nextInt(6) + 1

        // 2.
        var diceImage = when (randomNumber) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // assign image to dice
        binding.diceImage.setImageResource(diceImage)

        // 3.
        binding.diceNumber.text=randomNumber.toString()
    }
}