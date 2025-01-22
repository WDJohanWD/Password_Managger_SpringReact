import Login from "./Login/Login";

import React from "react";
import { createBrowserRouter, Navigate } from "react-router-dom";
import Home from "./Home";
import PasswordManager from "./PasswordManager";
import Register from "./Login/Register";

// Componente para proteger rutas
const ProtectedRoute = ({ isAuthenticated, children }) => {
  return isAuthenticated ? children : <Navigate to="/login" />;
};

const router = (handleLoginSuccess, isAuthenticated) =>
  createBrowserRouter([
    {
      path: "/",
      element: <Home />, // Ruta pública
    },
    {
      path: "/login",
      element: <Login onLoginSuccess={handleLoginSuccess} />, // Ruta pública
    },
    {
      path: "/register",
      element: <Register />, // Ruta pública
    },
    {
      path: "/password-manager",
      element: (
        <ProtectedRoute isAuthenticated={isAuthenticated}>
          <PasswordManager />
        </ProtectedRoute>
      ),
    },
  ]);

export default router;
