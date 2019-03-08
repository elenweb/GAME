package game1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList();

public class ZooGame {
    static Zoo first;

    public static void main(String[] args) throws IOException {
        first = new Zoo();
        first.name = "собака";
        first.voice = "Оно лает? ";
        System.out.println("Загадайте животное и введите 1:");
        checkAnswer("1");
        System.out.println("Это животное " + first.voice + "? Введите \"1\" если да и \"2\" если нет:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String answer = reader.readLine();
        if (answer.equals("2")) {
            System.out.println("Сдаюсь! Как разгованивает ваше животное (назовите глаголом, как \"лает\" для собаки):");
            answer = reader.readLine();
            checkLengh(answer, 4);
            Zoo z = new Zoo();
            z.voice = answer;
            System.out.println("Как называется это животное?");
            answer = reader.readLine();
            checkLengh(answer, 2);
            z.name = answer;
            System.out.print("Вы сказали, что");
            z.InString();
            System.out.println("Спасибо за игру!");
            first.variantsNo.add(z);
        } else {
            if (answer.equals("1")) {
                System.out.println("Это собака? введите \"1\" если да и \"2\" если нет:\"");
                answer = reader.readLine();
                if (answer.equals("1") || answer.equals("2")) {
                    if (answer.equals("2")) {
                        System.out.println("Спасибо за игру!");
                    } else {
                        Zoo z = new Zoo();
                        System.out.println("Как называется это животное?");
                        answer = reader.readLine();
                        z.name = answer;
                        z.voice = first.voice;
                        z.InString();
                        first.variantsYes.add(z);
                        System.out.println("Спасибо за игру!");
                    }
                } else {

                }
            }
        }
    }
        public static void checkAnswer (String s2){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String s1 = reader.readLine();
            if (!s1.equals(s2)) {
                System.out.println("Неправильный ввод. Попробуйте снова");
                s1 = reader.readLine();
            }
        }


        public static void checkLengh (String s,int len){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            if (s.length() < len) {
                System.out.println("Неправильный ввод, слишком короткое слово. Должно быть не меньше " + len + " букв Попробуйте снова");
                s = reader.readLine();
                checkLengh(s, len);
            }
        }
    }
