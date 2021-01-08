package org.pentaho.dataflow.importer.cucumber.steps;

import org.pentaho.dataflow.importer.cucumber.steps.serenity.DataflowImporterSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class DataflowImporterInstallationSteps {

  @Steps
  DataflowImporterSteps importer;

  @Given( "^I navigate to the login page$" )
  public void iNavigateToTheLoginPage() {
    importer.navigateToLoginPage();
  }

  @Then( "^I login with valid (.*) and (.*)$" )
  public void iLoginWithValidAnyAndAny( String userName, String password ) {
    importer.doLogin( userName, password );
  }

  @Then( "^I navigate to available solutions$" )
  public void iNavigateToAvailableSolutions() {
    importer.navigateToAvailablePage();
  }

  @And( "^Show (\\d+) rows$" )
  public void showRows( int rowsCount ) {
    importer.showAvailableRows( rowsCount );
  }

  @Then( "^Click on solution (.*) version (.*)$" )
  public void clickOnSolution( String solutionName, String version ) {
    importer.clickOnSolution( solutionName, version );
  }

  @Then( "^Install Importer solution with name (.*)$" )
  public void installNewDataflowImporterSolution( String newImporterSolutionName ) {
    importer.installNewDataflowImporterSolution( newImporterSolutionName );
  }

  @Then( "^Installation of Importer fails$" )
  public void installationOfImporterFails() {
    importer.installNewDataflowImporterSolutionWhenAlreadyInstalled();
  }
}
