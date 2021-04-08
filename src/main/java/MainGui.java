import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class MainGui extends Application
{

    public void buildLayout()
    {

    }

    public void start(Stage s1) throws Exception
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("structure.fxml")));
        s1.setTitle("CardGame");
        s1.setScene(new Scene(root, 300, 275));
        s1.show();
    }


}
