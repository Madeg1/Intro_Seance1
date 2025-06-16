package fr.minesnancy.collet.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.Button;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Collections;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    private Quiz quiz;
    private int indexQuestionCourante = 0;
    private TextView questionView;
    private Button[] boutons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        quiz = new Quiz();
        questionView = findViewById(R.id.textQuestion);
        boutons = new Button[] {
                findViewById(R.id.button1),
                findViewById(R.id.button2),
                findViewById(R.id.button3),
                findViewById(R.id.button4)
        };
        afficherQuestion(indexQuestionCourante);
    }

    private void afficherQuestion(int index) {
        if (index >= quiz.getNbCartes()) {
            // Plus de questions
            questionView.setText("Quiz terminé !");
            for (Button b : boutons) {
                b.setEnabled(false);
                b.setText("");
                b.setOnClickListener(null);
            }
            return;
        }

        Carte carte = quiz.getCarte(index);
        questionView.setText(carte.getQuestion());

        Vector<String> reponses = new Vector<>();
        reponses.add(carte.getBonneReponse());
        reponses.addAll(carte.getMauvaisesReponses());
        Collections.shuffle(reponses);  // Mélange aléatoire

        for (int i = 0; i < boutons.length; i++) {
            boutons[i].setText(reponses.get(i));
            if (reponses.get(i).equals(carte.getBonneReponse())) {
                boutons[i].setOnClickListener(this::bravo);
            } else {
                boutons[i].setOnClickListener(this::perdu);
            }

        }
    }

    public void perdu(View view) {
        Toast.makeText(this, "Mauvaise réponse...", Toast.LENGTH_SHORT).show();
    }

    public void bravo(View view) {
        Toast.makeText(this, "Bravo !", Toast.LENGTH_SHORT).show();
        indexQuestionCourante++;
        afficherQuestion(indexQuestionCourante);
    }
}