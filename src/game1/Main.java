package game1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static Zoo first;

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        first = new Zoo();
        first.name = "собака";
        first.voice = "лает";
        ArrayList vNo = new ArrayList(); //список животных, которые не лают
        first.variantsNo = vNo;
        ArrayList vYes = new ArrayList();
        first.variantsYes = vYes; // список животных, которые лают
        Zoo z = new Zoo();
        String answer = null;
        System.out.println("Загадайте животное и введите 1:");
        checkAnswer("1");
        System.out.println("Это животное " + first.voice + "? Введите \"1\" если да и \"2\" если нет:");
        try {
            answer = reader.readLine();
        } catch (IOException e) {
            System.out.println("Неправильный ввод");
        }        if (answer.equals("1")) {
            System.out.println("Это " + first.name + "? Введите \"1\" если да и \"2\" если нет:");
            tryAnswer(answer);
            if (answer.equals("1")) {
                System.out.println("Спасибо за игру!");
            } else {
                if (answer.equals("2")) {
                    first.addYes();
                } else {
                    System.out.println("неправильный ввод");
                }
            }
        }
        if (answer.equals("2")) {
            first.addNo();
        }
        if (!answer.equals("1") && !answer.equals("2")) {
            System.out.println("неправильный ввод");
        }

        boolean b = true;
        while (b) {
            System.out.println("Сыграем еще? 1 - да, 2 - нет");
            tryAnswer(answer);
            if (answer.equals("1")) {
                first.checkVoice();
            } else {
                b = false;
            }
        }
        System.out.println("До новых встреч!");
    }


    public static void checkAnswer(String s) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = null;
        try {
            s1 = reader.readLine();
        } catch (IOException e) {
            System.out.println("Неправильный ввод");
        }
        if (!s1.equals(s)) {
            System.out.println("Неправильный ввод. Попробуйте снова");
            tryAnswer(s1);
        }
    }


    public static void checkLengh(String s, int len) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (s.length() < len) {
            System.out.println("Неправильный ввод, слишком короткое слово. Должно быть не меньше " + len + " букв Попробуйте снова");
            tryAnswer(s);
            checkLengh(s, len);
        }
    }

    public static void tryAnswer(String s) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            s = reader.readLine();
        } catch (IOException e) {
            System.out.println("Неправильный ввод");
        }
    }
}