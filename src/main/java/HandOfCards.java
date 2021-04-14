import java.util.ArrayList;

public class HandOfCards
{
    private ArrayList<PlayingCard> currentHand;

    public HandOfCards()
    {
        currentHand = new ArrayList<PlayingCard>();
    }

    public void printHand()
    {
        for (PlayingCard card : currentHand)
        {
            System.out.println(card.getAsString());
        }
    }

    public ArrayList<PlayingCard> getCurrentHand()
    {
        return currentHand;
    }

}
