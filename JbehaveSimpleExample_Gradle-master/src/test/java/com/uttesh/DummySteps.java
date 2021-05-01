package com.uttesh;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

public class DummySteps {
	private int input = 0;
	private int result = 0;

	@Given("a variable x with value $input")
	public void getNumber(int input) {
		this.input=input;
	}
	
	@When("I multiply x by $multiplied")
	public void multiplied(int number) {
		this.result = input *number;
	}
	
	@Then("x should equal $result")
	public void finalResult(int result) {
		Assert.assertEquals(result, this.result);
	}
}
