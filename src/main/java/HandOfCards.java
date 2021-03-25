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

    public String getHandString()
    {
        return " " + currentHand;
    }
}
