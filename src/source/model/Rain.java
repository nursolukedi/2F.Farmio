package src.source.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Rain implements java.io.Serializable
{
    private Random rain;
    LocalDate today;
    int month;
    public Rain(){
        today= LocalDate.now();
        month = today.getMonthValue();
        rain = new Random();
    }


    public void raining(ArrayList<Tree> trees)
    {
        today= LocalDate.now();
        month = today.getMonthValue();

        int probablity = 0;
        if(month>2 && month<7){
            probablity+=8;
        }
        else if(month>8 && month<12){
            probablity+=10;
        }
        else if(month <3 && month >11){
            probablity +=5;
        }
        else{
            probablity +=2;
        }

        int random = rain.nextInt(30);

        probablity+=random;
     //   System.out.println("RANDOM   "+ random +"  PROBABLITY" + probablity + "^^^^^^^^^^");
        if(probablity>21){
            for(int c=0; c<trees.size(); c++)
                trees.get(c).water();
        }

    }
}