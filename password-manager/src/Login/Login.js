import React, { useState } from "react";
import { useNavigate } from "react-router-dom"; // Asegúrate de importar esto
import { loginUser } from "./api.js"; // Asegúrate de que la función esté correctamente importada
import 'bootstrap/dist/css/bootstrap.min.css';

function Login({ onLoginSuccess }) { // Recibe la función como prop
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState(null);
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();
    
        try {
            const result = await loginUser(username, password);
            console.log("Login successful", result);
            setError(null);

            onLoginSuccess(); // Actualiza el estado de autenticación
            navigate("/password-manager"); // Redirige al usuario
        } catch (err) {
            console.error(err.message);
            setError(err.message);
        }
    };

    return (
        <div className="container mt-5">
            <h1 className="text-center">Login</h1>
            {error && <p className="text-danger text-center">{error}</p>}
            <form onSubmit={handleSubmit} className="w-50 mx-auto">
                <div className="form-group">
                    <label htmlFor="username">Username</label>
                    <input
                        type="text"
                        className="form-control"
                        id="username"
                        placeholder="Enter username"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                    />
                </div>
                <div className="form-group">
                    <label htmlFor="password">Password</label>
                    <input
                        type="password"
                        className="form-control"
                        id="password"
                        placeholder="Enter password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                    />
                </div>
                <button type="submit" className="btn btn-primary btn-block mt-3">Login</button>
            </form>
        </div>
    );
}

export default Login;
