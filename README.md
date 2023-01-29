# Read Me First

This is a simple example to create a message and send to kafka topic.

## Getting Started

* User java 17
* Build the jar file and put in any folder
* Copy the application.properties from src/main/resource to the same folder as the jar file
* Adjust the port, values, etc in the application.properties as you need
* Run your kafka


## Test to generate message through REST calls

* curl -X POST http://localhost:8760/add-user -H "Content-Type: application/json" -d '{"userAccountUUID":"1111-2222-3333", "login": "create-aaa", "pin": "1111", "password": "xxx", "organizationUID":"aaaa-bbbb-cccc"}'
