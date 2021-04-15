import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The main class for the Cardgame. This class starts up the whole program with its GUI.
 */
public class MainGui extends Application
{

    /**
     * The main method.
     * @param args launches the application.
     */
    public static void main(String[] args)
    {
        launch(args);
    }

    /**
     * This is the start method for the GUI
     * @param stage sets the stage for the GUI.
     * @throws Exception throws an Exception.
     */
    public void start(Stage stage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("structure.fxml"));
        stage.setTitle("CardGame");
        stage.setScene(new Scene(root, 700, 500));
        stage.show();
    }

}



