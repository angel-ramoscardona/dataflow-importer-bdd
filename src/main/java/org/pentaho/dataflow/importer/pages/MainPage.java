package org.pentaho.dataflow.importer.pages;

public class MainPage extends BasePage {

  /**
   * Method used to navigate to available solutions
   *
   * @return
   */
  public AvailablePage navigateToAvailable() {

    waitFor( AVAILABLE_MENU_ENTRY ).$( AVAILABLE_MENU_ENTRY ).click();

    waitForAllTextToAppear( "Name", "Description", "Version" );

    return this.switchToPage( AvailablePage.class );

  }
}
