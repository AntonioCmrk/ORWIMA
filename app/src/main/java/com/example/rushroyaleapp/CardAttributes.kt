package com.example.rushroyaleapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


class CardAttributes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_attributes)

        val imageCA: ImageView = findViewById(R.id.imageViewCardAttributes)
        val nameCA: TextView = findViewById(R.id.textViewName)
        val factionCA: TextView = findViewById(R.id.textViewFaction)
        val unitTypeCA: TextView = findViewById(R.id.textViewUnitType)
        val targetCA: TextView = findViewById(R.id.textViewTarget)
        val damageCA: TextView = findViewById(R.id.textViewDamage)

        val bundle: Bundle? = intent.extras
        val image = bundle!!.getInt("image")
        val name = bundle.getString("name")
        val faction = bundle.getString("faction")
        val unitType = bundle.getString("unitType")
        val target = bundle.getString("target")
        val damage = bundle.getString("damage")

        imageCA.setImageResource(image)
        nameCA.text = name
        factionCA.text = faction
        unitTypeCA.text = unitType
        targetCA.text = target
        damageCA.text = damage

            val CardListButton: Button = findViewById(R.id.buttonBackToStart)
            CardListButton.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
        }
    }
}