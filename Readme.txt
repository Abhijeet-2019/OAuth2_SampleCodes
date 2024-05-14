This application is a Demo project that uses OAuth spring security.
The Authentication Server used is Key Cloak.
Installation Process of Key Cloak:
--------------------------------

Base Url for Okta Server : http://localhost:8180/

The Rest end points OF AUTHENTICATION RESOURCE SERVER1 End Point

The Rest URL to fetch the authentication code for KeyCloak server
        http://localhost:8180/realms/appDeveloper/protocol/openid-connect/auth?client_id=keyCloack&response_type=code&scope=openid profile&redirect_uri=http://localhost:8089/callback&state=test
The REST POST Request to get the access token:
        http://localhost:8180/realms/appDeveloper/protocol/openid-connect/token
POST---Add the following in the body :
    grant_type - authorization_code
    client_id  - keyCloack
    client_secret - WpY844VAVYeHGSuw4B04gfYAam9d5WxY
    code -
    redirect_uri - http://localhost:8089/callback
    state - test

Should be called using OAuth2 authentication:

Rest End points Calls with Admin Role:-
    http://localhost:8080/resourceServer1/admin/addUser
    http://localhost:8080/resourceServer1/admin/deleteUsers

Rest End points call with appDeveloper Role:-
    http://localhost:8080/resourceServer1/users/status/check
    http://localhost:8080/resourceServer1/users/connect
    http://localhost:8080/resourceServer1/token/fetch

Can be called directly(Here no authentication is needed):-
    http://localhost:8080/resourceServer1/users/permitMe

Stock Details Service:
    http://localhost:8080/stockDetails/stocks/fetchById
    http://localhost:8080/stockDetails/stocks/fetchAll

Stock Details Client:
    api link --http://localhost:8080/stockServiceClient/stockClient/fetchAll

    http://localhost:8083/stockServiceClient/albums
