import java.util.Random;

public class DeckOfCards {
    public static void main(String[] args) {
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] deck = new String[52];

        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[i * ranks.length + j] = ranks[j] + " of " + suits[i];
            }
        }

        Random random = new Random();
        for (int i = 0; i < deck.length; i++) {
            int index = random.nextInt(52);
            String temp = deck[i];
            deck[i] = deck[index];
            deck[index] = temp;
        }

        String[][] players = new String[4][9];
        int cardIndex = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 9; j++) {
                players[i][j] = deck[cardIndex++];
            }
        }

        System.out.println("Cards received by 4 players:");
        for (int i = 0; i < players.length; i++) {
            for (int j = 0; j < players[i].length; j++) {
                System.out.print(players[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
