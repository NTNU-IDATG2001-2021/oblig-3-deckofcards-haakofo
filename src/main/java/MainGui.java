public class MainGui
{
    public static void main(String[] args)
    {
        DeckOfCards d1 = new DeckOfCards();
        HandOfCards h1 = new HandOfCards(5,d1);
        h1.printHand();
    }
}
