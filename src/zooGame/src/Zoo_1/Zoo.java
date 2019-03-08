package game1;

import java.util.ArrayList;

public class Zoo {
    String name;
    Zoo next;
    String voice;
    ArrayList variantsNo;
    ArrayList variantsYes;

    public void InString (){
        System.out.println(this.name + " " + this.voice);
    }

}
