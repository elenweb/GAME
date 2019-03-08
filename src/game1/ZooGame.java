package game1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ZooGame {
    static Zoo first;

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        first = new Zoo();
        first.name = "собака";
        first.voice = "лает";
        ArrayList vNo = new ArrayList();
        first.variantsNo = vNo;
        ArrayList vYes = new ArrayList();
        first.variantsYes = vYes;
        Zoo z = new Zoo();
        System.out.println("Загадайте животное и введите 1:");
        checkAnswer("1");
        System.out.println("Это животное " + first.voice + "? Введите \"1\" если да и \"2\" если нет:");
        String answer = null;
        try {
            answer = reader.readLine();
        } catch (IOException e) {
            System.out.println("Неправильный ввод");
        }
        switch (answer) {
            case "2":
                System.out.println("Сдаюсь! Как разгованивает ваше животное (назовите глаголом, как \"лает\" для собаки):");
                try {
                    answer = reader.readLine();
                } catch (IOException e) {
                    System.out.println("Неправильный ввод");
                }
                checkLengh(answer, 4);
                z.voice = answer;
                System.out.println("Как называется это животное?");
                try {
                    answer = reader.readLine();
                } catch (IOException e) {
                    System.out.println("Неправильный ввод");
                }
                checkLengh(answer, 2);
                z.name = answer;
                System.out.print("Вы сказали, что ");
                z.InString();
                System.out.println("Спасибо за игру!");
                first.variantsNo.add(z);
                break;
            case "1":
                System.out.println("Это собака? введите \"1\" если \"да\" и \"2\" если \"нет\":\"");
                try {
                    answer = reader.readLine();
                } catch (IOException e) {
                    System.out.println("Неправильный ввод");
                }
                if (answer.equals("1")) {
                    System.out.println("Спасибо за игру!");
                    break;
                } else {
                    if (answer.equals("2")) {
                        System.out.println("Сдаюсь. Как называется это животное?");
                        try {
                            answer = reader.readLine();
                        } catch (IOException e) {
                            System.out.println("Неправильный ввод");
                        }
                        z.name = answer;
                        z.voice = first.voice;
                        z.InString();
                        first.variantsYes.add(z);
                        System.out.println("Спасибо за игру!");
                        break;
                    } else {
                        System.out.println("Неправильный ввод");
                        break;
                    }
                }
            default:
                System.out.println("Неправильный ввод");
        }
    }

    public static void checkAnswer(String s2) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = null;
        try {
            s1 = reader.readLine();
        } catch (IOException e) {
            System.out.println("Неправильный ввод");
        }
        if (!s1.equals(s2)) {
            System.out.println("Неправильный ввод. Попробуйте снова");
            try {
                s1 = reader.readLine();
            } catch (IOException e) {
                System.out.println("Неправильный ввод");
            }
        }
    }

    public static void checkLengh(String s, int len) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        if (s.length() < len) {
            System.out.println("Неправильный ввод, слишком короткое слово. Должно быть не меньше " + len + " букв Попробуйте снова");
            try {
                s = reader.readLine();
            } catch (IOException e) {
                System.out.println("Неправильный ввод");
            }
            checkLengh(s, len);
        }
    }
}

