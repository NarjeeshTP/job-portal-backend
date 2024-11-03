# Job Portal Backend

A simple job portal backend built using **Spring Boot** and **MongoDB Atlas**. This project allows users to create, list, update, and search for jobs. It demonstrates the use of **MongoDB Atlas Search** for efficient and scalable search functionality.

## Features

- Create, list, update, and delete job postings.
- Full-text search with MongoDB Atlas for finding jobs by keywords.
- RESTful API implementation with Spring Boot.

## Prerequisites

To run this project, you need to have:

1. **Java 11** or higher installed.
2. **Maven** (for managing dependencies and building the project).
3. **MongoDB Atlas account** with a database and search index set up (see setup instructions below).

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/NarjeeshTP/job-portal-backend.git
cd job-portal-backend
```

### 2. Set Up MongoDB Atlas

1. Create a MongoDB Atlas account at [MongoDB Atlas](https://www.mongodb.com/cloud/atlas).
2. Create a new database cluster and note the connection string (e.g., `mongodb+srv://<username>:<password>@cluster.mongodb.net/<dbname>`).
3. Create a **Search Index** on your `jobs` collection in MongoDB Atlas for full-text search.
4. Update the `application.properties` file with your MongoDB connection details.

```properties
# application.properties
spring.data.mongodb.uri=mongodb+srv://<username>:<password>@cluster.mongodb.net/<dbname>?retryWrites=true&w=majority
```

### 3. Build and Run the Project

Use Maven to install dependencies and run the project:

```bash
mvn spring-boot:run
```

The backend API will be available at `http://localhost:8080/api/jobs`.

### 4. Test the API

You can test the API using Postman or any other API client. Here are some endpoints:

- **Create a Job**: `POST /api/jobs` (send job details in JSON format)
- **Get All Jobs**: `GET /api/jobs`
- **Search for Jobs**: `GET /api/jobs/search?query=developer`
- **Get a Job by ID**: `GET /api/jobs/{id}`
- **Update a Job**: `PUT /api/jobs/{id}`
- **Delete a Job**: `DELETE /api/jobs/{id}`

### 5. Project Structure

This project has a simple structure:

- **Controller**: `JobController` contains the REST API endpoints.
- **Model**: `Job` is the data model representing job postings.
- **Repository**: `JobRepository` handles database operations and MongoDB Atlas Search.

### 6. Contributing

Feel free to fork this repository and submit pull requests for any improvements or features.

## Future Development Ideas

- Add user authentication and authorization.
- Expand search functionality to allow filtering by location, salary, etc.
- Create a front-end for interacting with this API.

## License

This project is open-source and available under the MIT License.

