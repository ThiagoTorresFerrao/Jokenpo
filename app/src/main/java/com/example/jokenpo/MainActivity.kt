package com.example.jokenpo

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random
import android.media.MediaPlayer

// IMPORTS ADICIONADOS VIBRACAO ↓↓↓
import android.os.Vibrator
import android.os.VibrationEffect
import android.content.Context
import android.os.Build

// IMPORTS ADICIONADOS FLASH ↓↓↓
import android.hardware.camera2.CameraManager
import android.os.Handler
import android.os.Looper

//IMPORT PARA ANIMAÇÃO
import android.animation.ObjectAnimator

// IMPORT PARA MÃO DO ANDROID
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private lateinit var txtResultado: TextView

    // BOTÕES DAS MÃOS COMO VARIÁVEIS DA CLASSE
    private lateinit var btnPedra: ImageButton
    private lateinit var btnPapel: ImageButton
    private lateinit var btnTesoura: ImageButton

    // ADICIONADO IMAGEM
    private lateinit var imgAndroid: ImageView

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

        // ANIMAÇÃO DA MENSAGEM INICIAL
        txtResultado.alpha = 0f

        txtResultado.animate()
            .alpha(1f)
            .setDuration(2000)

        Handler(Looper.getMainLooper()).postDelayed({

            txtResultado.text = "Escolha uma opção"

        }, 3000)

        // ALTERADO - REMOVIDO "val" PARA USAR AS VARIÁVEIS DA CLASSE
        btnPedra = findViewById(R.id.btnPedra)
        btnPapel = findViewById(R.id.btnPapel)
        btnTesoura = findViewById(R.id.btnTesoura)

        // ADICIONADO IMAGEM DA MÃO DO ANDROID
        imgAndroid = findViewById(R.id.imgAndroid)

        // ESCONDE A MÃO DO ANDROID AO INICIAR O APP
        imgAndroid.visibility = ImageView.INVISIBLE

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

        // Mostra mensagem de "pensando"
        txtResultado.text = "Android está pensando..."

        // ADICIONADO - ESCONDE BOTÕES QUE NÃO FORAM ESCOLHIDOS
        when (escolhaUsuario) {

            "Pedra" -> {
                btnPapel.visibility = ImageButton.INVISIBLE
                btnTesoura.visibility = ImageButton.INVISIBLE
            }

            "Papel" -> {
                btnPedra.visibility = ImageButton.INVISIBLE
                btnTesoura.visibility = ImageButton.INVISIBLE
            }

            "Tesoura" -> {
                btnPedra.visibility = ImageButton.INVISIBLE
                btnPapel.visibility = ImageButton.INVISIBLE
            }
        }

        // ADICIONADO - GARANTE QUE A MÃO DO ANDROID FIQUE ESCONDIDA ENQUANTO PENSA
        imgAndroid.visibility = ImageView.INVISIBLE

        // ANIMAÇÃO DAS MÃOS ENQUANTO O ANDROID "PENSA"
        animarMao(btnPedra)
        animarMao(btnPapel)
        animarMao(btnTesoura)

        // Delay de 1 segundo antes de mostrar o resultado
        Handler(Looper.getMainLooper()).postDelayed({

            val opcoes = listOf("Pedra", "Papel", "Tesoura")
            val escolhaAndroid = opcoes[Random.nextInt(3)]

            // MOSTRA A IMAGEM DA JOGADA DO ANDROID
            when (escolhaAndroid) {
                "Pedra" -> imgAndroid.setImageResource(R.drawable.pedra)
                "Papel" -> imgAndroid.setImageResource(R.drawable.papel)
                "Tesoura" -> imgAndroid.setImageResource(R.drawable.tesoura)
            }

            // ADICIONADO - AGORA A MÃO DO ANDROID FICA VISÍVEL
            imgAndroid.visibility = ImageView.VISIBLE

            // ANIMAÇÃO DE SURGIMENTO DA MÃO DO ANDROID
            imgAndroid.scaleX = 0f
            imgAndroid.scaleY = 0f

            imgAndroid.animate()
                .scaleX(1f)
                .scaleY(1f)
                .setDuration(300)

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
                    piscarLanterna() // chama a lanterna quando o jogador ganha
                }

                "Você perdeu!" -> {
                    txtResultado.setTextColor(android.graphics.Color.RED)
                    tocarSom(R.raw.perder)
                    vibrarCelular() // chama a vibração quando o jogador perde
                }

                else -> {
                    txtResultado.setTextColor(android.graphics.Color.GRAY)
                    tocarSom(R.raw.empatar)
                }
            }

            // ADICIONADO - AGUARDA 2 SEGUNDOS E REINICIA O JOGO
            Handler(Looper.getMainLooper()).postDelayed({

                txtResultado.text = "Escolha uma opção"

                // ESCONDE A MÃO DO ANDROID
                imgAndroid.visibility = ImageView.INVISIBLE

                // MOSTRA NOVAMENTE TODAS AS MÃOS DO JOGADOR
                btnPedra.visibility = ImageButton.VISIBLE
                btnPapel.visibility = ImageButton.VISIBLE
                btnTesoura.visibility = ImageButton.VISIBLE

            }, 2000)

        }, 1000) // ← 1000ms = 1 segundo
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

    // FUNÇÃO RESPONSÁVEL POR FAZER O CELULAR VIBRAR
    private fun vibrarCelular() {

        // Obtém o serviço de vibração do sistema
        val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            // Vibração para Android moderno
            val effect = VibrationEffect.createOneShot(
                500, // duração da vibração em milissegundos
                VibrationEffect.DEFAULT_AMPLITUDE
            )

            vibrator.vibrate(effect)

        } else {

            // Vibração para versões antigas do Android
            vibrator.vibrate(500)
        }
    }

    // FUNÇÃO QUE FAZ A LANTERNA PISCAR
    private fun piscarLanterna() {

        val cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        val cameraId = cameraManager.cameraIdList[0]

        val handler = Handler(Looper.getMainLooper())

        for (i in 0..4) {

            handler.postDelayed({

                try {
                    cameraManager.setTorchMode(cameraId, true)

                    handler.postDelayed({
                        cameraManager.setTorchMode(cameraId, false)
                    }, 150)

                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }, (i * 300).toLong())

        }
    }

    // FUNÇÃO QUE FAZ A ANIMAÇÃO DAS MÃOS
    private fun animarMao(botao: ImageButton) {

        val animator = ObjectAnimator.ofFloat(botao, "translationY", 0f, -30f, 0f)

        animator.duration = 200
        animator.repeatCount = 4

        animator.start()
    }

}