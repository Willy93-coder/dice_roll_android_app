package com.example.codelab1

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var diceImage1: ImageView
    private lateinit var diceImage2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        val clearButton: Button = findViewById(R.id.clear_button)
        diceImage1 = findViewById(R.id.dice_image1)
        diceImage2 = findViewById(R.id.dice_image2)
        rollButton.setOnClickListener {
            rollDice(diceImage1)
            rollDice(diceImage2)
        }
        clearButton.setOnClickListener {
            clearDice(diceImage1)
            clearDice(diceImage2)
        }
    }

    private fun rollDice(dice: ImageView) {
        val randomInt: Int = randomInt()
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        dice.setImageResource(drawableResource)
    }

    private fun randomInt(): Int {
        return (1..6).random()
    }

    private fun clearDice(dice: ImageView){
        dice.setImageResource(R.drawable.empty_dice)
    }
}