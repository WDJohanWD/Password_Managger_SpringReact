import { createBrowserRouter } from "react-router-dom";
import App from "./App.js";
import Layout from "./Layout.js";
import Login from "./Login.js";
import Register from "./Register.js";

// Definir tus rutas
const router = createBrowserRouter([
  {
    path: "/",
    element: <Layout />,  // Usa Layout como el contenedor principal
    children: [
      { path: "/", element: <App /> },
      { path: "/login", element: <Login /> },
      { path: "/register", element: <Register /> },
    ],
  },
]);

export default router;  // Exporta el router para usarlo en index.js
