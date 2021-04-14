import java.util.*;

public class DeckOfCards
{

    private List<PlayingCard> deck = new ArrayList<>();
    private List<PlayingCard> hand;

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
        Random r = new Random();
        hand = new ArrayList<PlayingCard>();
        while(!finished)
        {
            hand.add(deck.get(r.nextInt(deck.size())));
            deck.removeAll(hand);

            if(hand.size() == cards)
            {
                finished = true;
            }
        }
        return new HandOfCards();
    }

    public List<PlayingCard> getDeck()
    {
        return deck;
    }

    public void returnCardsToDeck()
    {
        if(deck.size() != 52)
        {
            deck.addAll(hand);
            hand.removeAll(hand);
        }
    }

}
