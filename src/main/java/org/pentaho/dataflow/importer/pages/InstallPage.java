package org.pentaho.dataflow.importer.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;

public class InstallPage extends BasePage {

  @FindBy( xpath = "//input[@id='solutionInstanceNameInput-input']" )
  WebElementFacade solutionNameInputId;

  @FindBy( xpath = "//textarea" )
  WebElementFacade valuesTextArea;

  @FindBy( xpath = "//span[@class='MuiButton-label'][contains(text(),'Install')]" )
  WebElementFacade installButton;

  @FindBy( xpath = "//span[@class='MuiButton-label'][contains(text(),'Close')]" )
  WebElementFacade closeButton;

  public InstallPage installNewDataflowImporterSolution( String newImporterSolutionName ) {


    clearWebElement( solutionNameInputId );
    solutionNameInputId.type( newImporterSolutionName );

    clearWebElement( valuesTextArea );
    valuesTextArea.sendKeys( "replicaCount: 1\n"
      + "image:\n"
      + Keys.SPACE + Keys.SPACE
      + "repository: ldl-dev-r2d2-c7-registry.dogfood.trylumada.com/data-flow-importer\n"
      + "pullPolicy: IfNotPresent\n"
      + "tag: 1.0.0-KAMBOL1216d\n"
      + Keys.BACK_SPACE
      + "dataFlowStudio:\n"
      + Keys.SPACE + Keys.SPACE
      + "server: http://dataflow-studio-1\n"
      + "port: 3001\n"
      + "endpoint: /cxf/dataflow-manager\n"
      + "volume:\n"
      + Keys.SPACE + Keys.SPACE
      + "pdi:\n"
      + Keys.SPACE + Keys.SPACE
      + "host: 18.191.178.241\n"
      + "path: /R2D2_1\n"
      + "mountPath: /root/.kettle\n"
      + Keys.BACK_SPACE + Keys.BACK_SPACE
      + "hibernate:\n"
      + Keys.SPACE + Keys.SPACE
      + "server: data-flow-importer-postgres-cluster\n"
      + "port: 5432\n"
      + "secret: hibernate.data-flow-importer-postgres-cluster.credentials.postgresql.acid.zalan.do\n"
      + "schemaVersion: 1\n"
      + Keys.BACK_SPACE
      + "components:\n"
      + Keys.SPACE + Keys.SPACE
      + "database:\n"
      + Keys.SPACE + Keys.SPACE
      + "name: data-flow-importer-postgres-cluster\n"
      + "teamId: data-flow-importer\n"
      + "volume:\n"
      + Keys.SPACE + Keys.SPACE
      + "size: 1Gi\n"
      + Keys.BACK_SPACE
      + "numberOfInstances: 1\n"
      + Keys.BACK_SPACE
      + Keys.SPACE + Keys.SPACE
      + "importer:\n"
      + Keys.SPACE + Keys.SPACE
      + "name: dataflow-importer\n"
      + "appName: Dataflow Studio Importer\n"
      + "containerPort: 8081\n"
      + "interval: 10000\n"
      + "service:\n"
      + Keys.SPACE + Keys.SPACE
      + "type: ClusterIP\n"
      + "port: 8084\n"
      + Keys.BACK_SPACE
      + "replicaCount: 1" );

    installButton.click();
    waitForAllTextToAppear( "Installing Solution dataflow-importer", "Success" );
    closeButton.click();

    return this;
  }

  private void clearWebElement( WebElementFacade webElement ) {
    //Had to loop backspace because webElement.clear() does not work on this element
    webElement.click();
    if ( System.getProperty( "os.name" ).toUpperCase().contains( "MAC" ) ) {
      webElement.sendKeys( Keys.COMMAND + "a" );
    } else {
      webElement.sendKeys( Keys.CONTROL + "a" );
    }
    webElement.sendKeys( Keys.BACK_SPACE );
  }

  public InstallPage installNewDataflowImporterSolutionWhenAlreadyInstalled() {

    installButton.click();
    waitForAllTextToAppear( "Installing Solution dataflow-importer", "Output" );
    waitForTextToDisappear( "Success" );
    closeButton.click();

    return this;
  }
}
