package com.example.animequotes

import Json4Kotlin_Base
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders


class MainActivity : AppCompatActivity() {
    lateinit var anime: TextView
    lateinit var quote: TextView
    lateinit var character: TextView
    lateinit var  next :Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        anime = findViewById(R.id.anime)
        quote = findViewById(R.id.quote)
        character = findViewById(R.id.character)
        next = findViewById<Button>(R.id.nextButton)

        getResult()

        next.setOnClickListener {
            getResult()
        }
    }

    private    fun getResult() {
            val model: MyViewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)
            model.getQuotes()?.observe(this,
                Observer<Json4Kotlin_Base> { quoteList ->
                    Log.i("dineeeeee", "donee")
                    anime.text = quoteList.anime
                    quote.text = quoteList.quote
                    character.text = quoteList.character

                })
        }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.shareButton -> {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(
                    Intent.EXTRA_TEXT,
                    "heyy check this Quote....... ${quote.text.toString()}"
                )
                val chooser = Intent.createChooser(intent, "share this quote using....")
                startActivity(chooser)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}










