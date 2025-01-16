package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class SceneController2 {
	private Stage stage;
	private Scene scene;
	private Parent root;
	private TextField Srch;
	String searchStr;
	static List<Product> searchList;

	List<TextField> name = new ArrayList<TextField>();
	List<TextField> aisle = new ArrayList<TextField>();
	List<TextField> price = new ArrayList<TextField>();
	List<ImageView> image = new ArrayList<ImageView>();
	List<Button> addButton = new ArrayList<Button>();
	List<TextField> count = new ArrayList<TextField>();
	List<Button> subButton = new ArrayList<Button>();

	@FXML
	private TextField name0;
	@FXML
	private TextField aisle0;
	@FXML
	private TextField price0;
	@FXML
	private Button button0;
	@FXML
	private ImageView image0;
	@FXML
	private TextField count0;
	@FXML
	private Button btn0;

	@FXML
	private TextField name1;
	@FXML
	private TextField aisle1;
	@FXML
	private TextField price1;
	@FXML
	private Button button1;
	@FXML
	private ImageView image1;
	@FXML
	private TextField count1;
	@FXML
	private Button btn1;

	@FXML
	private TextField name2;
	@FXML
	private TextField aisle2;
	@FXML
	private TextField price2;
	@FXML
	private Button button2;
	@FXML
	private ImageView image2;
	@FXML
	private TextField count2;
	@FXML
	private Button btn2;

	@FXML
	private TextField name3;
	@FXML
	private TextField aisle3;
	@FXML
	private TextField price3;
	@FXML
	private Button button3;
	@FXML
	private ImageView image3;
	@FXML
	private TextField count3;
	@FXML
	private Button btn3;

	@FXML
	private TextField name4;
	@FXML
	private TextField aisle4;
	@FXML
	private TextField price4;
	@FXML
	private Button button4;
	@FXML
	private ImageView image4;
	@FXML
	private TextField count4;
	@FXML
	private Button btn4;

	@FXML
	private TextField name5;
	@FXML
	private TextField aisle5;
	@FXML
	private TextField price5;
	@FXML
	private Button button5;
	@FXML
	private ImageView image5;
	@FXML
	private TextField count5;
	@FXML
	private Button btn5;

	@FXML
	private TextField name6;
	@FXML
	private TextField aisle6;
	@FXML
	private TextField price6;
	@FXML
	private Button button6;
	@FXML
	private ImageView image6;
	@FXML
	private TextField count6;
	@FXML
	private Button btn6;

	@FXML
	private TextField name7;
	@FXML
	private TextField aisle7;
	@FXML
	private TextField price7;
	@FXML
	private Button button7;
	@FXML
	private ImageView image7;
	@FXML
	private TextField count7;
	@FXML
	private Button btn7;

	private List<Product> searchingList;

	// private ImageView img;
	SceneController ctrl1 = new SceneController();

	public void switchToScene1(ActionEvent event) throws IOException {
		System.out.println("Home button  invoked");

		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void setSearchList(List<Product> searchList) throws IOException {
		this.searchingList = searchList;
		displayResults();
	}

	private void displayResults() throws IOException {

		name.add(name0);
		name.add(name1);
		name.add(name2);
		name.add(name3);
		name.add(name4);
		name.add(name5);
		name.add(name6);
		name.add(name7);

		aisle.add(aisle0);
		aisle.add(aisle1);
		aisle.add(aisle2);
		aisle.add(aisle3);
		aisle.add(aisle4);
		aisle.add(aisle5);
		aisle.add(aisle6);
		aisle.add(aisle7);

		price.add(price0);
		price.add(price1);
		price.add(price2);
		price.add(price3);
		price.add(price4);
		price.add(price5);
		price.add(price6);
		price.add(price7);

		addButton.add(button0);
		addButton.add(button1);
		addButton.add(button2);
		addButton.add(button3);
		addButton.add(button4);
		addButton.add(button5);
		addButton.add(button6);
		addButton.add(button7);

		image.add(image0);
		image.add(image1);
		image.add(image2);
		image.add(image3);
		image.add(image4);
		image.add(image5);
		image.add(image6);
		image.add(image7);

		count.add(count0);
		count.add(count1);
		count.add(count2);
		count.add(count3);
		count.add(count4);
		count.add(count5);
		count.add(count6);
		count.add(count7);

		subButton.add(btn0);
		subButton.add(btn1);
		subButton.add(btn2);
		subButton.add(btn3);
		subButton.add(btn4);
		subButton.add(btn5);
		subButton.add(btn6);
		subButton.add(btn7);

		for (int i = 0; i < this.searchingList.size(); i++) {
			String prodName = this.searchingList.get(i).getName();
			int aisles = this.searchingList.get(i).getAisle();
			double prices = this.searchingList.get(i).getPrice();
			String prodAisle = "Aisle" + Integer.toString(aisles);
			String prodPrice = "$" + Double.toString(prices);
			String prodImage = this.searchingList.get(i).getImage();
			name.get(i).setText(prodName);
			// name.get(i).setWrapText(true);
			aisle.get(i).setText(prodAisle);
			price.get(i).setText(prodPrice);
			addButton.get(i).setText("+");
			addButton.get(i).setStyle("fx-background-color: #FF0000");
			addButton.get(i).setUserData(prodName);
			subButton.get(i).setUserData(prodName);
			InputStream stream = new FileInputStream(System.getProperty("user.dir") + "/src/assets/" + prodImage);
			Image img = new Image(stream);
			image.get(i).setImage(img);
		}

	}

	public void buttonClick(ActionEvent event) throws FileNotFoundException {
		Button numberButton = (Button) event.getTarget();
		String productName = (String) numberButton.getUserData();
		int s = Integer.valueOf(numberButton.getId().substring(6));
		String cnt = count.get(s).getText();
		int c = 0;
		if (cnt.isEmpty()) {
			count.get(s).setText("1");
			subButton.get(s).setDisable(false);
			subButton.get(s).setText("-");
			subButton.get(s).setStyle("fx-background-color: #FF0000");
			c = 1;
		} else {
			c = Integer.valueOf(cnt) + 1;
			count.get(s).setText(Integer.toString(c));
		}
		if (c == ((fetchProduct(productName).getCount()))) {
			numberButton.setDisable(true);
		}
		Cart shoppingCart = Cart.getInstance();
		try {
			shoppingCart.addProduct(productName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void subtractButtonClick(ActionEvent event) throws FileNotFoundException {
		Button numberButton = (Button) event.getTarget();
		String productName = (String) numberButton.getUserData();
		int s = Integer.valueOf(numberButton.getId().substring(3));
		int cnt = Integer.valueOf(count.get(s).getText());
		if (cnt <= 1) {
			count.get(s).clear();
			subButton.get(s).setDisable(true);
		} else {
			int c = Integer.valueOf(cnt) - 1;
			count.get(s).setText(Integer.toString(c));
		}
		if ((Integer.valueOf(cnt) - 1) < ((fetchProduct(productName).getCount()))) {
			addButton.get(s).setDisable(false);
		}
		Cart shoppingCart = Cart.getInstance();
		try {
			shoppingCart.deleteProduct(productName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void switchToCart(ActionEvent event) throws IOException {
		System.out.println("swirch to cart");
		Parent root = FXMLLoader.load(getClass().getResource("Cart.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void switchToCheckout(ActionEvent event) throws IOException {
		System.out.println("swirch to checkout");

		Parent root = FXMLLoader.load(getClass().getResource("checkout.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public static Product fetchProduct(String productName) throws FileNotFoundException {
		Product cartProd = null;
		List<Product> availableProds = ReadingJson.ReadingJson();
		for (int i = 0; i < availableProds.size(); i++) {
			if (availableProds.get(i).getName().equals(productName)) {
				cartProd = availableProds.get(i);
			}
		}
		return cartProd;
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