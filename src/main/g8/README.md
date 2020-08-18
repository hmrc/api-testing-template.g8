**This is a template README.md.  Be sure to update this with project specific content that describes your api test project.**

# $name$
API test suite for the `<digital service name>` using Cucumber and [play-ws](https://github.com/playframework/play-ws) client.  

## Running the tests

Prior to executing the tests ensure you have:
 - Installed [MongoDB](https://docs.mongodb.com/manual/installation/) 
 - Installed/configured [service manager](https://github.com/hmrc/service-manager).  

Run the following command to start services locally:

    sudo mongod
    sm --start PAYMENTS_DIRECT_DEBIT -f

Then execute the Cucumber tests:
    
    sbt clean test

The tests default to the `local` environment.  For a complete list of supported param values, see:
 - `src/test/resources/application.conf` for **environment** 
 
#### Running the tests against a test environment

To run the tests against an environment set the corresponding `host` environment property as specified under
 `<env>.host.services` in the [application.conf](/src/test/resources/application.conf). 