/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.week3.softwarefundamentals.ice1;

import java.util.Random;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then searches the array of cards for the match to the hard-coded lucky card.
 * To be used as starting code in ICE 1
 * @author Kuldeep Singh
 * @modifier KuldeepSingh 991730896
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

        // Hard-coded lucky card
        Card luckyCard = new Card(2, "Spades");
        System.out.println("The lucky card is: " + luckyCard.getValue() + " of " + luckyCard.getSuit());

        // Check if the lucky card is in the magic hand
        boolean found = isCardInHand(magicHand, luckyCard.getValue(), luckyCard.getSuit());
        if (found) {
            System.out.println("Congratulations! The lucky card is in the magic hand. You win!");
        } else {
            System.out.println("Sorry! The lucky card is not in the magic hand. You lose.");
        }
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
