package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

/**
 * activity：讓使用者能夠擲骰子和看到結果
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
        // Do a dice roll when the app starts
        rollDice()
    }

    /**
     * 擲骰子和更新畫面上的結果
     */
    private fun rollDice() {
        // 建立句有六面的 Dice 物件，並呼叫 class 裡面的 roll() 方法
        val dice = Dice(6)
        val diceRoll = dice.roll()
        // 更新骰子圖片
        val diceImage: ImageView = findViewById(R.id.imageView)
        // 用 when 條件判斷
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()
    }

    /**
     * Dice 會有固定的面數值
     */
    class Dice(val numSides: Int) {

        // 回傳一個隨機數字，介於 1 到 numSides 之間
        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}