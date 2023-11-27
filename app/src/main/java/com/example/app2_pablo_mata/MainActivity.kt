package com.example.app2_pablo_mata

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var spinner:Spinner
    private lateinit var spinner2:Spinner
    private lateinit var spinner3:Spinner
    private lateinit var spinner4:Spinner

    private lateinit var tvVerNum:TextView
    private lateinit var tvRecibirNum: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        when {
            intent?.action == Intent.ACTION_SEND -> {
                if ("text/plain" == intent.type) {
                    handleSendText(intent) // Handle text being sent
                }
            }

            else -> {
                // Handle other intents, such as being started from the home screen
            }
        }

        tvVerNum = findViewById(R.id.tvVerNums)
        tvRecibirNum = findViewById(R.id.etvNumeroRecibir)

        spinner = findViewById(R.id.spinner)
        spinner2 = findViewById(R.id.spinner2)
        spinner3 = findViewById(R.id.spinner3)
        spinner4 = findViewById(R.id.spinner4)

        // Se crea el adaptador pasando como parámetros
        //Creamos el adaptador pasando como parámetro this(esta actividad)
        //El array que contiene los elementos que va a mostrar
        //La referencia al layout predefinido para el spinner simple
        ArrayAdapter.createFromResource(
            this,
            R.array.numeros_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Se especifica el layout para visualizarlo.
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // se aplica al spinner el adpatador.
            spinner.adapter = adapter
            spinner2.adapter = adapter
            spinner3.adapter = adapter
            spinner4.adapter = adapter
        }
        //Fijo el listener
       spinner.onItemSelectedListener = this

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        tvVerNum.text = spinner.selectedItem.toString() + spinner2.selectedItem.toString() + spinner3.selectedItem.toString() + spinner4.selectedItem.toString()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    private fun handleSendText(intent: Intent) {

        intent.getStringExtra(Intent.EXTRA_TEXT)?.let {
           tvRecibirNum.text
        }
    }


}