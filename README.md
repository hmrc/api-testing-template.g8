
# api-testing-template

This repository can be used by teams who are in need of an API test suite that verifies requests within a backend service. 

The ui-test-template.g8 is developed and tested using:
* Java 1.8
* Scala 2.12.11
* sbt 1.3.12
* giter8 0.11.0-M3

It supports API testing using Cucumber as the test execution framework.

## Support
This repository is supported by HMRC Digital's Test Community.  If you have a query or find an issue please drop in to the #community-testing channel in Slack.

## Contributions
If you'd like to contribute we welcome you to raise a PR or issue against the project and notify one of the core maintainers in #community-testing.

## Generating an API Test project
You **DO NOT** need to clone this project to generate an API Test project from the template.  You simply need to have giter8 installed, and run the `g8` command below.

### [Install giter8 CLI](#install-giterate) 
You will need to have giter8 installed in order to generate a test suite from the api-testing-template. Due to some limitations with the SBT giter8 plugin, unfortunately this template will not generate successfully. 

Instructions to install giter8 can be found [here](http://www.foundweekends.org/giter8/setup.html).

### Generating an API Test project from master
To generate a test suite, execute the following command in the parent directory of where you'd like your API Test project created:
    
    g8 hmrc/api-testing-template.g8

This will prompt you for:
- **name** -> The name of the api test repository.  I.e. my-digital-service-api-tests

To execute the example tests, follow the steps in the project README.md

### A Note on the Example Feature file
The example tests created by this template are quite limited in what they do. They make some simple requests to some endpoints to show how to quickly get up and running using the api testing template. These tests depend on the services in the `PAYMENTS_DIRECT_DEBIT` being available:

    ASSETS_FRONTEND
    AUTH AUTH_LOGIN_API       
    AUTH_LOGIN_STUB
    BANK_ACCOUNT_REPUTATION_STUB
    BAS_GATEWAY 
    BAS_GATEWAY_FRONTEND 
    CA_FRONTEND    
    CONTACT_FRONTEND
    DATASTREAM
    DIRECT_DEBIT_BACKEND
    DIRECT_DEBIT_FRONTEND
    DIRECT_DEBIT_STUBS
    EMAIL 
    EMAIL_VERIFICATION 
    EMAIL_VERIFICATION_FRONTEND 
    EXTERNAL_PORTAL_STUB 
    HMRCDESKPRO   
    HMRC_EMAIL_RENDERER   
    IDENTITY_VERIFICATION
    MAILGUN_STUB
    PAYMENTS_ADMIN_FRONTEND
    PAYMENTS_STUBS
    PAY_API
    PAY_FRONTEND
    USER_DETAILS

## Development
If you'd like to contribute to the api-testing-template you'll need to test your changes before raising a PR (see below).  

### Generating an API Test project from you local changes
To create a test project from your local changes, execute the following command from the parent directory of your local copy of the template:

    g8 file://api-testing-template.g8/ --name=my-test-project

This will create a new API test project in a folder named `my-test-project/`.  
 
### Running the api-testing-template.g8 tests
There are test scripts (written in bash) in the `tests/` folder which can run API tests against the different test-environments.  To successfully run the tests you will need to satisfy the following pre-requisites: 

- [Install Giterate CLI](#install-giterate)
- Install and configure [Service Manager](https://github.com/hmrc/service-manager) (see Confluence)
- Install Mongo (see Confluence)

Copy `tests/test-api-testing-template.sh` to the parent directory of your local copy of the api-testing-template.g8 project.  Execute the script without params:

    ./test-api-testing-template.sh

**Note:** At present these tests create different types of projects off the template, and run the API tests off those projects.  No assertions are made to ensure that the test ran and passed, you will have to consult the logs to ensure that the tests ran successfully.
