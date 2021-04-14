import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.*;

public class MainController implements Initializable
{
    private DeckOfCards deckOfCards;
    private javafx.scene.image.Image backImage;
    private HandOfCards hand;

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
    private TextField sumOfFacesTextField;
    @FXML
    private TextField cardsOfHeartsTextField;
    @FXML
    private TextField hasQueenOfSpadesTextField;
    @FXML
    private TextField isFlushTextField;


    public Image getBackImage()
    {
        return backImage;
    }

    public void setBackImage()
    {
        cardPicture1.setImage(new javafx.scene.image.Image("/Cards_png/back.PNG"));
        cardPicture2.setImage(new javafx.scene.image.Image("/Cards_png/back.PNG"));
        cardPicture3.setImage(new javafx.scene.image.Image("/Cards_png/back.PNG"));
        cardPicture4.setImage(new javafx.scene.image.Image("/Cards_png/back.PNG"));
        cardPicture5.setImage(new javafx.scene.image.Image("/Cards_png/back.PNG"));
    }


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
        }
        catch (IllegalArgumentException iae)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("The deck is empty! Press restart to start over with a fresh deck!");
            alert.show();
        }
    }

    @FXML
    public Image setCardPicture(PlayingCard card)
    {
        Image image = null;

            String fileName = card.getAsString() + ".PNG";
            image = new Image("/Cards_png/" + fileName);

        return image;
    }

    @FXML
    public void restartGame()
    {
        initialize2();
    }

    @FXML
    public void initialize2()
    {
        this.deckOfCards = new DeckOfCards();
        setBackImage();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        this.deckOfCards = new DeckOfCards();
        setBackImage();
    }
}
