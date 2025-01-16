package application;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Thankyou_controller {
	@FXML
	private Button back;
	public void back_to_home(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Stage stage=(Stage)((Node)e.getSource()).getScene().getWindow();
	    Scene scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}

}
