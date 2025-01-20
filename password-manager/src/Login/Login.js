import React, { useState } from "react";
import { useNavigate } from "react-router-dom"; // Asegúrate de importar useNavigate
import { login } from "./AuthService";

const Login = ({ onLoginSuccess }) => {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState("");
    const navigate = useNavigate(); // Hook de react-router-dom para redirigir

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            // Llamada al servicio de login
            await login(username, password);
            onLoginSuccess(); // Llama la función para actualizar el estado en App.js
            navigate("/password-manager"); // Redirige a PasswordManager al iniciar sesión exitosamente
        } catch (err) {
            // Extrae el mensaje de error del objeto
            const errorMessage =
                err.response?.data?.message || // Mensaje del backend
                err.message || // Mensaje general del error
                "An unexpected error occurred"; // Fallback por si no hay mensaje
            setError(errorMessage);
        }
    };

    return (
        <div className="container mt-5">
            <h1 className="text-center">Login</h1>
            <form className="mt-4" onSubmit={handleSubmit}> {/* Conecta handleSubmit */}
                <div className="form-group">
                    <input
                        type="text"
                        className="form-control"
                        placeholder="Username"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                    />
                </div>
                <div className="form-group mt-3">
                    <input
                        type="password"
                        className="form-control"
                        placeholder="Password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                    />
                </div>

                <button type="submit" className="btn btn-primary mt-3">
                    Login
                </button>
            </form>
            {/* Muestra solo el mensaje de error si existe */}
            {error && <p style={{ color: "red" }}>{error}</p>}
        </div>
    );
};

export default Login;
