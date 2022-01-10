package com.example.diceroller

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rollDice()

        val btRollDice: Button = findViewById(R.id.bt_roll)
        btRollDice.setOnClickListener {
            val rolledNumber = rollDice()
            showToast("Rolled number: $rolledNumber")
        }
    }

    private fun rollDice(): Int {
        val diceImage: ImageView = findViewById(R.id.iv_dice)
        val dice = Dice(6)
        val rolledNUmber = dice.roll()
        val diceImageResource = when (rolledNUmber) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(diceImageResource)
        diceImage.contentDescription = rolledNUmber.toString()

        return rolledNUmber
    }

    private fun showToast(message: String) {
        val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.TOP, 0, 200)
        toast.show()
    }
}