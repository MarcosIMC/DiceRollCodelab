package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/**
 * MainActivity
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Asignacion del boton roll
        val rollButton: Button = findViewById(R.id.button)
        //Accion que debe ejecutar al pulsar
        rollButton.setOnClickListener { rollDice() }
        //Al iniciar la app, ya muestra un dado al usuario
        rollDice()
    }

    /**
     * Genera un valor aleatorio 1..6 y en funcion de ello, carga una imagen de dado u otra
     * y la asigna al contenedor de la imagen.
     */
    private fun rollDice() {
        //Create new Dice Object with 6 sades
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //Update the screen with the dice roll
        val diceImage: ImageView = findViewById(R.id.imageView)
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
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}