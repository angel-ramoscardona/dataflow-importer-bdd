package org.pentaho.dataflow.importer.pages;

public class LoginPage extends BasePage {

  private static final String USER_NAME_INPUT = "//input[@id='username']";

  private static final String PASSWORD_INPUT = "//input[@id='password']";

  private static final String LOGIN_BUTTON = "//input[@id='kc-login']";

  private static final String LOGOUT_BUTTON = "//div[@class='HvIconLogOut-root HvIconLogOut-rootS']";

  /**
   * Method used to login to the store
   *
   * @param userName
   * @param password
   * @return
   */
  public MainPage doLogin( String userName, String password ) {

    waitForTextToAppear( "Username or email" );

    waitForTextToAppear( "Password" );

    waitFor( USER_NAME_INPUT ).$( USER_NAME_INPUT ).type( userName );

    waitFor( PASSWORD_INPUT ).$( PASSWORD_INPUT ).type( password );

    waitFor( LOGIN_BUTTON ).$( LOGIN_BUTTON ).click();

    waitFor( LOGOUT_BUTTON );

    return this.switchToPage( MainPage.class );

  }
}
