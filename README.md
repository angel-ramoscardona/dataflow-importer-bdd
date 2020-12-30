# dataflow-importer-bdd

This Serenity POC tests the successful installation of the dataflow-importer in the dev cluster.

This POC follows the model used in the Serenity training. All the values used live solution name and version are hardcoded.

Make sure the user tapestry/tapestry123 exists and has solution install permissions. Also, uninstall any installed imported prior to executing this test.

To run execute the following command from the project's root folder:

_**mvn clean verify serenity:aggregate**_

