# AniVerse

AniVerse is a full-stack anime discovery and tracking platform inspired by applications such as MyAnimeList, AniList, Letterboxd, and Backloggd. The project is being built from scratch with a focus on **backend engineering, REST API design, authentication, relational data modeling, caching, and scalable application architecture**.

Users will be able to browse and search for anime, filter titles by various attributes, view detailed anime information, rate titles, and maintain their own personalized anime library through an authenticated account.

> 🚧 **Status:** In Development

---

## Features

### Currently Implemented

* Angular frontend application
* Spring Boot backend foundation
* Client-side routing
* Responsive application layout
* Reusable anime UI components
* Anime browsing interface
* Anime search/filtering foundation
* User authentication foundation

### Planned

* User registration and login
* User profiles
* Anime ratings and reviews
* Personal anime library
* Advanced anime search and filtering
* Anime detail pages
* User watchlists and viewing progress
* Backend caching for frequently requested anime data
* PostgreSQL relational database
* RESTful API architecture
* Automated backend testing
* Performance and load testing
* Production deployment

---

## Tech Stack

### Frontend

* **Angular**
* **TypeScript**
* **SCSS**
* **Tailwind CSS**

### Backend

* **Java**
* **Spring Boot**
* **Spring Web**
* **Spring Security**
* **REST APIs**

### Database

* **PostgreSQL**

### External Data

AniVerse uses an external anime data API as the source for anime metadata rather than maintaining an anime catalog entirely from scratch.

The backend is designed to act as an intermediary between the frontend, external anime services, and the application's own database.

---

## Architecture

AniVerse follows a full-stack architecture:

```text
┌──────────────────────┐
│      Angular UI      │
│                      │
│ Search / Browse      │
│ Anime Details        │
│ User Interface       │
└──────────┬───────────┘
           │
           │ HTTP / REST
           ▼
┌──────────────────────┐
│    Spring Boot API   │
│                      │
│ Controllers          │
│ Services             │
│ Authentication       │
│ Business Logic       │
└──────────┬───────────┘
           │
      ┌────┴─────┐
      │          │
      ▼          ▼
┌──────────┐ ┌──────────────┐
│PostgreSQL│ │ Anime API    │
│ Database │ │ External Data│
└──────────┘ └──────────────┘
```

Caching will be introduced between the application and external anime API to reduce unnecessary requests and improve response times for frequently accessed data.

---

## Project Goals

AniVerse is being developed not only as an anime platform, but also as a software engineering project focused on building a production-style full-stack application.

The primary goals are:

* Design and implement a **RESTful backend**
* Build secure **user authentication and authorization**
* Model relationships using a **relational database**
* Integrate and normalize data from an **external API**
* Implement **caching strategies** for frequently accessed data
* Write automated tests for critical application logic
* Measure application performance under simulated traffic
* Identify and optimize backend bottlenecks
* Deploy the application as a complete full-stack system

---

## Development Roadmap

### Phase 1 — Frontend Foundation

* [x] Initialize Angular application
* [x] Configure routing
* [x] Create homepage
* [x] Create reusable anime card component
* [x] Create browse page foundation
* [ ] Complete responsive UI

### Phase 2 — Authentication

* [ ] User registration
* [ ] User login
* [ ] Password security
* [ ] Authentication tokens/session management
* [ ] Protected API endpoints
* [ ] User profile

### Phase 3 — Anime Backend

* [ ] Integrate external anime API
* [ ] Create anime REST endpoints
* [ ] Create PostgreSQL schema
* [ ] Implement anime persistence
* [ ] Implement search
* [ ] Implement filtering
* [ ] Implement anime relationships

### Phase 4 — User Features

* [ ] Anime ratings
* [ ] Reviews
* [ ] Watchlist
* [ ] Personal anime library
* [ ] Viewing status
* [ ] User-specific recommendations

### Phase 5 — Performance

* [ ] Implement caching
* [ ] Database query optimization
* [ ] API response optimization
* [ ] Load testing
* [ ] Establish performance benchmarks
* [ ] Optimize identified bottlenecks

### Phase 6 — Deployment

* [ ] Production configuration
* [ ] Deploy frontend
* [ ] Deploy backend
* [ ] Deploy PostgreSQL database
* [ ] Configure environment variables
* [ ] CI/CD pipeline
* [ ] Production monitoring

---

## Performance Engineering

Performance will be treated as a measurable part of the project rather than an afterthought.

Planned measurements include:

* API response latency
* Database query performance
* Cache hit/miss rates
* Requests per second
* Concurrent users
* Error rates
* Frontend load performance
* Backend resource utilization

Load-testing tools will be used to simulate concurrent users and identify bottlenecks within the application.

Performance improvements will be documented using before-and-after measurements where possible.

---

## Testing

AniVerse will use automated testing throughout development.

Planned testing areas include:

* Unit tests
* Service-layer tests
* Controller/API tests
* Authentication tests
* Database integration tests
* API integration tests
* Load/performance testing

---

## Project Structure

The repository is organized into separate frontend and backend applications:

```text
AniVerse/
│
├── frontend/
│   └── Angular application
│
├── backend/
│   └── Spring Boot application
│
├── README.md
└── .gitignore
```

The exact structure will evolve as additional backend services and features are implemented.

---

## Running Locally

### Prerequisites

Make sure the following are installed:

* Node.js
* npm
* Java JDK
* PostgreSQL
* Git

### Clone the Repository

```bash
git clone <repository-url>
cd AniVerse
```

### Frontend

```bash
cd frontend
npm install
npm start
```

The Angular development server will run locally.

### Backend

From the backend directory, run the Spring Boot application using your preferred IDE or Maven/Gradle configuration.

> Environment variables and database configuration will be documented as the backend reaches its production-ready configuration.

---

## Future Improvements

As AniVerse develops, additional engineering improvements may include:

* Redis-based distributed caching
* Pagination and lazy loading
* Database indexing
* API rate-limit handling
* Background jobs for anime data synchronization
* Recommendation algorithms
* Observability and logging
* Containerization with Docker
* CI/CD automation
* Horizontal scaling

---

## Why I Built AniVerse

AniVerse was created to combine a personal interest in anime with practical software engineering.

Rather than building only a frontend application, the project focuses on understanding how a complete application works from end to end—from the user interface and HTTP requests to authentication, business logic, database relationships, external API integration, caching, testing, and performance optimization.

The long-term goal is to turn AniVerse into a polished anime tracking platform while using the project as a hands-on exploration of **full-stack and backend software engineering**.

---

## Status

**AniVerse is currently under active development.**

Features, architecture, and technologies may change as the project progresses.
