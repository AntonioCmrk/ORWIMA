package com.example.rushroyaleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val CardListButton: Button = findViewById(R.id.cardListButton)
        val BackButton: Button = findViewById(R.id.buttonBack)

        BackButton.visibility = View.GONE
        CardListButton.setOnClickListener {
            val cardListFragment = CardListFragment()
                supportFragmentManager.beginTransaction().add(
                    R.id.fragmentContainerView,
                    cardListFragment,
                    CardListFragment::class.java.simpleName
                ).commit()
            CardListButton.visibility = View.GONE
            BackButton.visibility = View.VISIBLE
        }

        BackButton.setOnClickListener {
            val startFragment = StartFragment()

                supportFragmentManager.beginTransaction().add(
                    R.id.fragmentContainerView,
                    startFragment,
                    startFragment::class.java.simpleName
                ).commit()
            CardListButton.visibility = View.VISIBLE
            BackButton.visibility = View.GONE
        }
    }
}