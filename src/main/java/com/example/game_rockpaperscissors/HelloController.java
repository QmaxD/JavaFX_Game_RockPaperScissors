package com.example.game_rockpaperscissors;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Random;

public class HelloController {
    String[] cc = new String[]{ "Камень", "Бумага", "Ножницы" };
    private String personChoice = "";
    private String AIChoice = "";
    int[] count = new int[]{0, 0};

    @FXML
    private Label Text;
    @FXML
    private Label PersonalText;
    @FXML
    private Label AIText;
    @FXML
    private Label Result;
    @FXML
    private Button ButtonRandom;
    @FXML
    private Button ButtonRock;
    @FXML
    private Button ButtonPaper;
    @FXML
    private Button ButtonScissors;
    @FXML
    protected void ButtonClick_Rock() throws InterruptedException {
        PersonalText.setText("Камень");
        personChoice = "Камень";
        AIText.setText("Ожидаем");
        Logic();
    }
    @FXML
    protected void ButtonClick_Paper() throws InterruptedException {
        PersonalText.setText("Бумага");
        personChoice = "Бумага";
        AIText.setText("Ожидаем");
        Logic();
    }
    @FXML
    protected void ButtonClick_Scissors() throws InterruptedException {
        PersonalText.setText("Ножницы");
        personChoice = "Ножницы";
        AIText.setText("Ожидаем");
        Logic();
    }
    @FXML
    protected void ButtonClick_Random() throws InterruptedException {
        personChoice = "Рандом";
        AIText.setText("Ожидаем");
        Logic();
    }

    void Logic() throws InterruptedException {
        Random rnd = new Random();
        if (!personChoice.equals("Рандом")) {
            int n = rnd.nextInt(0, 3);
            AIText.setText(cc[n]);
            AIChoice = cc[n];
        }
        else {
            int n = rnd.nextInt(0, 3);
            PersonalText.setText(cc[n]);
            personChoice = cc[n];
            n = rnd.nextInt(0, 3);
            AIText.setText(cc[n]);
            AIChoice = cc[n];
        }

        if ( personChoice.equals(AIChoice))
                Result.setText("Ничья.");
        else if ( (personChoice.equals("Камень") && AIChoice.equals("Ножницы"))
                || (personChoice.equals("Ножницы") && AIChoice.equals("Бумага"))
                || (personChoice.equals("Бумага") && AIChoice.equals("Камень")) ) {
            count[0] += 1;
            Result.setText("Вы победили!");
        }
        else {
            count[1] += 1;
            Result.setText("Вы проиграли...");
        }
        Restart();
    }

    void Restart() {
        Text.setText("Счёт" + count[0] + ":" + count[1] + " Выберите снова иконку, если хотите продолжить.");
    }


}