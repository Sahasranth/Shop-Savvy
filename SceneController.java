package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SceneController {
	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	private TextField budgetValue;

	@FXML
	private Button logoutBtn;

	@FXML
	private TextField Srch;
	String searchStr;
	static List<Product> searchList;

	List<Button> addButton = new ArrayList<Button>();
	List<TextField> count = new ArrayList<TextField>();
	List<Button> subButton = new ArrayList<Button>();
	List<Text> prodName = new ArrayList<Text>();

	@FXML
	private Text prod0;
	@FXML
	private Text prod1;
	@FXML
	private Text prod2;
	@FXML
	private Text prod3;
	@FXML
	private Text prod4;
	@FXML
	private Text prod5;
	@FXML
	private Text prod6;
	@FXML
	private Text prod7;
	@FXML
	private Text prod8;
	@FXML
	private Text prod9;
	@FXML
	private Text prod10;
	@FXML
	private Text prod11;
	@FXML
	private Text prod12;
	@FXML
	private Text prod13;
	@FXML
	private Text prod14;
	@FXML
	private Text prod15;
	@FXML
	private Text prod16;
	@FXML
	private Text prod17;
	@FXML
	private Text prod18;
	@FXML
	private Text prod19;
	@FXML
	private Text prod20;
	@FXML
	private Text prod21;
	@FXML
	private Text prod22;
	@FXML
	private Text prod23;
	@FXML
	private Text prod24;
	@FXML
	private Text prod25;
	@FXML
	private Text prod26;
	@FXML
	private Text prod27;
	@FXML
	private Text prod28;
	@FXML
	private Text prod29;
	@FXML
	private Text prod30;
	@FXML
	private Text prod31;

	@FXML
	private Button Button0;
	@FXML
	private Button Button1;
	@FXML
	private Button Button2;
	@FXML
	private Button Button3;
	@FXML
	private Button Button4;
	@FXML
	private Button Button5;
	@FXML
	private Button Button6;
	@FXML
	private Button Button7;
	@FXML
	private Button Button8;
	@FXML
	private Button Button9;
	@FXML
	private Button Button10;
	@FXML
	private Button Button11;
	@FXML
	private Button Button12;
	@FXML
	private Button Button13;
	@FXML
	private Button Button14;
	@FXML
	private Button Button15;
	@FXML
	private Button Button16;
	@FXML
	private Button Button17;
	@FXML
	private Button Button18;
	@FXML
	private Button Button19;
	@FXML
	private Button Button20;
	@FXML
	private Button Button21;
	@FXML
	private Button Button22;
	@FXML
	private Button Button23;
	@FXML
	private Button Button24;
	@FXML
	private Button Button25;
	@FXML
	private Button Button26;
	@FXML
	private Button Button27;
	@FXML
	private Button Button28;
	@FXML
	private Button Button29;
	@FXML
	private Button Button30;
	@FXML
	private Button Button31;

	@FXML
	private Button btn0;
	@FXML
	private Button btn1;
	@FXML
	private Button btn2;
	@FXML
	private Button btn3;
	@FXML
	private Button btn4;
	@FXML
	private Button btn5;
	@FXML
	private Button btn6;
	@FXML
	private Button btn7;
	@FXML
	private Button btn8;
	@FXML
	private Button btn9;
	@FXML
	private Button btn10;
	@FXML
	private Button btn11;
	@FXML
	private Button btn12;
	@FXML
	private Button btn13;
	@FXML
	private Button btn14;
	@FXML
	private Button btn15;
	@FXML
	private Button btn16;
	@FXML
	private Button btn17;
	@FXML
	private Button btn18;
	@FXML
	private Button btn19;
	@FXML
	private Button btn20;
	@FXML
	private Button btn21;
	@FXML
	private Button btn22;
	@FXML
	private Button btn23;
	@FXML
	private Button btn24;
	@FXML
	private Button btn25;
	@FXML
	private Button btn26;
	@FXML
	private Button btn27;
	@FXML
	private Button btn28;
	@FXML
	private Button btn29;
	@FXML
	private Button btn30;
	@FXML
	private Button btn31;

	@FXML
	private TextField count0;
	@FXML
	private TextField count1;
	@FXML
	private TextField count2;
	@FXML
	private TextField count3;
	@FXML
	private TextField count4;
	@FXML
	private TextField count5;
	@FXML
	private TextField count6;
	@FXML
	private TextField count7;
	@FXML
	private TextField count8;
	@FXML
	private TextField count9;
	@FXML
	private TextField count10;
	@FXML
	private TextField count11;
	@FXML
	private TextField count12;
	@FXML
	private TextField count13;
	@FXML
	private TextField count14;
	@FXML
	private TextField count15;
	@FXML
	private TextField count16;
	@FXML
	private TextField count17;
	@FXML
	private TextField count18;
	@FXML
	private TextField count19;
	@FXML
	private TextField count20;
	@FXML
	private TextField count21;
	@FXML
	private TextField count22;
	@FXML
	private TextField count23;
	@FXML
	private TextField count24;
	@FXML
	private TextField count25;
	@FXML
	private TextField count26;
	@FXML
	private TextField count27;
	@FXML
	private TextField count28;
	@FXML
	private TextField count29;
	@FXML
	private TextField count30;
	@FXML
	private TextField count31;

	public void switchToScene2(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("search.fxml")); // Create the loader with FXML location
		Parent root = loader.load();

		// Get the controller of the new scene and pass the search results to it
		SceneController2 sceneController2 = loader.getController();
		sceneController2.setSearchList(searchList);
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void switchToCheckout(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("checkout.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public String searchField() {
		searchStr = Srch.getText();
		return searchStr;
	}

	public void matchResults(ActionEvent event) throws IOException {
		this.searchList = ReadingJson.searchStr(ReadingJson.ReadingJson(), searchField());
		System.out.println("seach list size " + this.searchList.size());
		switchToScene2(event);
	}

	public List<Product> getSearchList() {
		return this.searchList;
	}

	public void setup() {
		prodName.add(prod0);
		System.out.println("kaushik " + prod0);
		System.out.println("kaushik dfuu " + prod0.getText());

		prodName.add(prod1);
		System.out.println("kaushik " + prod1);
		System.out.println("kaushik dfuu " + prod1.getText());

		prodName.add(prod2);
		System.out.println("kaushik " + prod2);
		System.out.println("kaushik dfuu " + prod2.getText());

		prodName.add(prod3);
		System.out.println("kaushik " + prod3);
		System.out.println("kaushik dfuu " + prod3.getText());

		prodName.add(prod4);
		System.out.println("kaushik " + prod4);
		System.out.println("kaushik dfuu " + prod4.getText());

		prodName.add(prod5);
		System.out.println("kaushik " + prod5);
		System.out.println("kaushik dfuu " + prod5.getText());

		prodName.add(prod6);
		System.out.println("kaushik " + prod6);
		System.out.println("kaushik dfuu " + prod6.getText());

		prodName.add(prod7);
		System.out.println("kaushik " + prod7);
		System.out.println("kaushik dfuu " + prod7.getText());

		prodName.add(prod8);
		System.out.println("kaushik " + prod8);
		System.out.println("kaushik dfuu " + prod8.getText());

		prodName.add(prod9);
		System.out.println("kaushik " + prod9);
		System.out.println("kaushik dfuu " + prod9.getText());

		prodName.add(prod10);
		System.out.println("kaushik " + prod10);
		System.out.println("kaushik dfuu " + prod10.getText());

		prodName.add(prod11);
		System.out.println("kaushik " + prod11);
		System.out.println("kaushik dfuu " + prod11.getText());

		prodName.add(prod12);
		prodName.add(prod13);
		prodName.add(prod14);
		prodName.add(prod15);
		prodName.add(prod16);
		prodName.add(prod17);
		prodName.add(prod18);
		prodName.add(prod19);
		prodName.add(prod20);
		prodName.add(prod21);
		prodName.add(prod22);
		prodName.add(prod23);
		prodName.add(prod24);
		prodName.add(prod25);
		System.out.println("kaushik " + prod25);
		System.out.println("kaushik dfuu " + prod25.getText());

		prodName.add(prod26);
		System.out.println("kaushik " + prod26);
		System.out.println("kaushik dfuu " + prod26.getText());

		prodName.add(prod27);
		System.out.println("kaushik " + prod27);
		System.out.println("kaushik dfuu " + prod27.getText());

		prodName.add(prod28);
		System.out.println("kaushik " + prod28);
		System.out.println("kaushik dfuu " + prod28.getText());

		prodName.add(prod29);
		System.out.println("kaushik " + prod29);
		System.out.println("kaushik dfuu " + prod29.getText());

		prodName.add(prod30);
		System.out.println("kaushik " + prod29);
		System.out.println("kaushik dfuu " + prod29.getText());

		prodName.add(prod31);
		System.out.println("kaushik " + prod29);
		System.out.println("kaushik dfuu " + prod29.getText());

		count.add(count0);
		count.add(count1);
		count.add(count2);
		count.add(count3);
		count.add(count4);
		count.add(count5);
		count.add(count6);
		count.add(count7);
		count.add(count8);
		count.add(count9);
		count.add(count10);
		count.add(count11);
		count.add(count12);
		count.add(count13);
		count.add(count14);
		count.add(count15);
		count.add(count16);
		count.add(count17);
		count.add(count18);
		count.add(count19);
		count.add(count20);
		count.add(count21);
		count.add(count22);
		count.add(count23);
		count.add(count24);
		count.add(count25);
		count.add(count26);
		count.add(count27);
		count.add(count28);
		count.add(count29);
		count.add(count30);
		count.add(count31);

		subButton.add(btn0);
		subButton.add(btn1);
		subButton.add(btn2);
		subButton.add(btn3);
		subButton.add(btn4);
		subButton.add(btn5);
		subButton.add(btn6);
		subButton.add(btn7);
		subButton.add(btn8);
		subButton.add(btn9);
		subButton.add(btn10);
		subButton.add(btn11);
		subButton.add(btn12);
		subButton.add(btn13);
		subButton.add(btn14);
		subButton.add(btn15);
		subButton.add(btn16);
		subButton.add(btn17);
		subButton.add(btn18);
		subButton.add(btn19);
		subButton.add(btn20);
		subButton.add(btn21);
		subButton.add(btn22);
		subButton.add(btn23);
		subButton.add(btn24);
		subButton.add(btn25);
		subButton.add(btn26);
		subButton.add(btn27);
		subButton.add(btn28);
		subButton.add(btn29);
		subButton.add(btn30);
		subButton.add(btn31);

		addButton.add(Button0);
		addButton.add(Button1);
		addButton.add(Button2);
		addButton.add(Button3);
		addButton.add(Button4);
		addButton.add(Button5);
		addButton.add(Button6);
		addButton.add(Button7);
		addButton.add(Button8);
		addButton.add(Button9);
		addButton.add(Button10);
		addButton.add(Button11);
		addButton.add(Button12);
		addButton.add(Button13);
		addButton.add(Button14);
		addButton.add(Button15);
		addButton.add(Button16);
		addButton.add(Button17);
		addButton.add(Button18);
		addButton.add(Button19);
		addButton.add(Button20);
		addButton.add(Button21);
		addButton.add(Button22);
		addButton.add(Button23);
		addButton.add(Button24);
		addButton.add(Button25);
		addButton.add(Button26);
		addButton.add(Button27);
		addButton.add(Button28);
		addButton.add(Button29);
		addButton.add(Button29);
		addButton.add(Button30);
		addButton.add(Button31);
	}

	@FXML
	public void buttonClick0(ActionEvent event) throws FileNotFoundException {
		System.out.println("Adding item to cart...");

		setup();

		Button numberButton = (Button) event.getTarget();
		int s = Integer.valueOf(numberButton.getId().substring(6)); // Get button index
		String productName = prodName.get(s).getText(); // Get product name

		int currentQuantity = count.get(s).getText().isEmpty() ? 0 : Integer.parseInt(count.get(s).getText());
		int updatedQuantity = currentQuantity + 1;
		count.get(s).setText(String.valueOf(updatedQuantity));

		// Enable and style the subtract button when an item is added
		subButton.get(s).setDisable(false);
		subButton.get(s).setText("-");
		subButton.get(s).setStyle("-fx-background-color: #026b02;  -fx-text-fill: white;");

		if (updatedQuantity == fetchProduct(productName).getCount()) {
			numberButton.setDisable(true);
		}

		Cart shoppingCart = Cart.getInstance();
		shoppingCart.addProduct(productName);

		double price = fetchProduct(productName).getPrice();
		budgetValueState -= price;

		if (budgetValueState < 0) {
			showAlert("Budget Exceeded", "Your budget has been exceeded!",
					"The total cart price exceeds the budget. Please remove some items.");
		}

		budgetValue.setText(String.format("%.2f", Math.max(budgetValueState, 0)));
		System.out.println("Updated Budget Value: $" + budgetValueState);
	}

	@FXML
	public void subtractButtonClick0(ActionEvent event) throws FileNotFoundException {
		System.out.println("Removing item from cart...");

		setup();

		Button numberButton = (Button) event.getTarget();
		int s = Integer.valueOf(numberButton.getId().substring(3));
		String productName = prodName.get(s).getText();

		int currentQuantity = count.get(s).getText().isEmpty() ? 0 : Integer.parseInt(count.get(s).getText());
		if (currentQuantity <= 1) {
			count.get(s).clear();
			subButton.get(s).setDisable(true);
		} else {
			int updatedQuantity = currentQuantity - 1;
			count.get(s).setText(String.valueOf(updatedQuantity));
		}

		if ((currentQuantity - 1) < fetchProduct(productName).getCount()) {
			addButton.get(s).setDisable(false);
		}

		Cart shoppingCart = Cart.getInstance();
		shoppingCart.deleteProduct(productName);

		double price = fetchProduct(productName).getPrice();
		budgetValueState += price;

		budgetValue.setText(String.format("%.2f", budgetValueState));
		System.out.println("Updated Budget Value: $" + budgetValueState);
	}

	private void showAlert(String title, String header, String content) {
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}

	public void switchToCart(ActionEvent event) throws IOException {

		System.out.println("Switching to Cart...");

		// Load the FXML file and get the associated controller
		FXMLLoader loader = new FXMLLoader(getClass().getResource("test.fxml"));
		Parent root = loader.load();
		CartController cartController = loader.getController();

		try {
			System.out.println("santu 1");
			cartController.displayCart();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Switch to the new scene
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}

	public static Product fetchProduct(String productName) throws FileNotFoundException {
		System.out.println("SAI 1  " + productName);

		Product cartProd = null;
		List<Product> availableProds = ReadingJson.ReadingJson();
		for (int i = 0; i < availableProds.size(); i++) {
			System.out.println("SAI 1.5 " + availableProds.get(i).getName());
			if (availableProds.get(i).getName().equals(productName)) {
				cartProd = availableProds.get(i);
			}
		}
		System.out.println("SAI 2  " + cartProd);

		return cartProd;
	}

	public static double budgetValueState = 0.0;

	public void setBudgetValue(double value) {
		budgetValueState = value;
		budgetValue.setText(String.format("%.2f", value));
	}

	public void initialize() {
		budgetValue.setEditable(false);
		if (budgetValueState > 0.0) {
			budgetValue.setText(String.format("%.2f", budgetValueState));
		}
	}

	@FXML
	public void logout(ActionEvent e) throws IOException {
		/* change scene to login screen */
		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}
