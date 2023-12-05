# Quiz Application 

Developed a dynamic web-based quiz application that allows users to select their preferred programming language (Java, Python, C++) and generates customized questions for interactive self-assessment.

## Overview
This is a Quiz Application built using Java, Spring Boot, and MySQL. The application allows an admin to create quizzes, and users can choose quizzes based on categories like Java, Python, and C++. Users will select answers to the quiz questions, and the application will provide a score after finishing the quiz.

## Features
- User Registration: Users can create accounts to access the quiz application.
- Admin Role: Admins can create and manage quizzes.
- User Role: Regular users can select quizzes and answer questions.
- Quiz Categories: Quizzes are categorized by programming languages (e.g., Java, Python, C++).
- Scoring: Users receive a score upon completing a quiz.
- Database Storage: Quiz questions and user data are stored in a MySQL database.
- REST API: The application provides a RESTful API for interactions.

## Technologies Used
- Java
- Spring Boot
- MySQL
- REST API

## Setup

### Prerequisites
- Java Development Kit (JDK)
- MySQL Database
- Maven

### Configuration
1. Clone the repository to your local machine.
2. Create a MySQL database and update the database configuration in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/quiz_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```
3. Build the project using Maven:
   ```bash
   mvn clean install
   ```
4. Run the application:
   ```bash
   java -jar target/quiz-application.jar
   ```
   You can also run it using an integrated development environment (IDE) like IntelliJ IDEA or Eclipse.

## Usage

### Admin Functions
1. Access the admin dashboard at `http://localhost:8080/admin` (or your server's URL).
2. Log in as an admin with the provided credentials.
3. Create quizzes and add questions to them.

### User Functions
1. Access the user dashboard at `http://localhost:8080/user` (or your server's URL).
2. Log in as a regular user or register for a new account.
3. Choose a quiz category (e.g., Java, Python, C++) and start the quiz.
4. Select answers to quiz questions.
5. Receive your score upon completing the quiz.

## API Endpoints
- `/api/quizzes` (GET): Retrieve a list of available quizzes.
- `/api/quizzes/{quizId}` (GET): Retrieve details of a specific quiz.
- `/api/quizzes/{quizId}/start` (POST): Start a quiz.
- `/api/quizzes/{quizId}/submit` (POST): Submit answers for a quiz and get the score.

## Database Schema
The application uses a MySQL database with the following tables:
- `users`: Store user information.
- `roles`: Define user roles (admin and user).
- `categories`: Store quiz categories (e.g., Java, Python, C++).
- `quizzes`: Store information about quizzes.
- `questions`: Store questions related to quizzes.
- `options`: Store answer options for each question.
- `user_answers`: Record user responses to quiz questions.

## Contributing
We welcome contributions to this Quiz Application project. If you have ideas, feature requests, or bug reports, please open issues and submit pull requests on GitHub.


## Contact
For questions or inquiries, please contact me at [saurabhsalvi20@gmail.com].

Thank you for using the Quiz Application! We hope you find it enjoyable.
