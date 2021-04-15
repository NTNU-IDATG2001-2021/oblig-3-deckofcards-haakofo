import cards.DeckOfCards;
import cards.HandOfCards;
import cards.PlayingCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test class for the project.
 */
public class CardGame_test
{
    /**
     * private fields for a Deck, a hand and an Arraylist containing all the testing cards.
     */
    private DeckOfCards d1;
    private HandOfCards h1;
    private ArrayList<PlayingCard> testingCards = new ArrayList<>();

    /**
     * Setup that creates a deck and a hand filled with 5 different cards.
     */
    @BeforeEach
    void setUp()
    {
        d1 = new DeckOfCards();
        PlayingCard p1 = new PlayingCard('C',11);
        PlayingCard p2 = new PlayingCard('C',1);
        PlayingCard p3 = new PlayingCard('H',5);
        PlayingCard p4 = new PlayingCard('S',7);
        PlayingCard p5 = new PlayingCard('S',12);
        testingCards.add(p1);
        testingCards.add(p2);
        testingCards.add(p3);
        testingCards.add(p4);
        testingCards.add(p5);
        h1 = new HandOfCards(testingCards);
    }

    /**
     * Flush rarely happen, so this test is here to make sure that the check flush method actually works if there is a flush.
     */
    @Test
    void testFlush()
    {
        DeckOfCards d2 = new DeckOfCards();
        ArrayList<PlayingCard> flush = new ArrayList<>();

        PlayingCard p11 = new PlayingCard('C',11);
        PlayingCard p22 = new PlayingCard('C',1);
        PlayingCard p33 = new PlayingCard('C',5);
        PlayingCard p44 = new PlayingCard('C',7);
        PlayingCard p55 = new PlayingCard('C',12);

        flush.add(p11);
        flush.add(p22);
        flush.add(p33);
        flush.add(p44);
        flush.add(p55);

        HandOfCards h2 = new HandOfCards(flush);
        assertTrue(h2.checkForFlush());
    }

    /**
     * Tests that the hand actually has the amount of cards given to it.
     */
    @Test
    void checkHand()
    {
        assertEquals(5,h1.getCurrentHand().size());
    }

    /**
     * Checks that the calculated sum of faces is correct.
     */
    @Test
    void calculateFaces()
    {
        assertEquals(36,h1.calculateSumOfFaces());
    }

    /**
     * Checks that the flush method is working properly.
     */
    @Test
    void isFlush()
    {
        assertFalse(h1.checkForFlush());
    }

    /**
     * Checks that the amountOfHearts method returns the correct amount of hearts.
     */
    @Test
    void countHearts()
    {
        assertEquals(1, h1.amountOfHearts().size());
    }

    /**
     * Checks that the spadeCheck method works.
     */
    @Test
    void spadeQueenCheck()
    {
        assertTrue(h1.hasQueenOfSpades());
    }
}
