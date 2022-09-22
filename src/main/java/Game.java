import java.util.*;
class Game{
    static final int size = 52;
    static Card[] deckOfCards = new Card[size];

    public static void main(String[] args) {
        //USE COLLECTIONS OF SHUFFLE
        init();
        Collections.shuffle(Arrays.asList(deckOfCards));
        int count=1;
        for(Card card:deckOfCards){
            System.out.println(count+"."+card.rank+" "+card.suit);
            count++;
        }

        //USE CUSTOM FUNCTION TO SHUFFLE CARDS
//        init();
//        count=1;
//        for(Card card:shuffleCards()){
//            System.out.println(count+"."+card.rank+" "+card.suit);
//            count++;
//        }
    }

    private static Card[] init() {
        int count=0;
        String[] suits= {"Speads", "Hearts", "Diamonds", "Clubs"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        for (String s:suits){
            for (String r:ranks){
                Card card = new Card(s, r);
                deckOfCards[count] = card;
                count++;
            }
        }

        return deckOfCards;
    }

    private static Card[] shuffleCards() {
        Random random=new Random();
        int j;
        for (int i=0; i<size;i++ ) {
            j=random.nextInt(52);
            Card temp=deckOfCards[j];
            deckOfCards[i]=deckOfCards[j];
            deckOfCards[j]=temp;
        }
        return deckOfCards;
    }

    private static class Card {
        String suit;
        String rank;
        public Card(String cardSuit, String cardRank){
            this.suit = cardSuit;
            this.rank = cardRank;
        }
    }
}