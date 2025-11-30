---

# 🥘 TheMealDB Explorer

A full-stack application built with **Spring Boot (Java), HTML, CSS, and Vanilla JavaScript** that fetches and displays recipes from **TheMealDB API** through a custom backend service layer.

This project implements a complete **Web Service API + UI Layer** with caching, REST architecture, and recipe browsing features.

---

## 🚀 Project Overview

**TheMealDB Explorer** is a locally running full-stack app that allows users to:

* Search meals by name
* View random meals
* Browse meal details (instructions, image, YouTube video)
* Fetch and display meal categories
* Navigate through an interactive and responsive frontend

A custom backend layer is implemented to:

* Interact with TheMealDB API
* Provide simplified REST endpoints
* Cache results using Spring Boot caching
* Serve a clean interface for the UI

---

# 📌 Features

### ✅ Backend (Spring Boot)

* RESTful API design
* Fetches data from **TheMealDB API** using test key: `https://www.themealdb.com/api/json/v1/1/`
* Endpoints include:

  * `GET /api/meals/search?name=`
  * `GET /api/meals/{id}`
  * `GET /api/meals/random`
* In-memory caching using Spring's caching abstraction
* Auto-expiring cache entries (configurable)
* Proper service and controller structure
* Clean code & extendable architecture

---

### 🎨 Frontend (HTML + CSS + JavaScript)

* Modern UI built with:

  * Bootstrap 5
  * Custom CSS
  * Vanilla JavaScript
* Recipe search bar
* Category dropdown
* Random Meal (“I'm Feeling Hungry”) button
* Pop-up modal showing:

  * Meal image
  * Instructions
  * Ingredients
  * YouTube tutorial
* Fully responsive layout (desktop + mobile)

---

# 📁 Project Structure

```
MealDBExplorer/
│
├── src/
│   ├── main/java/com/example/MealDBExplorer/
│   │   ├── controller/         # REST API controllers
│   │   ├── service/            # Service layer + caching
│   │   ├── client/             # External API client (TheMealDB)
│   │   ├── model/              # Meal DTO models
│   │   ├── config/             # CORS + Cache config
│   │   └── MealDbExplorerApplication.java
│   │
│   └── resources/
│       ├── static/             # Static frontend files
│       │   ├── index.html
│       │   ├── script.js
│       │   └── style.css
│       └── application.properties
│
├── pom.xml
└── README.md
```

---

# ⚙️ Installation & Setup

## 1️⃣ Prerequisites

* Java 17+
* Maven
* Any browser

---

## 2️⃣ Clone the Repository

```bash
git clone https://github.com/yourusername/MealDBExplorer.git
cd MealDBExplorer
```

---

## 3️⃣ Run the Backend

```bash
mvn spring-boot:run
```

Backend runs at:

```
http://localhost:8080
```

---

## 4️⃣ Run the Frontend

Simply open:

```
src/main/resources/static/index.html
```

Or use Live Server (VS Code) for auto refresh.

---

# 🧪 REST API Documentation

## 🔍 Search meals

```
GET /api/meals/search?name=chicken
```

## 🥘 Get a meal by ID

```
GET /api/meals/{id}
```

## 🎲 Random meal

```
GET /api/meals/random
```

## 🗂️ List categories

```
GET /api/meals/categories
```

---

# ⚡ Caching

This project uses **Spring Cache** (Simple in-memory cache) with:

* Global cache enabled via `@EnableCaching`
* Method-level caching via `@Cacheable`
* Cache names:

  * `searchMeals`
  * `mealById`
  * `randomMeal`
  * `categories`

Cached entries improve performance and reduce API calls.

---

# 🧩 Technologies Used

| Layer        | Technology                                  |
| ------------ | ------------------------------------------- |
| Backend      | Java 17, Spring Boot, RestTemplate, Caching |
| Frontend     | HTML5, CSS3, JavaScript                     |
| UI Framework | Bootstrap 5                                 |
| API Source   | TheMealDB API                               |
| Build Tool   | Maven                                       |

---

# 🌟 Screenshots (optional)

You may add:

* Home page
* Search results
* Recipe details modal

---

# 📚 Future Improvements

* Add favorite meals storage
* Convert frontend to React or Angular
* Use Redis Cache instead of simple cache
* Add pagination for search results
* Add area filter (Italian, Mexican, etc.)

---

# 📝 Submission Checklist (as per assignment)

✔ Web service implemented
✔ Caching implemented
✔ RESTful endpoints
✔ Local execution works
✔ UI implemented (search, random, categories, details)
✔ Uses TheMealDB test key
✔ Code quality: Good separation of layers
✔ Sends simplified API to frontend
✔ Ready for GitHub submission

---

# 📬 Contact / Developer

**Gaurav Chandrakant Patil**
Full Stack Developer

---
