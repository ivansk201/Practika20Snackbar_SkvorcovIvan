package com.example.zad2rab2test2skvorcov

import android.graphics.Color

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout

import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var coordLayout: CoordinatorLayout
    private lateinit var buttonDefault: Button
    private lateinit var buttonCallAction: Button
    private lateinit var buttonCustom: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener(this)
        coordLayout = findViewById(R.id.coordLayout)
        val contentMainLayout = findViewById<View>(R.id.content_main_layout)
        buttonDefault = contentMainLayout.findViewById(R.id.button_default)
        buttonCallAction = contentMainLayout.findViewById(R.id.button_call_action)
        buttonCustom = contentMainLayout.findViewById(R.id.button_custom)
        buttonDefault.setOnClickListener(this)
        buttonCallAction.setOnClickListener(this)
        buttonCustom.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.button_default -> {
                    Snackbar.make(coordLayout, "Не видно что там написано((", Snackbar.LENGTH_LONG).show()
            }
            R.id.button_call_action -> { val snackbar = Snackbar.make(coordLayout, "Вы изменили что-то", Snackbar.LENGTH_LONG).setAction("Вернуть как было?")
                {
                    Snackbar.make(coordLayout, "Все вернулось на свои места!", Snackbar.LENGTH_SHORT).show()
                }
                snackbar.show()
            }
            R.id.button_custom -> { val snackbar = Snackbar.make(coordLayout, "Повторите еще раз!", Snackbar.LENGTH_LONG).setAction("Повторить") {}
                snackbar.setActionTextColor(Color.CYAN)
                snackbar.view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
                snackbar.show()
            }
            R.id.fab -> { Snackbar.make(view, "Вы нажали на FloatingActionButton", Snackbar.LENGTH_LONG).show()
            }
        }

    }
}