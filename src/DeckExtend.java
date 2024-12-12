import java.util.Random;

class Card{
    String rank;
    String suit;

    public Card(String rank, String suit){
        this.rank = rank;
        this.suit = suit;
    }

    public int getRankValue(){
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        for(int i=0;i<ranks.length;i++){
            if(ranks[i].equals(this.rank)) return i;
        }
        return -1;
    }

    @Override
    public String toString(){
        return rank + " of " + suit;
    }
}

class Player{
    Card[] cards;

    public Player(Card[] cards) {
        this.cards = cards;
        sortCards();
    }

    private void sortCards() {
        for (int i = 0; i < cards.length - 1; i++) {
            for (int j = i + 1; j < cards.length; j++) {
                if (cards[i].getRankValue() > cards[j].getRankValue()) {
                    Card temp = cards[i];
                    cards[i] = cards[j];
                    cards[j] = temp;
                }
            }
        }
    }

    public void printCards() {
        for (Card card : cards) {
            System.out.println(card);
        }
    }
}

public class DeckExtend{
    public static void main(String[] args) {
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        Card[] deck = new Card[52];
        int index = 0;

        for(String suit : suits){
            for(String rank : ranks){
                deck[index++]=new Card(rank, suit);
            }
        }

        Random random = new Random();
        for(int i=0;i<deck.length;i++){
            int randomIndex=random.nextInt(52);
            Card temp=deck[i];
            deck[i]=deck[randomIndex];
            deck[randomIndex]=temp;
        }

        Player[] players=new Player[4];
        index=0;
        for(int i=0;i<4;i++){
            Card[] hand=new Card[9];
            System.arraycopy(deck, index, hand, 0, 9);
            players[i]=new Player(hand);
            index+=9;
        }

        for (int i = 0; i < players.length; i++) {
            System.out.println("Player " + (i + 1) + ":");
            players[i].printCards();
            System.out.println();
        }

    }
}