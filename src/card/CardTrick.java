/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

/**
 * BRANCH BY: SANTIAGO MEDINA
 *    ID:991627301
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author srinivsi
 */

import java.util.Random; //random library needed to generate cards
import java.util.Scanner; //To capture the user input

public class CardTrick {
    
    public static void main(String[] args)
    {
        Card[] magicHand = new Card[7];
        Random rand = new Random();
        for (int i=0; i<magicHand.length; i++)
        {
            Card c = new Card();
            //c.setValue(insert call to random number generator here)           
            c.setValue(rand.nextInt(13) +1); // It generates a random card value from 1 to 13
            //c.setSuit(Card.SUITS[insert call to random number between 0-3 here])
            c.setSuit(Card.SUITS[rand.nextInt(4)]); // random suits from SUITS array
            magicHand[i] = c;
            
            //Print cards according to the sample image provided by Professor:
            
            System.out.println("Card #" + (i + 1) + ": " + c.getSuit() + " " + c.getValue());
        

        }
        
        //insert code to ask the user for Card value and suit, create their card
        
        
        // Ask user for a card value
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter card value (1 to 13): ");
        int userValue = input.nextInt();
        // Validation of the card value input from the user
        if (userValue < 0 || userValue > 13) {
            System.out.println("Invalid card value. Please enter a number between 1 and 13.");
            return;
        }
        
        
        input.nextLine(); // spacer
        
        // Ask user for a card suit:

        System.out.print("Enter card suit (0-3 where 0=Hearts, 1=Diamonds, 2=Clubs, 3=Spades): ");
        int suitIndex = input.nextInt();
        
        
        // Validation of the suit index input from the user
        if (suitIndex < 0 || suitIndex > 3) {
            System.out.println("Invalid suit index. Please enter a number between 0 and 3.");
            return;
        }

        String userSuit = Card.SUITS[suitIndex];

        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(userSuit);
        
        // and search magicHand here
        
        boolean inMagicHand = false;
            for (Card card : magicHand) {
                if (card.getValue() == userCard.getValue() &&
                    card.getSuit().equalsIgnoreCase(userCard.getSuit())) {
                        inMagicHand = true;
                    break;
                }
        }
        //Then report the result here
        
        if (inMagicHand) {
            System.out.println("\nYour card is in the magic hand!");
        } else {
            System.out.println("\nYour card is NOT in the magic hand.");
        }

        // add one luckcard hard code 2,clubs
        
        Card luckyCard = new Card();
        luckyCard.setValue(2);
        luckyCard.setSuit("Clubs");
        System.out.println("Lucky card is: " + luckyCard.getSuit() + " " + luckyCard.getValue());
    }
    
}
