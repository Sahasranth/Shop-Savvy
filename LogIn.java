package application;

import java.io.FileReader;
import java.nio.file.*;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import java.io.File;

public class LogIn {

    @FXML
    private TextField usrname;
    @FXML
    private TextField pswd;
    @FXML
    private Button btn_login;
    @FXML
    private ImageView img_login;

    @FXML
    private Label errorMsg;

    @FXML
    public void login(ActionEvent e) {

        // clear error message
        errorMsg.setText(" ");
        errorMsg.setVisible(false);

        String username = usrname.getText(), password = pswd.getText();
        JSONParser jsonParser = new JSONParser();
        Object jsonObject;
        Path path = (Paths.get("login.json"));
        try {
            jsonObject = jsonParser.parse(new FileReader(path.toString()));
            JSONObject json = (JSONObject) jsonObject;
            if (json.containsKey(username)) {
                if (((String) json.get(username)).equals(password)) {
                    Parent root = FXMLLoader.load(getClass().getResource("Budget.fxml"));
                    Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } else {
                    errorMsg.setText("Incorrect Username/Password");
                    errorMsg.setVisible(true);
                    usrname.clear();
                    pswd.clear();

                }
            } else {
                errorMsg.setText("User not found. Please re-enter or register.");
                errorMsg.setVisible(true);
                usrname.clear();
                pswd.clear();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    public void register(ActionEvent e) throws IOException {
        /* change scene to register_screen */
        Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
