# Cinema Ticket Booking Service

RESTful microservice for a cinema chain — managing movies, showtimes, halls and ticket reservations.

## Features

- **Movie Catalog** — CRUD operations, filter by genre
- **Cinema Halls** — Multiple halls with configurable seating layouts
- **Showtimes** — Schedule movies to halls with pricing
- **Ticket Booking** — Reserve specific seats with double-booking prevention via unique constraint
- **Ticket Cancellation** — Cancel reservations with status tracking (RESERVED → CONFIRMED → CANCELLED)
- **Role-Based Access** — Admin and User roles with Spring Security
- **Liquibase Migrations** — Version-controlled database schema evolution
- **Email Notifications** — Booking confirmations via Spring Mail

## Tech Stack

| Layer | Technology |
|-------|-----------|
| Language | Java 17 |
| Framework | Spring Boot 3.2 |
| Security | Spring Security |
| Database | PostgreSQL 16 |
| ORM | Spring Data JPA / Hibernate |
| Migrations | Liquibase |
| Mapping | MapStruct |
| Build | Maven |
| Containerization | Docker + Docker Compose |

## Project Structure

```
src/main/java/com/daniilmedvediev/cinematicketbooking/
├── config/          # Security configuration
├── controller/      # REST endpoints
├── dto/             # Data transfer objects
├── exception/       # Custom exceptions
├── mapper/          # MapStruct mappers
├── model/           # JPA entities (Movie, CinemaHall, Showtime, Ticket, User)
├── repository/      # Spring Data repositories
└── service/         # Business logic with seat-locking
```

## Getting Started

```bash
docker-compose up --build
```

API available at `http://localhost:8081`

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/movies` | List all movies |
| GET | `/api/movies/genre?genre=Action` | Filter by genre |
| POST | `/api/movies` | Add movie (Admin) |
| POST | `/api/tickets` | Book a seat |
| PUT | `/api/tickets/{id}/cancel` | Cancel booking |
| GET | `/api/tickets/showtime/{id}` | View booked seats |
