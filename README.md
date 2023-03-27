# blog-app-api
This is a Spring Boot application for a blog app that provides RESTful API endpoints for creating, reading, updating, and deleting blog posts.

## Technologies used
* Java 17
* Spring Boot
* Spring Data JPA
* MySQL
* Postman (API Testing)

## Installation
1. Clone the repository: ```git clone https://github.com/Susanta-Adak/blog-app-api.git```
2. Import the project into your IDE
3. Create a MySQL database named ```blogappdb```
4. Modify the ```application.properties``` file with your MySQL username and password

## Usage
1. Run the application from your IDE
2. The application will start on ```http://localhost:9090```
3. You can test the API endpoints using a tool like Postman

## API Documentation
The API includes the following endpoints:
### Authentication
* ```POST /api/user``` - Register a new user
* ```POST /api/user/login``` - Log in an existing user

### Blog Posts
* ```GET /api/posts?pageNumber=0&pageSize =5&sortBy=postId``` - Retrieve a list of all blog posts
* ```POST /api/user/:userId/category/:categoryId/post``` - Create a new blog post
* ```GET /api/user/:userId/posts``` - Retrieve a single blog post by ID
* ```PUT /api/posts/:id``` - Update a single blog post by ID
* ```DELETE /api/posts/:id``` - Delete a single blog post by ID

### Comments
* ```POST /api/post/:postId/user/:userId/comments``` - Create a new comment on a blog post
* ```DELETE /api/comments/:id``` - Delete a commat by ID

## Contributing
Contributions to this project are welcome! If you would like to contribute, please open a pull request. Before opening a pull request, please ensure that your code follows the existing code style and that all tests pass.
