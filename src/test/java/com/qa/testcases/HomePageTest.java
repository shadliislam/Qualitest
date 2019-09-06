package com.qa.testcases;

import com.qa.Analyzer.RetryAnalyzer;
import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
	HomePage homePage;

	public HomePageTest(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		initialization();
		homePage = new HomePage();
	}
	@Test(priority=1, retryAnalyzer = RetryAnalyzer.class)
	public void elementPresentTest(){
		boolean flag =homePage.elementIsPresent();
		Assert.assertTrue(flag);
	}

	@Test(priority=2)
	public void emptyQueryCheck(){
		String expectedMsg="Provide some query";
		Assert.assertEquals(homePage.checkEmptyQuery(),expectedMsg);
		System.out.println("Empty Query is forbidden");
	}

	@Test(priority=3)
	public void searchPositiveResultCount(){
		String positiveInput="la";
		Assert.assertTrue(homePage.countPositiveQuery(positiveInput)!=0);
	}

	@Test(priority=4)
	public void searchNoResultCount(){
		boolean flag=homePage.countPositiveQuery("castle")==0;
		Assert.assertTrue(flag);
	}

	@Test(priority = 5)
	public void matchSearchResultQuery(){
		String queryInput="Port Royal";
		boolean flag=homePage.queryMatchingWithSearchResult(queryInput);
		Assert.assertTrue(flag);

	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}





}
