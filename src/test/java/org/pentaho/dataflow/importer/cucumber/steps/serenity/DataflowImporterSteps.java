package org.pentaho.dataflow.importer.cucumber.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.pentaho.dataflow.importer.pages.AvailablePage;
import org.pentaho.dataflow.importer.pages.BasePage;
import org.pentaho.dataflow.importer.pages.InstallPage;
import org.pentaho.dataflow.importer.pages.LoginPage;
import org.pentaho.dataflow.importer.pages.MainPage;

public class DataflowImporterSteps {

  BasePage basePage;
  LoginPage loginPage;
  MainPage mainPage;
  AvailablePage availablePage;
  InstallPage installPage;

  /************************************************************************************************
   * **********************************************************************************************
   *
   * BASE PAGE STEPS
   *
   *************************************************************************************************
   *************************************************************************************************/


  @Step( "Navigating to Login Page" )
  public LoginPage navigateToLoginPage() {

    return basePage.navigateToLoginPage();
  }

  /************************************************************************************************
   * **********************************************************************************************
   *
   * LOGIN PAGE STEPS
   *
   *************************************************************************************************
   *************************************************************************************************/

  @Step( "Logging into the application with userName: {0} & passsword: {1}" )
  public MainPage doLogin( String userName, String password ) {

    return loginPage.doLogin( userName, password );
  }

  /************************************************************************************************
   * **********************************************************************************************
   *
   * AVAILABLE PAGE STEPS
   *
   *************************************************************************************************
   *************************************************************************************************/

  @Step( "Navigate to available solutions" )
  public AvailablePage navigateToAvailablePage() {

    return mainPage.navigateToAvailable();
  }

  @Step( "Show {0} avalibale rows" )
  public AvailablePage showAvailableRows( int rowsCount ) {

    return availablePage.showAvailableRows( rowsCount );
  }

  @Step( "Clicking on solution {0} version {1}" )
  public InstallPage clickOnSolution( String solutionName, String version ) {

    return availablePage.clickOnSolution( solutionName, version );
  }

  /************************************************************************************************
   * **********************************************************************************************
   *
   * INSTALL PAGE STEPS
   *
   *************************************************************************************************
   *************************************************************************************************/

  @Step( "Install Importer solution with name {0}" )
  public InstallPage installNewDataflowImporterSolution( String newImporterSolutionName ) {

    return installPage.installNewDataflowImporterSolution( newImporterSolutionName );
  }
}
