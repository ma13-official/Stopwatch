package com.example.clock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var sw_clock: TextView = findViewById(R.id.stopwatch_clock)
        var sw_st: Button = findViewById(R.id.stopwatch_start_button)
        var sw_cl: Button = findViewById(R.id.stopwatch_clear_button)
        var time: Long = 0
        var startTime: Long = 0
        var stopTime: Long = 0
        var diff: Int = 0
        var flag: Int = 0
        var out: Int = 0
        var secs: Int = 0
        var msecs: Int = 0
        var outsecs = ""
        var outmsecs = ""
        sw_st.setOnClickListener {
            time = System.currentTimeMillis()
            flag++
            if (flag % 2 == 1){
                startTime = time
                sw_st.text = "Stop"
            }
            else {
                stopTime = time
                sw_st.text = "Start"
                diff += (stopTime - startTime).toInt()
                out = diff / 10
                secs = out / 100
                if (secs < 10){
                    outsecs = "0$secs"
                }
                else{
                    outsecs = "$secs"
                }
                msecs = out % 100
                if (msecs < 10){
                    outmsecs = "0$msecs"
                }
                else{
                    outmsecs = "$msecs"
                }
                sw_clock.text = "00:$outsecs:$outmsecs"
                sw_cl.setOnClickListener {
                    diff = 0
                    sw_clock.text = "00:00:00"
                }
            }
        }
    }
}