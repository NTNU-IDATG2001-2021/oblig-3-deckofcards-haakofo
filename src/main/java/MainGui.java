public class MainGui
{
    public static void main(String[] args)
    {
        DeckOfCards d1 = new DeckOfCards();
        System.out.println(d1.getDeck().size());
        HandOfCards h1 = new HandOfCards(5,d1);
        h1.printHand();
        System.out.println("Nymber of cards at hand: " + h1.getCurrentHand().size());
        System.out.println(d1.getDeck().size());
        d1.returnCardsToDeck();
        System.out.println(d1.getDeck().size());
        System.out.println(h1.getCurrentHand().size());
    }
}
