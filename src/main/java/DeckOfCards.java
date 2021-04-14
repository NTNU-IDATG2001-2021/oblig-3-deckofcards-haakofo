import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DeckOfCards
{

    private List<PlayingCard> deck = new ArrayList<>();

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

    private void shuffle()
    {
        Collections.shuffle(deck);
    }

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

    public List<PlayingCard> getDeck()
    {
        return deck;
    }

}
