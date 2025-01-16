package application;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BudgetController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button logoutBtn;

    @FXML
    private Label dateDisplay;

    @FXML
    private TextField setBudget;

    @FXML
    private Label successMsg;

    @FXML
    private Button startShoppingBtn;

    // datDisplay method to display current date
    @FXML
    public void initialize() {
        // Get the current date
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");
        dateDisplay.setText(currentDate.format(formatter));
    }

    @FXML
    public void setBudget(ActionEvent e) {
        String budgetValueStr = setBudget.getText();
        try {
            // Accept input as a double value
            double budgetValue = Double.parseDouble(budgetValueStr);
            successMsg.setText("Congratulations!!! Budget is set to $" + budgetValue);
            successMsg.setStyle("-fx-text-fill: green;");
            startShoppingBtn.setVisible(true);
            successMsg.setVisible(true);
        } catch (NumberFormatException ex) {
            successMsg.setText("Please enter a valid budget amount.");
            successMsg.setStyle("-fx-text-fill: red;");
            startShoppingBtn.setVisible(false);
            successMsg.setVisible(true);
        }
    }

    @FXML
    public void startShopping(ActionEvent e) throws IOException {
        // change scene to Main screen
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
        Parent root = loader.load();
        SceneController sceneController = loader.getController();

        // Pass the budget value as double
        double budgetValue = Double.parseDouble(setBudget.getText());
        sceneController.setBudgetValue(budgetValue);

        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // method to logout and change scene
    @FXML
    public void logout(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
