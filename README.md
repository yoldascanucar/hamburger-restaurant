# Hamburger Restaurant Application


Welcome to the Hamburger Restaurant Application! This is a full-stack web application built using Spring Boot for the backend and Thymeleaf for the frontend. The application allows users to browse a menu of hamburgers, customize their orders with sauces, sides, and drinks, and complete the checkout process. It also includes user authentication, order management, and a responsive user interface.

## FEATURES

### User Authentication

- **Login/Registration**: Users can register and log in using their email and password. Passwords are securely hashed using BCrypt.

- **Session Management**: User sessions are managed using Spring Security, ensuring secure access to authenticated pages.

- **Custom Authentication**: The application uses a custom UserDetailsService to handle user authentication and authorization.

### Menu Browsing
- **Categories**: Users can browse hamburgers by categories (e.g., Classic, Spicy, Vegetarian).

- **Hamburger Details**: Each hamburger has a detailed page with its name, description, price, and image.

- **Customization**: Users can customize their hamburger orders by adding sauces, sides, and drinks.

### Order Management
- **Basket**: Users can add customized hamburgers to their basket and view the total price.

- **Checkout**: Users can proceed to checkout, where they enter their personal and payment details.

- **Order History**: Authenticated users can view their past orders.

### Admin Features
- **Order Management**: Admins can view and manage all orders placed by users.

- **Menu Management**: Admins can add, update, or remove hamburgers, sauces, sides, and drinks from the menu.

### Responsive Design
- The application is fully responsive, ensuring a seamless experience on both desktop and mobile devices.

## TECHNOLOGIES USED

### Backend
- **Spring Boot**: The core framework for building the application.

- **Spring Security**: Handles user authentication and authorization.

- **Spring Data JPA**: Manages database operations using Hibernate.

- **MySQL**: The relational database used to store application data.

- **Thymeleaf**: Server-side templating engine for rendering HTML pages.

### Frontend
- **HTML/CSS**: For structuring and styling the web pages.

- **Bootstrap**: For responsive design and pre-built UI components.

- **JavaScript**: For dynamic interactions on the frontend (e.g., updating the total price in the basket).

### Other Tools
- **Maven**: For dependency management and building the project.

- **Hibernate**: For ORM (Object-Relational Mapping) and database interactions.

- **BCrypt**: For securely hashing user passwords.


## INSTALLATION

### Prerequisites
- **Java JDK 21**: Ensure you have Java 21 installed.
- **MySQL**: Install and set up a MySQL database.
- **Maven**: Ensure Maven is installed for dependency management.

### Steps

#### Clone the Repository:

     git clone https://github.com/yoldascanucar/hamburger-restaurant.git
     cd hamburger-restaurant
     
#### Set Up the Database:

- Create a MySQL database named burger_restaurant and execute the SQL codes in the project
- Update the application.properties file with your MySQL credentials:

       spring.datasource.url=jdbc:mysql://localhost:3306/burger_restaurant
       spring.datasource.username=your-username
       spring.datasource.password=your-password

#### Run the Application

- Use Maven to build and run the application:

    mvn clean install
    mvn spring-boot:run

#### Access the Application

- Open your browser and navigate to
  
          http://localhost:8080/login



## PROJECT STRUCTURE


### Backend
- **Controllers**: Handle HTTP requests and responses.

- **Services**: Contain business logic and interact with repositories.

- **Repositories**: Interface with the database using Spring Data JPA.

- **Entities**: Represent the data models (e.g., Customer, Hamburger, Order).

- **Security**: Configuration for Spring Security, including custom authentication handlers.

### Frontend
- **HTML Templates**: Thymeleaf templates for rendering pages.

- **CSS**: Custom styles for the application.

- **JavaScript**: Dynamic interactions on the frontend.

### Database
- **MySQL**: Tables for customers, orders, hamburgers, sauces, sides, and drinks.
  


## LICENSE
This project is licensed under the MIT License.
