This application is a Demo project that uses OAuth spring security.
The Authentication Server used is Key Cloak.

Installation Process of Key Cloak:
--------------------------------
I am using a docker image to start the Key cloak server in the Docker container:

Command to download a docker image from docker hub to local Docker desktop:
-------------------------------------------------------------------------------
	docker pull quay.io/keycloak/keycloak:latest
The above command will pull the Keycloak image and install the Key Cloak server in Docker Desktop.

Command to run the Keycloak server in development mode
-----------------------------------------------------------------
docker run --name keycloak_server -p 8180:8180 \
		-e KEYCLOAK_ADMIN=admin \
		-e KEYCLOAK_ADMIN_PASSWORD=password \
		quay.io/keycloak/keycloak:latest \
		start-dev \
		--http-port=8180

	Once the server gets started in the Docker desktop we can the use localhost and then we can login as a Admin user
	base url :http://localhost:8180/

	Administrator User name and pwd used in the project:
		User : admin
		password: password
	We then need to create a new Realms
	Create new users

	Users username and password
	user : abhijeet
	password : abhijeet

	Realms: appDeveloper

URL to fetch token for auth code :
This is a GET URL :
	http://localhost:8180/realms/appDeveloper/protocol/openid-connect/auth?client_id=application-client-web&response_type=code&scope=openid profile&redirect_uri=http://localhost:8089/callback&state=test

Micro service Modules:
    1. Discovery Service :
        http://localhost:8761/ (Default)
    2. API Gate way Service
        http://localhost:8080/
    3. API_Resource Server (This is a sample Resource Server that has the protected end points).
    4. Stock_Details_Client_App (This is the client Application that is used to fetch the resource from resource Server.
    5.

Rest End points Calls with Admin Role:-
    http://localhost:8080/resourceServer1/admin/addUser
    http://localhost:8080/resourceServer1/admin/deleteUsers

Rest End points call with appDeveloper Role:-
    http://localhost:8080/resourceServer1/users/status/check
    http://localhost:8080/resourceServer1/users/connect
    http://localhost:8080/resourceServer1/token/fetch

Can be called directly(Here no authentication is needed):-
    http://localhost:8080/resourceServer1/users/permitMe


Stock Details Client through API GateWay:
    http://localhost:8080/stockServiceClient/userDetails
    http://localhost:8080/stockServiceClient/albums

The SPA Single page Web application is a code example that will read the properties abd
https://github.com/simplyi/spa-example/blob/main/src/main/resources/static/index.html