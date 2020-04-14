package mx.tec.lab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlListItem;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlParagraph;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlSpan;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

import org.junit.jupiter.api.AfterEach;


public class TestHtmlApplicationTests {
	private WebClient webClient;
	@BeforeEach
	public void init() throws Exception{
		webClient = new WebClient();
	}
	@AfterEach
	public void close() throws Exception{
		webClient.close();
	}
	@Test
	void givenAClient_whenEnteringAutomationPractice_thenPageTitleIsCorrect() throws Exception{
		webClient.getOptions().setThrowExceptionOnScriptError(false);
		HtmlPage page = webClient.getPage("http://automationpractice.com/index.php");
		assertEquals("My Store",page.getTitleText());
	}
	@Test
	public void givenAClient_whenEnteringLoginCredentials_thenAccountPageIsDisplayed() throws Exception{
		webClient.getOptions().setThrowExceptionOnScriptError(false);
		HtmlPage page = webClient.getPage("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		HtmlTextInput emailField = (HtmlTextInput) page.getElementById("email");
		emailField.setValueAttribute("pokket@a.com");
		HtmlPasswordInput passwordField = (HtmlPasswordInput)page.getElementById("passwd");
		passwordField.setValueAttribute("pokket");
		HtmlButton submitButton = (HtmlButton) page.getElementById("SubmitLogin");
		HtmlPage resultPage = submitButton.click();
		assertEquals("My account - My Store", resultPage.getTitleText());
	}//Done
	@Test
	public void givenAClient_whenEnteringWrongLoginCredentials_thenAuthenticationPageIsDisplayed() throws Exception{
		webClient.getOptions().setThrowExceptionOnScriptError(false);
		HtmlPage page = webClient.getPage("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		HtmlTextInput emailField = (HtmlTextInput) page.getElementById("email");
		emailField.setValueAttribute("pokket@a.coma");
		HtmlPasswordInput passwordField = (HtmlPasswordInput)page.getElementById("passwd");
		passwordField.setValueAttribute("pokketa");
		HtmlButton submitButton = (HtmlButton) page.getElementById("SubmitLogin");
		HtmlPage resultPage = submitButton.click();
		assertEquals("Login - My Store", resultPage.getTitleText());
	}//Done
	@Test
	public void givenAClient_whenEnteringWrongLoginCredentials_thenErrorMessageIsDisplayed() throws Exception{
		webClient.getOptions().setThrowExceptionOnScriptError(false);
		HtmlPage page = webClient.getPage("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		HtmlTextInput emailField = (HtmlTextInput) page.getElementById("email");
		emailField.setValueAttribute("pokket@a.coma");
		HtmlPasswordInput passwordField = (HtmlPasswordInput)page.getElementById("passwd");
		passwordField.setValueAttribute("pokketa");
		HtmlButton submitButton = (HtmlButton) page.getElementById("SubmitLogin");
		HtmlPage resultPage = submitButton.click();
		HtmlListItem result = resultPage.getFirstByXPath("//div[@class='alert alert-danger']/ol/li");
		assertEquals("Authentication failed.",result.getTextContent());
	}//Done
	@Test
	public void givenAClient_whenSearchingNotExistingProduct_thenNoResultsIsDisplayed() throws Exception{
		webClient.getOptions().setThrowExceptionOnScriptError(false);
		HtmlPage page = webClient.getPage("http://automationpractice.com/index.php");
		HtmlTextInput searchField = (HtmlTextInput) page.getElementById("search_query_top");
		searchField.setValueAttribute("Konosuba");
		HtmlButton submitButton = (HtmlButton) page.getElementByName("submit_search");
		HtmlPage resultPage = submitButton.click();
		HtmlSpan result = resultPage.getFirstByXPath("//span[@class='heading-counter']");
		assertEquals("0 results have been found.",result.getTextContent().trim());
		/*
		Por alguna razon de esta forma no lo pasaba aun usando Trim
		HtmlParagraph result = resultPage.getFirstByXPath("//p[@class='alert alert-warning']");
		assertEquals("No results were found for your search \"Konosuba\"",result.getTextContent().trim());
		*/
	}//Done
	@Test
	public void givenAClient_whenSearchingEmptyString_thenPleaseEnterDisplayed() throws Exception{
		webClient.getOptions().setThrowExceptionOnScriptError(false);
		HtmlPage page = webClient.getPage("http://automationpractice.com/index.php");
		HtmlButton submitButton = (HtmlButton) page.getElementByName("submit_search");
		HtmlPage resultPage = submitButton.click();
		HtmlParagraph result = resultPage.getFirstByXPath("//p[@class='alert alert-warning']");
		assertEquals("Please enter a search keyword",result.getTextContent().trim());
	}//Done
	@Test
	public void givenAClient_whenSigningOut_thenAuthenticationPageIsDisplayed() throws Exception{
		webClient.getOptions().setThrowExceptionOnScriptError(false);
		HtmlPage page = webClient.getPage("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		HtmlTextInput emailField = (HtmlTextInput) page.getElementById("email");
		emailField.setValueAttribute("pokket@a.com");
		HtmlPasswordInput passwordField = (HtmlPasswordInput)page.getElementById("passwd");
		passwordField.setValueAttribute("pokket");
		HtmlButton submitButton = (HtmlButton) page.getElementById("SubmitLogin");
		HtmlPage loggedPage = submitButton.click();
		HtmlAnchor anchor = loggedPage.getFirstByXPath("//a[@class='logout']");
		HtmlPage logoutPage = anchor.click();
		assertEquals("Login - My Store", logoutPage.getTitleText());
	}//Done
}
