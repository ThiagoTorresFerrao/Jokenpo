package com.example.jokenpo

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random
import android.media.MediaPlayer

class MainActivity : AppCompatActivity() {

    private lateinit var txtResultado: TextView

    // MediaPlayer responsável pela música de fundo do jogo
    private lateinit var musicaFundo: MediaPlayer

    // Referência do botão que controla o som
    private lateinit var btnSom: ImageButton

    // Variável que guarda o estado da música (ligada ou desligada)
    private var musicaLigada = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ---------------------------------------------------
        // INICIANDO A MÚSICA DE FUNDO
        // ---------------------------------------------------

        // Cria um MediaPlayer utilizando o arquivo bt.mp3 da pasta res/raw
        musicaFundo = MediaPlayer.create(this, R.raw.bt)

        // Faz a música repetir infinitamente
        musicaFundo.isLooping = true

        // Inicia a música
        musicaFundo.start()

        txtResultado = findViewById(R.id.txtResultado)

        val btnPedra = findViewById<ImageButton>(R.id.btnPedra)
        val btnPapel = findViewById<ImageButton>(R.id.btnPapel)
        val btnTesoura = findViewById<ImageButton>(R.id.btnTesoura)

        // Conecta o botão de som criado no layout
        btnSom = findViewById(R.id.btnSom)

        btnPedra.setOnClickListener { jogar("Pedra") }
        btnPapel.setOnClickListener { jogar("Papel") }
        btnTesoura.setOnClickListener { jogar("Tesoura") }

        // Evento de clique do botão de som
        btnSom.setOnClickListener {

            // Se a música estiver ligada
            if (musicaLigada) {

                // pausa a música
                musicaFundo.pause()

                // atualiza o estado da música
                musicaLigada = false

                // muda o ícone para "som desligado"
                btnSom.setImageResource(R.drawable.ic_som_off)

            } else {

                // volta a tocar a música
                musicaFundo.start()

                // atualiza o estado da música
                musicaLigada = true

                // muda o ícone para "som ligado"
                btnSom.setImageResource(R.drawable.ic_som_on)
            }
        }
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

        // Cor do texto + som
        when (resultado) {
            "Você venceu!" -> {
                txtResultado.setTextColor(android.graphics.Color.GREEN)
                tocarSom(R.raw.ganhar)
            }

            "Você perdeu!" -> {
                txtResultado.setTextColor(android.graphics.Color.RED)
                tocarSom(R.raw.perder)
            }

            else -> {
                txtResultado.setTextColor(android.graphics.Color.GRAY)
                tocarSom(R.raw.empatar)
            }
        }
    }

    // Função para tocar som
    private fun tocarSom(som: Int) {
        val mediaPlayer = MediaPlayer.create(this, som)
        mediaPlayer.start()

        mediaPlayer.setOnCompletionListener {
            it.release()
        }
    }

    // ---------------------------------------------------
    // FINALIZA A MÚSICA AO FECHAR O APP
    // ---------------------------------------------------

    override fun onDestroy() {
        super.onDestroy()

        // Libera os recursos da música de fundo
        musicaFundo.release()
    }

}