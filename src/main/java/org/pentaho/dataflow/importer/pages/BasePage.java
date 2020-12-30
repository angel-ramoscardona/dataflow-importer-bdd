package org.pentaho.dataflow.importer.pages;

import net.serenitybdd.core.pages.PageObject;

public class BasePage extends PageObject {

  protected static final String INSTALLED_MENU_ENTRY = "//div[@role='button'][contains(text(),'Installed')]";
  protected static final String AVAILABLE_MENU_ENTRY = "//div[@role='button'][contains(text(),'Available')]";

  /**
   * Method used to navigate to the signOn Page
   *
   * @return
   */
  public LoginPage navigateToLoginPage() {

    open();

    waitForTextToAppear( "Username or email" );

    return this.switchToPage( LoginPage.class );

  }
}
