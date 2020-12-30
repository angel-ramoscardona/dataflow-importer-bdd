package org.pentaho.dataflow.importer.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class AvailablePage extends BasePage {

  private static final String SOLUTION_XPATH_TEMPLATE =
    "//div[@class='HvLink-a'][contains(text(),'%s')][../../following-sibling::div[2]//div[contains(text(),'%s')]]";

  @FindBy( xpath = "//select" )
  private WebElementFacade rowsDropdownId;

  public AvailablePage showAvailableRows( int rowsCount ) {
    selectFromDropdown( rowsDropdownId, Integer.toString( rowsCount ) );
    return this;
  }

  public InstallPage clickOnSolution( String solutionName, String version ) {

    String solutionXpath = String.format( SOLUTION_XPATH_TEMPLATE, solutionName, version );
    waitFor( solutionXpath ).$( solutionXpath ).click();
    return this.switchToPage( InstallPage.class );
  }
}
