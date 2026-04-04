
# MindTrack API

Backend API for the MindTrack application.

## Overview

MindTrack is a mental health and productivity tracking platform. This repository contains the backend services and API endpoints.

## Tech Stack

- React.js / Java 
- Framework: Spring Boot
- Database: PostgreSQL

## Getting Started

### Prerequisites

- Node.js v14+ (or your language/version)
- npm or yarn
- Java 17 and Spring Boot

### Installation

```bash
git clone https://github.com/bcl19/mindtrackapi
cd mindtrack-front
npm install
```

### Configuration

Create a `.env` file in the root directory:

```env
PORT=3000
DATABASE_URL=your_database_url
```

### Running the Server

```bash
npm start
```

## API Endpoints

- `GET /api/health` - Health check
- `POST /api/auth/login` - User authentication
- [Add your endpoints]

## Related Repositories

- [mindtrack-front](https://github.com/bcl19/mindtrack-front) - Frontend application
- [mindtrack-back](https://github.com/bcl19/mindtrackapi) - BackEnd Application

## License

MIT
