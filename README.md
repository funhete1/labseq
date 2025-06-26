## Project Overview

This project provides a REST service that calculates values from the Labseq sequence, designed for efficiency and concurrency handling. It features a backend implemented with Quarkus (Java) and a frontend built with Angular, offering a portable and accessible solution for exploring the sequence.

## Description of the Labseq Sequence

The Labseq sequence is defined by the following recursive algorithm:

* $l(0) = 0$

* $l(1) = 1$

* $l(2) = 0$

* $l(3) = 1$

* For $n > 3$: $l(n) = l(n-4) + l(n-3)$

This service allows users to efficiently retrieve Labseq values for various inputs.

## Technical Implementation

The project adopts a decoupled backend-frontend architecture:

* **Backend:** Developed using the **Quarkus** framework (Java), providing a lightweight and high-performance REST API.

* **Frontend:** Built with **Angular**, offering a responsive and interactive user interface for accessing the service.

## Problem Resolution & Efficiency

To ensure maximum efficiency and handle concurrent requests, the Labseq calculation method incorporates:

* **Caching Mechanism:** A cache structure is implemented to store previously computed Labseq values. This prevents redundant calculations for already determined numbers, significantly improving performance for repeated requests. The algorithm intelligently computes only values greater than the currently cached maximum.

* **Concurrency Control:** In scenarios where multiple concurrent calls request values greater than the current maximum computed value, a mutex (lock variable) is utilized in the critical section of the algorithm. This prevents race conditions and ensures data integrity during simultaneous computations.


## Getting Started

These instructions will get you a copy of the project up and running on your local machine.

### Dependencies

To run this project, you will need:

* **Docker & Docker Compose** (Recommended for easiest setup)

* **(Optional for Manual Builds):**

  * Java Development Kit (JDK) 17+

  * Apache Maven

  * Node.js

  * Angular CLI

### Installation

For Docker installation, please visit the official Docker documentation:
<https://docs.docker.com/engine/install/>
Follow the instructions to install the appropriate version for your operating system.

### Executing the Program

You have two primary options to run the application:

#### Option 1: Using Docker (Recommended)

1. Clone the repository to your local machine.

2. Navigate to the root directory of the cloned repository in your terminal.

3. Run the following command to build and start the services:
```
\docker compose up --build
```
#### Option 2: Manual Build and Run

1. Clone the repository to your local machine.

2. **Start the Backend:**

* Navigate into the `backend` folder.

* Execute the Quarkus development mode command:

  ```
  ./mvnw compile quarkus:dev
  
  ```

3. **Start the Frontend:**

* Navigate into the `frontend` folder.

* Run the Angular development server:

  ```
  ng serve
  
  ```
* Access the frontend
  ```
  http://localhost:4200/
  ```


## API Documentation

Once the backend service is running, the API endpoints are fully documented using Swagger UI. You can access the documentation in your web browser at:
  ```
  <http://localhost:8080/swagger-ui/>
  ```

## License

This project is open-source and available under the [MIT License](https://opensource.org/licenses/MIT).
