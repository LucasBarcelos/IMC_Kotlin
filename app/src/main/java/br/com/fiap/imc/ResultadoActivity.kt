package br.com.fiap.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        calcular(0.0,0.0)
    }

    private fun calcular(altura: Double, peso: Double) {
        val peso = intent.getDoubleExtra("Peso", 0.0)
        val altura = intent.getDoubleExtra("Altura", 0.0)
        val sexo = intent.getStringExtra("Sexo") ?: getString(R.string.label_feminino)

        when (sexo) {
            getString(R.string.label_feminino) -> {calculoFeminino(imc)}
            getString(R.string.label_masculino) -> {calculoMasculino(imc)}
            else -> println("Escolhe algum ae")
        }

        val imc = peso / (altura * altura)
    }

    private fun calculoFeminino(imc: Double) {
        if (imc < 20) {
            tvIMC.text = imc.toFixed(2)
            tvStatusIMC.text = getString(R.string.peso_abaixo)
            configuraImagem(R.drawable.fem_abaixo)
        } else if (imc < 25) {
            tvIMC.text = imc.toFixed(2)
            tvStatusIMC.text = getString(R.string.peso_ideal)
            configuraImagem(R.drawable.fem_ideal)
        } else if (imc < 30) {
            tvIMC.text = imc.toFixed(2)
            tvStatusIMC.text = getString(R.string.sobrepeso)
            configuraImagem(R.drawable.fem_sobre)
        } else if (imc < 40) {
            tvIMC.text = imc.toFixed(2)
            tvStatusIMC.text = getString(R.string.obeso)
            configuraImagem(R.drawable.fem_obeso)
        } else {
            tvIMC.text = imc.toFixed(2)
            tvStatusIMC.text = getString(R.string.obesidade_extrema)
            configuraImagem(R.drawable.fem_extremo_obeso)
        }
    }

    private fun calculoMasculino(imc: Double) {
        if (imc < 20) {
            tvIMC.text = imc.toFixed(2)
            tvStatusIMC.text = getString(R.string.peso_abaixo)
            configuraImagem(R.drawable.masc_abaixo)
        } else if (imc < 25) {
            tvIMC.text = imc.toFixed(2)
            tvStatusIMC.text = getString(R.string.peso_ideal)
            configuraImagem(R.drawable.masc_ideal)
        } else if (imc < 30) {
            tvIMC.text = imc.toFixed(2)
            tvStatusIMC.text = getString(R.string.sobrepeso)
            configuraImagem(R.drawable.masc_sobre)
        } else if (imc < 40) {
            tvIMC.text = imc.toFixed(2)
            tvStatusIMC.text = getString(R.string.obeso)
            configuraImagem(R.drawable.masc_obeso)
        } else {
            tvIMC.text = imc.toFixed(2)
            tvStatusIMC.text = getString(R.string.obesidade_extrema)
            configuraImagem(R.drawable.masc_extremo_obeso)
        }
    }

    private fun configuraImagem(resourceId: Int) {
        ivIMC.setImageDrawable(ContextCompat.getDrawable(this, resourceId))
    }
}
