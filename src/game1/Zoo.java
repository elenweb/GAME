package game1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Zoo {
    String name;
    Zoo next;
    String voice;
    ArrayList<Zoo> variantsNo;
    ArrayList<Zoo> variantsYes;

    public void InString (){
        System.out.println(this.name + " " + this.voice);
    }

    private static void checkLengh(String s, int len) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        if (s.length() < len) {
            System.out.println("Неправильный ввод, слишком короткое слово. Должно быть не меньше " + len + " букв Попробуйте снова");
            try {
                s = reader.readLine();
            } catch (IOException e) {
                System.out.println("Неправильный ввод");
            }
            //checkLengh(s, len);
        }
    }

  public void addNo() {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      Zoo z = new Zoo();
      String answer = null;
      System.out.println("Сдаюсь! Как разгованивает ваше животное (например \"лает\" для собаки):");
      try {
          z.voice = reader.readLine();
      } catch (IOException e) {
          System.out.println("Неправильный ввод");
      }
      //checkLengh(answer, 4);
     // z.voice = answer;
      System.out.println("Как называется это животное?");
      try {
          answer = reader.readLine();
      } catch (IOException e) {
          System.out.println("Неправильный ввод");
      }
      //checkLengh(answer, 2);
      z.name = answer;
      System.out.print("Вы сказали, что ");
      z.InString();
      //System.out.println("Спасибо за игру!");
      this.variantsNo.add(z);
  }
  public void addYes() {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      Zoo z = new Zoo();
      String answer = null;
      System.out.println("Сдаюсь! Как называется это животное?");
      try {
          answer = reader.readLine();
      } catch (IOException e) {
          System.out.println("Неправильный ввод");
      }
      //checkLengh(answer, 2);
      z.name = answer;
      z.voice = this.voice;
      System.out.print("Вы сказали, что ");
      z.InString();
      //System.out.println("Спасибо за игру!");
      this.variantsYes.add(z);
  }

    public void checkVoice () {
        String answer = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Это животное " + this.voice + "? Да - \"1\", нет - \"2\"");
        try {
            answer = reader.readLine();
        } catch (IOException e) {
            System.out.println("Неправильный ввод");
        }
        switch (answer) {
            case "1":
                System.out.println("Это " + this.name + "? Да - \"1\", нет - \"2\"");
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
                        int size = this.variantsYes.size();
                        int i = 0;
                        boolean foundNew = true;
                        while (i < size) {
                            System.out.println("Это " + this.variantsYes.get(i).name + "? Да - \"1\", нет - \"2\"");
                            try {
                                answer = reader.readLine();
                            } catch (IOException e) {
                                System.out.println("Неправильный ввод");
                            }
                            if (answer.equals("1")) {
                                System.out.println("Спасибо за игру !");
                                foundNew = false;
                                break;
                            } else {
                                if (answer.equals("2")) {
                                    i++;
                                } else {
                                    System.out.println("неверный ввод");
                                }
                            }
                        }
                        if (foundNew) addYes();
                    }
                }
            case "2":
                int size = this.variantsNo.size();
                int i = 0;
                boolean foundNew = true;
                while (i < size) {
                    System.out.println("Это животное" + this.variantsYes.get(i).voice + "? Да - \"1\", нет - \"2\"");
                    try {
                        answer = reader.readLine();
                    } catch (IOException e) {
                        System.out.println("Неправильный ввод");
                    }
                    if (answer.equals("1")) {
                        System.out.println("Это " + this.variantsYes.get(i).name + "? Да - \"1\", нет - \"2\"");
                        try {
                            answer = reader.readLine();
                        } catch (IOException e) {
                            System.out.println("Неправильный ввод");
                        }
                        if (answer.equals("1")) {
                            System.out.println("Спасибо за игру!");
                            foundNew = false;
                            break;
                        } else {
                            if (answer.equals("2")) {
                                addNo();
                            }
                        }
                    } else {
                        if (answer.equals("2")) {
                            i++;
                        } else {
                            System.out.println("неверный ввод");
                        }
                    }
                }
                if (foundNew) addNo();
            default:
                System.out.println("Неверный ввод!");
        }
    }
}


