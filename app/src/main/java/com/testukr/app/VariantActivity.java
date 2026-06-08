package com.testukr.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class VariantActivity extends AppCompatActivity {

    int currentQuestion = 0;
    int score = 0;
    int variantNum = 1;

    String[][] questions;
    int[] correct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_variant);

        variantNum = getIntent().getIntExtra("variant", 1);
        loadQuestions(variantNum);
        showQuestion();

        Button b1 = findViewById(R.id.btnAns1);
        Button b2 = findViewById(R.id.btnAns2);
        Button b3 = findViewById(R.id.btnAns3);
        Button b4 = findViewById(R.id.btnAns4);

        b1.setOnClickListener(v -> checkAnswer(0));
        b2.setOnClickListener(v -> checkAnswer(1));
        b3.setOnClickListener(v -> checkAnswer(2));
        b4.setOnClickListener(v -> checkAnswer(3));
    }

    void loadQuestions(int variant) {
        if (variant == 1) {
            questions = new String[][]{
                {
                    "Яке слово пишеться з великої літери?",
                    "місто", "київ", "книга", "школа"
                },
                {
                    "Скільки літер в українському алфавіті?",
                    "30", "32", "33", "28"
                },
                {
                    "Як правильно написати слово?",
                    "сонце", "сонцє", "сонсе", "санце"
                },
                {
                    "Яке слово є іменником?",
                    "бігти", "червоний", "небо", "швидко"
                },
                {
                    "Як правильно написати слово?",
                    "молоко", "молако", "малако", "молако"
                }
            };
            correct = new int[]{1, 2, 0, 2, 0};

        } else if (variant == 2) {
            questions = new String[][]{
                {
                    "Яке речення написано правильно?",
                    "Я іду у школа.",
                    "Я іду до школи.",
                    "Я іду в школи.",
                    "Я іду школи."
                },
                {
                    "Знайди слово з апострофом:",
                    "память", "пять", "мяч", "м'яч"
                },
                {
                    "Яке слово є дієсловом?",
                    "стрибок", "стрибати", "стрибун", "стрибком"
                },
                {
                    "Скільки голосних у слові «Україна»?",
                    "3", "4", "5", "6"
                },
                {
                    "Як правильно написати?",
                    "пишіть", "пиштє", "пишьте", "пиштe"
                }
            };
            correct = new int[]{1, 3, 1, 2, 0};

        } else {
            questions = new String[][]{
                {
                    "Яке слово пишеться з м'яким знаком?",
                    "сіль", "сил", "сала", "сало"
                },
                {
                    "Знайди прикметник серед слів:",
                    "бігти", "синій", "книга", "читати"
                },
                {
                    "Яке слово НЕ є назвою тварини?",
                    "вовк", "лисиця", "дерево", "заєць"
                },
                {
                    "Як правильно написати?",
                    "щасте", "щастя", "щасьтя", "щасття"
                },
                {
    "Скільки складів у слові «соняшник»?",
    "2", "3", "4", "1"
},
            };
            correct = new int[]{0, 1, 2, 1, 1};
        }
    }

    void showQuestion() {
        TextView tvTitle = findViewById(R.id.tvVariantTitle);
        TextView tvNum = findViewById(R.id.tvQuestionNum);
        TextView tvQ = findViewById(R.id.tvQuestion);
        Button b1 = findViewById(R.id.btnAns1);
        Button b2 = findViewById(R.id.btnAns2);
        Button b3 = findViewById(R.id.btnAns3);
        Button b4 = findViewById(R.id.btnAns4);

        tvTitle.setText("ВАРІАНТ " + variantNum);
        tvNum.setText("Питання " + (currentQuestion + 1) + " з 5");
        tvQ.setText(questions[currentQuestion][0]);
        b1.setText("1. " + questions[currentQuestion][1]);
        b2.setText("2. " + questions[currentQuestion][2]);
        b3.setText("3. " + questions[currentQuestion][3]);
        b4.setText("4. " + questions[currentQuestion][4]);
    }

    void checkAnswer(int chosen) {
        if (chosen == correct[currentQuestion]) {
            score++;
        }
        currentQuestion++;
        if (currentQuestion < 5) {
            showQuestion();
        } else {
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("score", score);
            startActivity(intent);
            finish();
        }
    }
}
