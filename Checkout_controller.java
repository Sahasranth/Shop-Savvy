package application;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Checkout_controller {
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
	private Button chout;
	@FXML
	private TextField tot;
	@FXML
	private Button bill;
	private static String path = ((Paths.get("aisles.json")).toAbsolutePath()).toString();

	public void checkout(ActionEvent event) {
		displayTotalCost();
	}

	public void switchToThankyou(ActionEvent e) throws IOException {
		countUpdation();
		Parent root = FXMLLoader.load(getClass().getResource("thankyou.fxml"));
		Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void displayTotalCost() {
		Cart shoppingCart = Cart.getInstance();
		tot.setText("$" + String.format("%.2f", shoppingCart.calculateTotal()));
	}

	public void countUpdation() {
		Cart shoppingCart = Cart.getInstance();
		List<Integer> aisles = shoppingCart.getAisles();
		for (int i = 0; i < aisles.size(); i++) {
			int elements = shoppingCart.getCountMap(aisles.get(i)).size();
			for (int j = 0; j < elements; j++) {
				List<String> prodNames = shoppingCart.getProductNames(aisles.get(i));
				int initCount = shoppingCart.getCountMap(aisles.get(i)).get(prodNames.get(j)).getProduct().getCount();
				int countToBeSub = shoppingCart.getCountMap(aisles.get(i)).get(prodNames.get(j)).getQuantity();
				System.out.println(initCount - countToBeSub);
				shoppingCart.getCountMap(aisles.get(i)).get(prodNames.get(j)).getProduct().setCount(initCount - countToBeSub);
				shoppingCart.getCountMap(aisles.get(i)).get(prodNames.get(j)).resetQuantity();
			}
		}
	}

	public void switchToScene1(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@SuppressWarnings("unchecked")
	public static void jsonUpdate(int asl, String productName, int newCount) {
		JSONParser jsonParser = new JSONParser();
		Object jsonObject;
		try {
			jsonObject = jsonParser.parse(
					new FileReader("C:\\\\Users\\\\18574\\\\eclipse-workspace\\\\MyTest\\\\src\\\\application\\\\aisles.json"));
			JSONObject json = (JSONObject) jsonObject;
			JSONArray aisles = (JSONArray) json.get("aisles");
			for (int i = 0; i < aisles.size(); i++) {
				JSONObject aisle = (JSONObject) aisles.get(i);
				Integer aisleNum = Integer.parseInt((String) aisle.get("number"));
				if (aisleNum == asl) {
					JSONArray items = (JSONArray) aisle.get("items");
					for (int j = 0; j < items.size(); j++) {
						JSONObject item = (JSONObject) items.get(j);
						String itemName = (String) item.get("name");

						if (itemName.equals(productName)) {
							System.out.println(item);
							item.put("count", String.valueOf(newCount));
							System.out.println(item.get("count"));
							System.out.println(newCount);
							System.out.println(item);
							Writer file = new FileWriter(
									"C:\\\\Users\\\\18574\\\\eclipse-workspace\\\\MyTest\\\\src\\\\application\\\\aisles.json", false);
							file.write(item.toJSONString());
							file.flush();
							file.close();
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
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

}
