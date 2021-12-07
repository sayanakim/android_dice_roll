package com.sayana.mypracticeapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import kotlin.random.Random

private const val LAST_ROLLED_IMAGE = "image"

class DiceRollFragment : Fragment() {

    lateinit var  diceImageView: ImageView
    lateinit var rollButton: Button

    // список костей
    private val diceImageList: List<Int> = listOf(
        R.drawable.one,
        R.drawable.two,
        R.drawable.three,
        R.drawable.four,
        R.drawable.five,
        R.drawable.six
    )

    var lastRolledImageRes = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dice_roll, container, false)

        // инициализация переменных
        diceImageView = view.findViewById(R.id.dice_image_view)
        rollButton = view.findViewById(R.id.roll_button)


        // сохранение рандомного числа при повороте
        if (savedInstanceState != null)
            diceImageView.setImageResource(savedInstanceState.getInt(LAST_ROLLED_IMAGE))

        // рандомное число кубика
        rollButton.setOnClickListener {
            lastRolledImageRes = diceImageList.random()
            diceImageView.setImageResource(lastRolledImageRes)
        }

        return view
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_ROLLED_IMAGE, lastRolledImageRes)
    }


}