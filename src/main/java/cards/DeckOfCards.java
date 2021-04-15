package cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * This is the class for the Deck object.
 */
public class DeckOfCards
{

    /**
     * This Arraylist contains all the cards in the deck.
     */
    private List<PlayingCard> deck = new ArrayList<>();

    /**
     * This is the constructor for the class and it creates a deck of 52 individual cards and adds them to the ArrayList.
     */
    public DeckOfCards()
    {
        final char[] suits = { 'S', 'H', 'D', 'C' };
        for(int suit = 0; suit < 4;suit++)
        {
            for(int face = 1; face <= 13; face++)
            {
                deck.add(new PlayingCard(suits[suit],face));
            }
        }

        shuffle();
    }

    /**
     * This simple shuffle method shuffles the cards in the deck.
     */
    private void shuffle()
    {
        Collections.shuffle(deck);
    }

    /**
     * This method creats a hand of cards. The amount of cards can be changed but in this cardgame it is limited to 5.
     * @param cards
     * @return returns a HandOfCards object with the 5 cards picked out randomly from the deck using the Random class.
     */
    public HandOfCards dealHand(int cards)
    {
        boolean finished = false;
        ArrayList<PlayingCard> hand = new ArrayList<>();
        Random r = new Random();
        while(!finished)
        {
            hand.add(deck.get(r.nextInt(deck.size())));
            deck.removeAll(hand);

            if(hand.size() == cards)
            {
                finished = true;
            }
        }
        return new HandOfCards(hand);
    }

    /**
     * A simple method to get the deck ArrayList.
     * @return returns the deck arraylist.
     */
    public List<PlayingCard> getDeck()
    {
        return deck;
    }

}
