package com.example.topsoccerteams

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Arrays

class MainActivity : AppCompatActivity() {

    //created array to hold top 5 soccer teams
    val teams = arrayOf<String>("Mam Sundowns FC", "Orlando Pirates", "Bidvest Wits",
        "Stellenbosch FC", "Sek United FC")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val teamsTxt = findViewById<TextView>(R.id.teamsDisplayId)

        //ureassigning position 0 of the teams array
        teams[0] = "Mam Sundowns FC :)"
        //displaying top 5 soccer teams in text view on UI
        teamsTxt.text = Arrays.toString(teams)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}