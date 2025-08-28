package Level3;

import java.util.Scanner;

public class DeckOfCards {

    // Suits and Ranks
    static String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    static String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", 
                             "Jack", "Queen", "King", "Ace"};

    // Initialize the deck
    public static String[] initializeDeck() {
        int numOfCards = suits.length * ranks.length; // 52
        String[] deck = new String[numOfCards];
        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    // Shuffle the deck
    public static void shuffleDeck(String[] deck) {
        for (int i = 0; i < deck.length; i++) {
            int randomCardNumber = i + (int)(Math.random() * (deck.length - i));
            // Swap
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
    }

    // Distribute cards to players
    public static String[][] distributeCards(String[] deck, int n, int x) {
        if (n * x > deck.length) {
            System.out.println("Not enough cards to distribute!");
            return null;
        }

        String[][] players = new String[x][n];
        int index = 0;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < n; j++) {
                players[i][j] = deck[index++];
            }
        }
        return players;
    }

    // Print players and their cards
    public static void printPlayers(String[][] players) {
        if (players == null) return;

        for (int i = 0; i < players.length; i++) {
            System.out.println("\nPlayer " + (i + 1) + " cards:");
            for (int j = 0; j < players[i].length; j++) {
                System.out.println("  " + players[i][j]);
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Initialize deck
        String[] deck = initializeDeck();

        // Step 2: Shuffle deck
        shuffleDeck(deck);

        // Input
        System.out.print("Enter number of players: ");
        int players = sc.nextInt();

        System.out.print("Enter number of cards per player: ");
        int cardsPerPlayer = sc.nextInt();

        // Step 3: Distribute
        String[][] distributed = distributeCards(deck, cardsPerPlayer, players);

        // Step 4: Print
        printPlayers(distributed);

        sc.close();
    }
}

