// Java program for write JSON to a file
package application;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class ReadingJson
{
	public static List<Product> ReadingJson() throws FileNotFoundException
	{
		JSONParser jsonParser = new JSONParser();
		Object jsonObject;
		List<Product> ProdArray = new ArrayList<>();
	      try {
	         //Parsing the contents of the JSON file
	         jsonObject = jsonParser.parse(new FileReader("./src/application/aisles.json"));
	         JSONObject json = (JSONObject) jsonObject;
	         JSONArray aisles = (JSONArray) json.get("aisles");
	         for (int i=0; i<aisles.size(); i++) {
	        	 JSONObject aisle = (JSONObject) aisles.get(i);
	        	 Integer aisleNum  = Integer.parseInt((String)aisle.get("number"));
		         String aisleCategory = (String) aisle.get("category");
		         JSONArray items = (JSONArray) aisle.get("items");
		         for (int j=0; j<items.size(); j++) {
		        	 JSONObject item = (JSONObject) items.get(j);
		        	 String itemName = (String) item.get("name");
		        	 Double itemPrice  = Double.parseDouble((String)item.get("price"));
		        	 Integer itemCount  = Integer.parseInt((String)item.get("count"));
		        	 String itemImage = (String) item.get("image");
		           	 Product p1 = new Product(aisleCategory, aisleNum, itemName, itemPrice, itemCount, itemImage);
		        	 ProdArray.add(p1);
		         }		         
	         }
	      } catch (FileNotFoundException e) {
	            e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (ParseException e) {
	         e.printStackTrace();
	      }
		return ProdArray;
	}
	
	public static List<Product> searchStr(List<Product> lst, String stri) {
		System.out.println("bhima 1 "+ stri);
		
		List<Product> srch = new ArrayList<>();
        for (int k=0; k<lst.size(); k++) {
       	 String nm = lst.get(k).getName();
       	 System.out.println("sai "+ nm);
       	 if (Search(stri, nm) == true) {
       		 System.out.println("match found");
       		 srch.add(lst.get(k));
       	 }
        }
        return srch;
	}
	
	public static Boolean Search(String stri, String name) {

		final int length = stri.length();
	    if (length == 0)
	        return true; // Empty string is contained
	        
	    final char frstLo = Character.toLowerCase(stri.charAt(0));
	    final char frstUp = Character.toUpperCase(stri.charAt(0));
	    
	    for (int i = name.length() - length; i >= 0; i--) {
	        final char ch = name.charAt(i);
	        if (ch != frstLo && ch != frstUp)
	            continue;
	        
	        if (name.regionMatches(true, i, stri, 0, length))
	            return true;
	    }
	    
	    return false;
	}
}
