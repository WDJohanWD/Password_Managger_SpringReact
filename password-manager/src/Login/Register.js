import React, { useState } from "react";
import { useNavigate } from "react-router-dom"; // Importar useNavigate
import { registerUser } from "./api";
import 'bootstrap/dist/css/bootstrap.min.css';

function Register() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [message, setMessage] = useState("");
    const navigate = useNavigate(); // Hook para redirección

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            await registerUser(username, password);
            setMessage("User registered successfully!");
            navigate("/login"); // Redirigir a login después del registro
        } catch (err) {
            setMessage("Error: " + err.message);
        }
    };

    return (
        <div className="container mt-5">
            <h1 className="text-center">Register</h1>
            {message && <p className="text-center">{message}</p>}
            <form onSubmit={handleSubmit} className="w-50 mx-auto">
                <div className="form-group">
                    <input
                        type="text"
                        className="form-control"
                        placeholder="Username"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                    />
                </div> <br/>
                <div className="form-group">
                    <input
                        type="password"
                        className="form-control"
                        placeholder="Password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                    />
                </div><br/>
                <button type="submit" className="btn btn-primary btn-block">Register</button>
            </form>
        </div>
    );
}

export default Register;
