package cards;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class represents the hand.
 */
public class HandOfCards
{
    /**
     * This arraylist contains the currentHand of cards.
     */
    private ArrayList<PlayingCard> currentHand;

    /**
     * This is the constructor for the Hand, it takes in a List of cards from the dealHand method and puts these into the official hand.
     * @param handsToAdd cards to be added to the current hand.
     */
    public HandOfCards(ArrayList<PlayingCard> handsToAdd)
    {
        currentHand = new ArrayList<PlayingCard>();
        currentHand.addAll(handsToAdd);
    }

    /**
     * This method returns the currentHand list.
     * @return
     */
    public ArrayList<PlayingCard> getCurrentHand()
    {
        return currentHand;
    }

    /**
     * This method uses streams to check if the current hand has a flush and returns true if it has. Otherwise it returns false.
     * @return
     */
    public boolean checkForFlush()
    {
        if (currentHand.stream().filter(card -> card.getSuit() == 'S').count() >= 5 ||
                currentHand.stream().filter(card -> card.getSuit() == 'H').count() >= 5 ||
                currentHand.stream().filter(card -> card.getSuit() == 'C').count() >= 5 ||
                currentHand.stream().filter(card -> card.getSuit() == 'D').count() >= 5)
        {
            return true;
        } else {return false;}

    }

    /**
     * This methods collects all the heart cards on the hand and return them as a list.
     * @return
     */
    public List<PlayingCard> amountOfHearts()
    {

        return currentHand.stream().filter(card -> card.getSuit() == 'H').collect(Collectors.toList());

    }

    /**
     * This method is used by the main controller to create a string from the list returned by the amountOfHearts method so that this can be displayed in a textfield in the GUI.
     * @param cardsToCheck
     * @return
     */
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

    /**
     * This method calculated the total sum of the faces on the current hand and returns the result as an integer.
     * @return
     */
    public int calculateSumOfFaces()
    {

        return currentHand.stream().map(card -> card.getFace()).reduce(0, (x, y) -> x + y);
    }

    /**
     * This method checks if the current hand has a queen of spades (12S) and returns true if there is a match.
     * @return
     */
    public boolean hasQueenOfSpades()
    {
        return currentHand.stream().anyMatch(card -> card.getAsString().equalsIgnoreCase("12S"));
    }
}
