package tribalway.cardcounter.com.cardcounter;

public class Shoe {


    int cards;


    public  Shoe(int decks) {

        switch (decks) {
            case 1:
                cards = 52;
                break;


            case 2:
                cards = 104;
                break;


            case 4:
                cards = 208;
                break;


            case 6:
                cards = 312;
                break;


            case 8:
                cards = 416;
                break;

        }


    }
}