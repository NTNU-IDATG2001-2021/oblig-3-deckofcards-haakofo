import cards.DeckOfCards;
import cards.HandOfCards;
import cards.PlayingCard;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * The controller used to connect the FXML to the rest of the code.
 */
public class MainController implements Initializable
{
    /**
     * Declares a Deck, a javafx image and a hand.
     */
    private DeckOfCards deckOfCards;
    private javafx.scene.image.Image backImage;
    private HandOfCards hand;

    /**
     * All the imageview variables. These hold the images seen in the GUI.
     */
    @FXML
    private ImageView cardPicture1;
    @FXML
    private ImageView cardPicture2;
    @FXML
    private ImageView cardPicture3;
    @FXML
    private ImageView cardPicture4;
    @FXML
    private ImageView cardPicture5;
    @FXML
    private ImageView logo;

    /**
     * The text area variables for the GUI, these hold the text result from the different methods in the HandOfCards class.
     */
    @FXML
    private TextArea sumOfFacesTextField;
    @FXML
    private TextArea cardsOfHeartsTextField;
    @FXML
    private TextArea hasQueenOfSpadesTextField;
    @FXML
    private TextArea isFlushTextField;

    /**
     * This methods sets the back image of the cards when the game is restarted or at startup.
     */
    @FXML
    public void setBackImage()
    {
        cardPicture1.setImage(new javafx.scene.image.Image("/Cards_png/back.PNG"));
        cardPicture2.setImage(new javafx.scene.image.Image("/Cards_png/back.PNG"));
        cardPicture3.setImage(new javafx.scene.image.Image("/Cards_png/back.PNG"));
        cardPicture4.setImage(new javafx.scene.image.Image("/Cards_png/back.PNG"));
        cardPicture5.setImage(new javafx.scene.image.Image("/Cards_png/back.PNG"));
    }

    /**
     * This method takes 5 cards from the deck and puts them onto the users hand, then the imageviews are updated along with the cards.
     * If there is no more cards in the deck, and Error box will display a message.
     */
    @FXML
    public void buttonDealHand()
    {
        try
        {
            hand = deckOfCards.dealHand(5);

            this.cardPicture1.setImage(setCardPicture(hand.getCurrentHand().get(0)));
            this.cardPicture2.setImage(setCardPicture(hand.getCurrentHand().get(1)));
            this.cardPicture3.setImage(setCardPicture(hand.getCurrentHand().get(2)));
            this.cardPicture4.setImage(setCardPicture(hand.getCurrentHand().get(3)));
            this.cardPicture5.setImage(setCardPicture(hand.getCurrentHand().get(4)));

            sumOfFacesTextField.setText(String.valueOf(hand.calculateSumOfFaces()));

            cardsOfHeartsTextField.setText(hand.amountOfHearts().size() > 0 ? hand.formStringOfHearts(hand.amountOfHearts()) : "No hearts.");

            isFlushTextField.setText(hand.checkForFlush() ? "Yes" : "No");

            hasQueenOfSpadesTextField.setText(hand.hasQueenOfSpades() ? "Yes" : "No");

        }
        catch (IllegalArgumentException iae)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("The deck is empty! Press restart to start over with a fresh deck!");
            alert.show();
        }
    }

    /**
     * This method find the correct path for the individual cards and returns the correct Image.
     * @param card the method takes in one Playingcard object.
     * @return Returns an image.
     */
    @FXML
    public Image setCardPicture(PlayingCard card)
    {
        String fileName = "/Cards_png/" + card.getAsString() + ".png";

        return new Image(getClass().getResourceAsStream(fileName));
    }

    /**
     * This method restarts the game, and is used when the user presses the "Restart Game" button.
     */
    @FXML
    public void restartGame()
    {
        isFlushTextField.clear();
        sumOfFacesTextField.clear();
        hasQueenOfSpadesTextField.clear();
        cardsOfHeartsTextField.clear();

        this.deckOfCards = new DeckOfCards();
        setBackImage();
    }

    /**
     * This is the inherited initialize method, it runs when the program starts.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        this.deckOfCards = new DeckOfCards();
        logo.setImage(new Image("/Other_png/logo.jpg"));
        setBackImage();
    }
}
