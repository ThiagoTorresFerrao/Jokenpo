package com.example.jokenpo

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtResultado = findViewById(R.id.txtResultado)

        val btnPedra = findViewById<ImageButton>(R.id.btnPedra)
        val btnPapel = findViewById<ImageButton>(R.id.btnPapel)
        val btnTesoura = findViewById<ImageButton>(R.id.btnTesoura)

        btnPedra.setOnClickListener { jogar("Pedra") }
        btnPapel.setOnClickListener { jogar("Papel") }
        btnTesoura.setOnClickListener { jogar("Tesoura") }
    }

    private fun jogar(escolhaUsuario: String) {
        val opcoes = listOf("Pedra", "Papel", "Tesoura")
        val escolhaAndroid = opcoes[Random.nextInt(3)]

        val resultado = when {
            escolhaUsuario == escolhaAndroid -> "Empate!"
            (escolhaUsuario == "Pedra" && escolhaAndroid == "Tesoura") ||
                    (escolhaUsuario == "Papel" && escolhaAndroid == "Pedra") ||
                    (escolhaUsuario == "Tesoura" && escolhaAndroid == "Papel") -> "Você venceu!"
            else -> "Você perdeu!"
        }

        txtResultado.text = """
            Você: $escolhaUsuario
            Android: $escolhaAndroid
            
            $resultado
        """.trimIndent()

        // AQUI entra a cor dinâmica
        when (resultado) {
            "Você venceu!" -> txtResultado.setTextColor(android.graphics.Color.GREEN)
            "Você perdeu!" -> txtResultado.setTextColor(android.graphics.Color.RED)
            else -> txtResultado.setTextColor(android.graphics.Color.GRAY)
        }
    }
}