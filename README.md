# Cine-World Ticket App Back End Code
<img width="749" alt="Screenshot 2023-12-11 at 14 30 24" src="https://github.com/oguzzhanturkmen/cine-world-ticket-app-be-spring/assets/111460897/133a4db8-27b1-44b1-8a4d-780566cac733">


## Introduction
This repository contains the backend code for the Cinema Reservation System, a Java Spring Boot application that handles the management of cinema operations including movie listings, showtimes, seat reservations, and payment processing.
React native repo is here --> https://github.com/oguzzhanturkmen/cineworld-ticket-app-react-native

## Entity-Relationship Diagram
![Entity-Relationship Diagram](/path/to/your/erd/image.png)
*Note: Replace the above path with the actual path to the ERD image in your repository.*

## Database Schema
The backend is structured around several key entities:
- `theaters`: Information about cinema locations and their screens.
- `movies`: Details of movies that can be booked.
- `showtimes`: Scheduled times for movie screenings.
- `seats`: Seating information for each screen.
- `users`: User accounts for those booking tickets.
- `bookings`: Records of user bookings.
- `payment_details`: Secure storage of payment information.
- `seat_reservations`: Links seats, showtimes, and bookings to track reservations.

Each entity is represented as a table within the database, with relationships that reflect the real-world interactions between them.

## Technologies Used
- **Java Spring Boot**: For robust backend functionality.
- **Hibernate**: Object-relational mapping for database interaction.
- **PostgreSQL**: The primary database system.
- **Maven**: Dependency management and build automation.
