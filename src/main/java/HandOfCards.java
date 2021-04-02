import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HandOfCards
{
    private Set<PlayingCard> currentHand;

    public HandOfCards(int cards, DeckOfCards cardDeck)
    {
        currentHand = cardDeck.dealHand(cards);
    }

    public void printHand()
    {
        for (PlayingCard card : currentHand)
        {
            System.out.println(card.getAsString());
        }
    }

    public Set<PlayingCard> getCurrentHand()
    {
        return currentHand;
    }

}
