/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.week3.softwarefundamentals.ice1;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author Kuldeep Singh
 * @modifier KuldeepSingh
 * 
 * 
 */
public class CardTrick {
    
  public static void main(String[] args) {
        Card[] magicHand = new Card[7];
        Random random1 = new Random(); // creating a random instance

        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(random1.nextInt(13) + 1);
            c.setSuit(Card.SUITS[random1.nextInt(4)]);
            magicHand[i] = c;
        }

        System.out.println("Magic Hand:");
        for (Card card : magicHand) {
            System.out.println(card);
        }

      Card luckyCard = new Card(1, "Spades");
        System.out.println("The lucky card is: " + luckyCard.getValue() + " of " + luckyCard.getSuit());

        int userValue;
        String userSuit;
      try (Scanner scanner = new Scanner(System.in)) {
          System.out.print("Pick a card value between 1 and 13: ");
          userValue = scanner.nextInt();
          scanner.nextLine();
          System.out.print("Pick a suit (Hearts, Diamonds, Spades, Clubs): ");
          userSuit = scanner.nextLine();
      }

        boolean found = isCardInHand(magicHand, userValue, userSuit);
        if (found) {
            System.out.println("The card is in the magic hand!");
        } else {
            System.out.println("The card is not in the magic hand.");
        }
     
        if (userValue == luckyCard.getValue() && userSuit.equalsIgnoreCase(luckyCard.getSuit())) {
            System.out.println("Wow! You picked the lucky card!");
  }

        public static boolean isCardInHand(Card[] hand, int value, String suit) {
        for (Card card : hand) {
            if (card.getValue() == value && card.getSuit().equalsIgnoreCase(suit)) {
                return true;
            }
        }
        return false;
    }
}
