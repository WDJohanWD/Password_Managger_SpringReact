const API_URL = "http://localhost:9000/api/auth";

// Función para login
async function loginUser(username, password) {
    const response = await fetch(`${API_URL}/login`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({ username, encryptedPassword: password }),
    });

    if (!response.ok) {
        throw new Error("Login failed: " + response.statusText);
    }

    return response.json(); // Devuelve la respuesta del backend
}

// Función para registro
async function registerUser(username, password) {
    const response = await fetch(`${API_URL}/register`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({ username, encryptedPassword: password }),
    });

    if (!response.ok) {
        throw new Error("Registration failed: " + response.statusText);
    }

    return response.json();
}

export { loginUser, registerUser };
