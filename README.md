in this link you can find the app arch: https://miro.com/app/board/uXjVPVAKHx8=/

Introduction With this document I attempt to present the project by presenting the technology, the architecture, and the logic used to develop this project.

Architecture In this project I used the MVVM architecture wishes it to be based on the principle of clean architecture.

Presentation layer : This layer has the responsibility to present the result to the user. this layer breaks down into two parts: view(fragment,Activity) : show the result presenter ( viewModel) : present the result

Uses cases layer : This layer has the responsibility to manager the complex task and the business rule of the project

Repository: This layer has the responsibility of the business logic of the project and the data management to ensure the validated data and the app work also in offline mode i implement the single source of truth design pattern

DTO Each layer have here owen data model

Tools : retrofit :to ensure the communication with server room : t create local data base hilt : dependency Injection Flow & channel : to transfer the data between different layer navigation component to ensure the navigation between fragments liveData to present the data from viewModel to the view

Dependency Injection to ensure the independence in the project i use the dependency injection design pattern by all the class have an implementation (interface) . i try to manage the dependency Injection by using the HILT library


