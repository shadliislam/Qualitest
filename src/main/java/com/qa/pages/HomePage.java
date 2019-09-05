package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends TestBase {

    //Pagefactories
    @FindBy(id= "search-input")
    WebElement searchBox;

    @FindBy(id = "search-button")
    WebElement searchBttn;

    @FindBy(xpath = "//*[@id=\"search-results\"]/div")
    WebElement srchResultErrorMsg;

    @FindBy(xpath = "//ul[@id=\"search-results\"]/li")
    List<WebElement> searchResultElements;

    //PageFactory initializing
    public HomePage() {
        PageFactory.initElements(driver,this);
    }

    //Actions
    public boolean elementIsPresent(){
        return searchBox.isDisplayed() & searchBttn.isDisplayed();
    }

    public String checkEmptyQuery(){
        searchBttn.click();
        String actual_msg=srchResultErrorMsg.getText();
        return actual_msg;
    }

    public int countPositiveQuery(String queryInput){
        searchBox.sendKeys(queryInput);
        searchBttn.click();
        int count=searchResultElements.size();
        return count;
    }

    public boolean queryMatchingWithSearchResult(String queryInput){
        searchBox.sendKeys(queryInput);
        searchBttn.click();

        List<String> searchOutputTexts = new ArrayList<String>();

        for (WebElement item : searchResultElements)
        {
            if (item.getText().toLowerCase().contains(queryInput.toLowerCase()))
                return true;
        }
        return false;
    }

        /*for (WebElement item:searchResultElements){
            searchOutputTexts.add(item.getText());
            System.out.println(searchOutputTexts);
            flag=searchOutputTexts.contains(queryInput);
            System.out.println(flag);
        }

        return flag;

        }*/


}
