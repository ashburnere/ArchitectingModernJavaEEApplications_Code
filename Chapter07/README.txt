Code examples from chapter 7:
- tested with OpenLiberty 18.0.0.3 (see DEPENDENCIES/server.xml for settings)

- contains the following projects:

	- car-manufacture-mockito:
		- shows hot to use Mockito API in unit tests to mock away CDI delegates which are usually managed by the CDI-container but are not relevant for the performed unit tests 
	
	- car-manufacture-persistance:
		- shows hot to use Mockito API in component tests

	- cars-cdi-unit: 
		- shows how to use the CDI-Unit API to verify technical wiring (like dependency injection) and to do integration tests
		- uses H2 DB to persist a car in the main app at http://localhost:9080/car-manufacture-cdi-unit/resources/cars 
		
	- car-manufacture-testing:
		- shows how to use the Arquillian Framework to do integration tests in a JAVA EE container
		
	- systemtest:
		- TODO
		
	- performancetest
		- TODO

