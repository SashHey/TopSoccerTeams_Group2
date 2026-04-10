package com.example.topsoccerteams

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Arrays

    //created function to display array values in terminal
    fun logArrValues(arr: Array<String>, limit: Int = 0){
        //if statement to check if there is a limit - if there is a limit, cut the array at that index
        if (limit == 0){
            Log.v("Array values: ", Arrays.toString(arr))
        }
        else
        {
            Log.v("Array values: ", Arrays.toString(arr.sliceArray(0..limit - 1)))
        }
    }

class MainActivity : AppCompatActivity() {

    //created array to hold top 5 soccer teams
    val teams = arrayOf<String>("Mam Sundowns FC", "Orlando Pirates", "Bidvest Wits",
        "Stellenbosch FC", "Sek United FC")

    //function here ---------------------------------------------------------------

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //function here ------------------------------------------------------------
        val teamsTxt = findViewById<TextView>(R.id.teamsDisplayId)
        var teamsDisplay = ""
        var count = 0

        //calling logArrValues function
        logArrValues(teams)

        //reassigning position 0 of the teams array
        teams[0] = "Mam Sundowns FC :)"

        //while loop to iterate through the teams array and display them
//        while(count < teams.count()){
//            teamsDisplay += "${teams[count]}\n"
//            count++
//        }

        //for loop to iterate through the teams array and display them
        for (team in teams){
            teamsDisplay += "${teams}\n"
        }

        //displaying top 5 soccer teams in text view on UI
        teamsTxt.text = teamsDisplay

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}