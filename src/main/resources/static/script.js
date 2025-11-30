const API_BASE = "http://localhost:8080/api/meals";

// DOM Elements
const searchInput = document.getElementById("searchInput");
const searchBtn = document.getElementById("searchBtn");
const randomBtn = document.getElementById("randomBtn");
const mealResults = document.getElementById("mealResults");
const mealModalBody = document.getElementById("mealModalBody");

// Search Meals
searchBtn.addEventListener("click", () => {
    const query = searchInput.value.trim();
    if (query !== "") {
        fetchMeals(query);
    }
});

searchInput.addEventListener("keypress", (e) => {
    if (e.key === "Enter") searchBtn.click();
});

// Random Meal
randomBtn.addEventListener("click", fetchRandomMeal);

async function fetchMeals(query) {
    mealResults.innerHTML = `<h4 class="text-center mt-4 text-secondary">Searching…</h4>`;

    try {
        const res = await fetch(`${API_BASE}/search?q=${query}`);
        const data = await res.json();

        if (!data || data.length === 0) {
            mealResults.innerHTML = `<h4 class="text-center text-danger mt-4">No meals found</h4>`;
            return;
        }

        displayMeals(data);

    } catch (err) {
        mealResults.innerHTML = `<h4 class="text-center text-danger">Error fetching meals</h4>`;
    }
}

// Display meal cards
function displayMeals(meals) {
    mealResults.innerHTML = "";

    meals.forEach(meal => {
        const card = `
        <div class="col-md-4 col-sm-6 mb-4">
            <div class="card shadow-sm border-0 h-100">
                <img src="${meal.strMealThumb}" class="card-img-top" style="height: 220px; object-fit: cover;">
                <div class="card-body">
                    <h5 class="card-title">${meal.strMeal}</h5>
                    <p class="text-muted mb-1">Category: ${meal.strCategory}</p>
                    <p class="text-muted">Area: ${meal.strArea}</p>
                    <button class="btn btn-primary w-100" onclick="showMealDetails('${meal.idMeal}')">
                        View Details
                    </button>
                </div>
            </div>
        </div>`;
        mealResults.innerHTML += card;
    });
}

// Fetch single meal details
async function showMealDetails(id) {
    try {
        const res = await fetch(`${API_BASE}/${id}`);
        const meal = await res.json();

        mealModalBody.innerHTML = `
            <div class="text-center">
                <img src="${meal.strMealThumb}" class="img-fluid rounded mb-3 shadow" style="max-height: 300px;">
                <h3 class="fw-bold">${meal.strMeal}</h3>
                <p class="text-muted">${meal.strCategory} • ${meal.strArea}</p>
            </div>

            <h5 class="mt-4">Instructions</h5>
            <p>${meal.strInstructions}</p>

            <h5 class="mt-4">YouTube Tutorial</h5>
            <a href="${meal.strYoutube}" target="_blank" class="btn btn-danger">
                <i class="fa-brands fa-youtube"></i> Watch Video
            </a>
        `;

        new bootstrap.Modal(document.getElementById("mealModal")).show();

    } catch {
        alert("Error loading meal details.");
    }
}

// Fetch random meal
async function fetchRandomMeal() {
    try {
        const res = await fetch(`${API_BASE}/random`);
        const meal = await res.json();
        displayMeals([meal]);
    } catch {
        alert("Unable to fetch random meal.");
    }
}
