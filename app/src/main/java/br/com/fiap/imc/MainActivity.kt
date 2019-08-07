package br.com.fiap.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcular.setOnClickListener {
            val proximaTela = Intent(this, ResultadoActivity::class.java)
            proximaTela.putExtra("Peso", inputPeso.text.toString().toDouble())
            proximaTela.putExtra("Altura", inputAltura.text.toString().toDouble())
            proximaTela.putExtra("Sexo", spSexo.selectedItem.toString())
            startActivity(proximaTela)
        }

        btnLimpar.setOnClickListener {
            inputAltura.setText("")
            inputPeso.setText("")
        }
    }
}
