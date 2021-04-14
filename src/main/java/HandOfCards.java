import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HandOfCards
{
    private ArrayList<PlayingCard> currentHand;

    public HandOfCards(ArrayList<PlayingCard> handsToAdd)
    {
        currentHand = new ArrayList<PlayingCard>();
        currentHand.addAll(handsToAdd);
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

    public boolean checkForFlush()
    {
        if (currentHand.stream().filter(card -> card.getSuit() == 'S').count() >= 5 ||
                currentHand.stream().filter(card -> card.getSuit() == 'H').count() >= 5 ||
                currentHand.stream().filter(card -> card.getSuit() == 'C').count() >= 5 ||
                currentHand.stream().filter(card -> card.getSuit() == 'D').count() >= 5)
        {
            return true;
        } else
            return false;
    }

    public List<PlayingCard> amountOfHearts()
    {

        return currentHand.stream().filter(card -> card.getSuit() == 'H').collect(Collectors.toList());

    }

    public String formStringOfHearts(List<PlayingCard> cardsToCheck)
    {
        if (cardsToCheck.isEmpty())
        {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();

        if (cardsToCheck.size() > 0)
        {
            for (PlayingCard playingCard : cardsToCheck)
            {
                stringBuilder.append(playingCard.getAsString()).append(" ");
            }
        }
        else
            stringBuilder.append("No hearts in sight!");

        return stringBuilder.toString();
    }

    public int calculateSumOfFaces()
    {

        return currentHand.stream().map(card -> card.getFace()).reduce(0, (x, y) -> x + y);
    }

    public boolean hasQueenOfSpades()
    {
        return currentHand.stream().anyMatch(card -> card.getAsString().equalsIgnoreCase("12S"));
    }
}
