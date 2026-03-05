# 📱 Jokenpo App (Kotlin - Android)

## 🇧🇷 Sobre o Projeto

Este projeto consiste em um aplicativo Android do clássico jogo **Pedra,
Papel e Tesoura (Jokenpô)**, desenvolvido utilizando **Kotlin** no
**Android Studio**.

🎯 **Objetivo principal:**\
Este projeto foi criado por **Thiago Torres** com finalidade educacional
e é utilizado para ensinar os **fundamentos de desenvolvimento Android
com Kotlin** para os alunos do **SENAC -- turma 2026.1**.

Mais do que um simples jogo, este projeto serve como **base prática para
introduzir conceitos essenciais de programação mobile**, incluindo
interação com hardware do dispositivo e feedback visual e sonoro.

------------------------------------------------------------------------

# 🎮 Demonstração do Jogo

O jogador escolhe entre:

✊ Pedra\
✋ Papel\
✌️ Tesoura

O Android realiza uma escolha aleatória e o resultado é exibido na tela.

Durante a jogada o jogo inclui:

-   Delay simulando o "pensamento" do Android
-   Animação das mãos
-   Feedback visual do resultado
-   Sons de vitória, derrota e empate
-   Vibração do dispositivo ao perder
-   Piscar da lanterna ao vencer

Esses recursos tornam o projeto **mais interativo e realista para fins
educacionais**.

------------------------------------------------------------------------

# 🚀 O que os alunos aprendem com este projeto

Este projeto é utilizado em sala de aula para ensinar:

-   Estrutura de um projeto Android
-   Uso de **Activities**
-   Manipulação de **componentes de interface (UI)**
-   Trabalhar com **eventos de clique**
-   Lógica de programação aplicada
-   Uso de **Random (aleatoriedade)**
-   Atualização dinâmica da interface
-   Organização de código Kotlin
-   Manipulação de **imagens e layouts**
-   Uso de **Handlers e Delay**
-   Controle de **visibilidade de elementos**
-   Integração com **hardware do dispositivo (vibração e flash)**

------------------------------------------------------------------------

# ⚡ Funcionalidades do Aplicativo

O aplicativo possui diversas funcionalidades implementadas para
enriquecer a experiência do usuário:

### 🎮 Jogabilidade

-   Escolha entre Pedra, Papel ou Tesoura
-   Jogada do computador gerada aleatoriamente
-   Exibição do resultado (vitória, derrota ou empate)

### 🎨 Interface e Experiência

-   Interface simples e intuitiva
-   Animação das mãos durante o "pensamento" do Android
-   Revelação da jogada do Android com animação
-   Exibição simultânea da jogada do jogador e do Android
-   Reset automático da interface após cada rodada

### 🔊 Feedback Multimídia

-   Sons personalizados para vitória, derrota e empate
-   Música de fundo durante o jogo
-   Botão para **ativar ou desativar o som**

### 📳 Interação com Hardware

-   **Vibração do dispositivo ao perder**
-   **Piscar da lanterna ao vencer**

Esses recursos permitem apresentar aos alunos exemplos práticos de
**interação com recursos nativos do Android**.

------------------------------------------------------------------------

# 🛠️ Tecnologias Utilizadas

-   **Kotlin**
-   **Android Studio**
-   **Android SDK**
-   **XML (Layouts)**
-   **MediaPlayer (sons e música)**
-   **CameraManager (lanterna)**
-   **Vibrator API**
-   **ObjectAnimator (animações)**

------------------------------------------------------------------------

# 📁 Estrutura do Projeto

    Jokenpo/
    ├── app/
    │   ├── src/
    │   │   ├── main/
    │   │   │   ├── java/com/example/jokenpo/
    │   │   │   │   └── MainActivity.kt
    │   │   │   ├── res/
    │   │   │   │   ├── layout/
    │   │   │   │   │   └── activity_main.xml
    │   │   │   │   ├── drawable/
    │   │   │   │   ├── raw/
    │   │   │   │   ├── mipmap/
    │   │   │   │   └── values/
    │   │   │   └── AndroidManifest.xml
    ├── build.gradle
    └── settings.gradle

📌 **Descrição:**

-   `MainActivity.kt` → lógica principal do jogo\
-   `activity_main.xml` → interface do usuário\
-   `drawable/` → imagens das mãos do jogo\
-   `raw/` → arquivos de áudio utilizados no app\
-   `values/` → cores, strings e estilos

------------------------------------------------------------------------

# 📚 Contexto Educacional

Este projeto foi aplicado em sala de aula como **atividade prática de
introdução ao desenvolvimento Android**.

💡 A proposta é permitir que os alunos:

-   Entendam na prática como funciona um aplicativo mobile
-   Desenvolvam **raciocínio lógico**
-   Aprendam conceitos fundamentais de **Kotlin**
-   Trabalhem com **UI Android**
-   Criem seus primeiros projetos reais

Esse tipo de projeto ajuda os alunos a **ganhar confiança para evoluir
para aplicações mais complexas**.

------------------------------------------------------------------------

# ▶️ Como executar o projeto

Clone o repositório:

``` bash
git clone https://github.com/ThiagoTorresFerrao/Jokenpo.git
```

Abra no **Android Studio** e execute em:

-   📱 Dispositivo físico
-   🤖 Emulador Android

------------------------------------------------------------------------

# 💡 Possíveis Melhorias Futuras

Este projeto pode ser expandido para ensinar novos conceitos:

-   Sistema de **placar (Player vs Android)**
-   Animação estilo **"JO-KEN-PÔ"**
-   Multiplayer local
-   Persistência de dados
-   Integração com APIs
-   Publicação na **Google Play Store**

------------------------------------------------------------------------

# 👨‍🏫 Autor

Desenvolvido por **Thiago Torres**

Professor e desenvolvedor apaixonado por tecnologia e ensino.

------------------------------------------------------------------------

# 🇺🇸 About the Project

This project is an Android application of the classic **Rock, Paper,
Scissors (Jokenpo)** game developed using **Kotlin** in **Android
Studio**.

🎯 **Main purpose:**\
The project was created for educational purposes to teach **Android
development fundamentals** to **SENAC students (Class 2026.1)**.

More than just a game, it works as a **hands‑on introduction to mobile
development concepts**.

------------------------------------------------------------------------

# 🚀 What Students Learn

Students learn important Android concepts such as:

-   Android project structure
-   Activities
-   UI component manipulation
-   Click event handling
-   Random game logic
-   Dynamic UI updates
-   Kotlin code organization
-   Animations and visual feedback
-   Device hardware interaction (vibration and flashlight)

------------------------------------------------------------------------

# 📱 App Features

-   Rock, Paper, Scissors gameplay
-   Random computer move
-   Animated UI feedback
-   Sound effects and background music
-   Device vibration when losing
-   Flashlight blinking when winning
-   Automatic round reset
-   Interactive and beginner-friendly design

------------------------------------------------------------------------

# 🛠️ Technologies

-   Kotlin
-   Android Studio
-   Android SDK
-   XML Layouts
-   MediaPlayer
-   Vibrator API
-   CameraManager API
-   ObjectAnimator

------------------------------------------------------------------------

# ⭐ Final Note

Feel free to explore, modify, and improve this project.

Learning by building real projects is one of the best ways to grow as a
developer 🚀
