package br.com.silas.votenolivro.view.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HomePageTest {

	private WebDriver webDriver;
	
	@Before
	public void init() {
		webDriver = new HtmlUnitDriver(true);
	}
	
	@Test
	public void deveValidarFormularioComSucesso() {
		webDriver.get("http://localhost:8080/");
				
		WebElement form = webDriver.findElement(By.id("form"));
		form.findElement(By.name("nome")).sendKeys("Nome do usuário");
		form.findElement(By.name("email")).sendKeys("email_usuario@teste.com.br");
		
		WebElement btnSubmit = webDriver.findElement(By.id("btnSubmit"));
		btnSubmit.click();
		
		Assert.assertEquals("Vote No Livro - Escolha um livro", webDriver.getTitle());
	}
	
	@Test
	public void deveBloquearEmailInvalido() {
		webDriver.get("http://localhost:8080/");
		
		WebElement form = webDriver.findElement(By.id("form"));
		form.findElement(By.name("nome")).sendKeys("Nome do usuário");
		form.findElement(By.name("email")).sendKeys("E-mail inválido");
		
		WebElement btnSubmit = webDriver.findElement(By.id("btnSubmit"));
		btnSubmit.click();
		
		WebElement emailError = form.findElement(By.id("email-error"));
		
		Assert.assertEquals("E-mail inválido.", emailError.getText());
	}
}