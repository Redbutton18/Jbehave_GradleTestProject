package com.uttesh;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

public class LogicSteps {
	
	  int number;
	
	  @Given("a variable number with value $num")
	  public void numOfNodes(int num) {
		  this.number = num;
	  }
	  
	  @When("number value is less than $x")
	  public void negativeValue(int x) {
		  if(this.number < x) {
			  System.out.println("negative number input");
		  }
	  }
	  
	  @When("number value of number is negative")
	  public void negativePrint() {
		  System.out.println("negativeValue");
	  }
	  
	  @When("print the value of number is zero")
	  public void zeroPrint() {
		  System.out.println("negative Value");
	  }
	  
	  @When("number value is equal to $y")
	  public void zeroValue(int y) {
		  if(this.number == y) {
			  System.out.println("input value is zero");
		  }
	  }
	  
	  @Then("the given number is $word")
	  public void getTheListSize(String word) {
		NumberToWord numberToWord = new NumberToWord();
		String result = numberToWord.convert(this.number);
	    Assert.assertEquals(result, word);
	  }
	}
