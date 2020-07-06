# SpringBoot_App
SpringBoot App for Refinitiv Test

This is my project for Refinitiv Test, showing my skills to develop a SpringBoot App
<h2>Task</h2>
Write a spring-boot application with a REST controller, which expose a Swagger API catalog.
The application needs to expose the following APIs:

- User List (UserId, Name, AccountsList)
- Account List (AccountId, AccountName, AccauntCurrency )
- Read item details (by item number)
- Add Account to User
- Delete an Account from UserAccountsList
- Data should be persisted on H2 DB using JPA.
- Need to pack and run the application from docker.
- Need to send a link to GitHub for source and docker hub for docker image

<h2>Preparation</h2>

[Click Here](https://hub.docker.com/r/cravecra/springboot_app) for docker repo
or just go to command line and use this code to download the image
```cmd
docker pull cravecra/springboot_app
```
Run the app
```cmd
docker run --name "SpringBoot-AppByRodrigo" -p 8080:8080 cravecra/springboot_app
```
```cmd
8080:800 refers to yourPersonalPort:DockerPublicPort
yourPersonalPort feel free to choose your own
DockerPublicPort always is 8080
```

<h2>Let's Explore</h2>
Go to localhost:8080 or yourPersonalPort
