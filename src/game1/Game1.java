package game1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Game1 {
    static Animal first;

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        first = new Animal();
        first.name = "собака";



        Animal last = first;
        System.out.println("Мое любимое животное " + first.name);
        System.out.println("Введите названия ваших любимых животных по одному, когда закончите введите \"1\":");
        while (true) {
            try {
                String animalName;
                animalName = reader.readLine();
                if (animalName.equals("1")) {
                    break;
                }
                last.next = new Animal();
                last.next.name = animalName;
                last = last.next;
            } catch (Exception e) {
                System.out.println("Неправильный ввод!!!");
            }
        }

        Animal a1 = first;
        while (!(a1 == null)) {
            System.out.println(a1.name);
            a1 = a1.next;
        }
    }
}

