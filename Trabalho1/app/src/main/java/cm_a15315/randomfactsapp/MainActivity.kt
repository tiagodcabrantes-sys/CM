package cm_a15315.randomfactsapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val factText = findViewById<TextView>(R.id.factText)
        val factImage = findViewById<ImageView>(R.id.factImage)
        val factButton = findViewById<Button>(R.id.factButton)
        val facts = listOf("Há mais de 700 linguagens de programação.",
            "O primeiro vírus num computador foi criado por Bob Thomas nos anos de 1970.",
            "O primeiro computador eletrónico,foi desenvolvido em 1945,ainda na segunda guerra mundial e pesava mais de 27 toneladas.",
            "Origem do bug:Em 1947 quando engenheiros trabalhavam no computador Harvard Mark II encontraram uma mariposa presa num relé do computador o que estava a causar um erro no sistema.",
            "O primeiro programador da historia foi Ada Lovelace em 1843.",
            "A primeira rede que originou a internet foi a ARPANET, onde um estudante em 1969 tentou enviar a palavra LOGIN para outro computador mas o sistema caiu após as duas primeiras letras.",
            "O primeiro robô industrial surgiu em 1961 e servia para movimentar peças pesadas e perigosas.",
            "O wifi apareceu nos anos 1990 e começou a ser usada em 1997.",
            "O primeiro telemóvel Android apareceu em 2008 e foi o HTC Dream.",
            "O android é o sistema operativo mais usado do mundo.",
            "O primeiro disco rígido foi criado em 1956 pela IBM e possuia apenas 5MB de armazenamento.",
            "O sistema operativo Linux foi criado em 1991 por Linus Torvalds que era apenas um estudante universitário quando começou o projeto",
            )

        val images = listOf(R.drawable.linguagens_programacao,
            R.drawable.virus,
            R.drawable.eniac,
            R.drawable.bug,
            R.drawable.ada_lovelace,
            R.drawable.arpanet,
            R.drawable.robo_industrial,
            R.drawable.wifi,
            R.drawable.htc_telefone,
            R.drawable.android,
            R.drawable.disco_rigido,
            R.drawable.linux)

        var lastIndex = -1
        factButton.setOnClickListener {

            var randomIndex: Int

            do {
                randomIndex = facts.indices.random()
            } while (randomIndex == lastIndex)

            lastIndex = randomIndex

            factText.text = facts[randomIndex]
            factImage.setImageResource(images[randomIndex])

            factButton.text = "Next Fact!"
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}