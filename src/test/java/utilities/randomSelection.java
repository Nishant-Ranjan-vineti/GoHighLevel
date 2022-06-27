package utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;

public class randomSelection {
	
	
	
	public List<WebElement> getRandomElement(List<WebElement> list,int totalItems) 
    { 
        Random rand = new Random(); // object of Random class.
  
       //temprory list to hold selected items.
        List<WebElement> tempList = new ArrayList<WebElement>(); 
        for (int i = 0; i < totalItems; i++) { 
            int randomIndex = rand.nextInt(list.size());
            tempList.add(list.get(randomIndex)); 
        } 
        return tempList; 
    }

}
