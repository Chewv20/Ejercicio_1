package com.tallercmovil.ejercicio1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.tallercmovil.ejercicio1.databinding.ActivityMainBinding
import android.widget.Spinner
import androidx.core.view.get

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ArrayAdapter.createFromResource(this, R.array.Formulas,android.R.layout.simple_spinner_item).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinner.adapter = adapter
        }

        binding.spinner.onItemSelectedListener = this
    }

    fun click(view: View) {
        with(binding){

        }
    }

    fun distancia(x1: Int, x2: Int, y1: Int,y2: Int): Double{
        val potencia = 2
        val raiz = 0.5
        val aux1 = x1+x2
        val aux2 = y1+y2
        val aux3 = Math.pow(aux1.toDouble(), potencia.toDouble())
        val aux4 = Math.pow(aux2.toDouble(), potencia.toDouble())
        val resultado = Math.pow(aux3.toDouble()+aux4.toDouble(),raiz)
        return resultado
    }
    fun gravedad(m1: Int, m2: Int,G: Int, r: Int): Double{
        val resultado = (G.toDouble()*m1.toDouble()*m2.toDouble())/r.toDouble()
        return resultado
    }
    fun triangulo(b: Int, h: Int): Double{
        val resultado = 0.5*b.toDouble()*h.toDouble()
        return resultado
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        with(binding){
            when(p2){
                0->{
                    etValor1.hint = getString(R.string.x1)
                    etValor2.hint = getString(R.string.x2)
                    etValor3.hint = getString(R.string.y1)
                    etValor4.hint = getString(R.string.y2)
                    etValor3.visibility = View.VISIBLE
                    etValor4.visibility = View.VISIBLE
                    imageDistancia.visibility = View.VISIBLE
                    imageGravedad.visibility = View.INVISIBLE
                    imageArea.visibility = View.INVISIBLE
                }
                1->{
                    etValor1.hint = getString(R.string.m1)
                    etValor2.hint = getString(R.string.m2)
                    etValor3.hint = getString(R.string.G)
                    etValor4.hint = getString(R.string.r)
                    etValor3.visibility = View.VISIBLE
                    etValor4.visibility = View.VISIBLE
                    imageDistancia.visibility = View.INVISIBLE
                    imageGravedad.visibility = View.VISIBLE
                    imageArea.visibility = View.INVISIBLE
                }
                2->{
                    etValor1.hint = getString(R.string.base)
                    etValor2.hint = getString(R.string.altura)
                    etValor3.visibility = View.INVISIBLE
                    etValor4.visibility = View.INVISIBLE
                    imageDistancia.visibility = View.INVISIBLE
                    imageGravedad.visibility = View.INVISIBLE
                    imageArea.visibility = View.VISIBLE
                }
            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}
