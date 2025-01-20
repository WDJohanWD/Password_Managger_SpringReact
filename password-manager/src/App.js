import React, { useState } from "react";
import { RouterProvider } from "react-router-dom";
import router from "./Router"; // Importa el archivo del router

function App() {
  const [isAuthenticated, setIsAuthenticated] = useState(false);

  const handleLoginSuccess = () => {
    setIsAuthenticated(true);
  };

  return (
    <div>
      <RouterProvider router={router(handleLoginSuccess, isAuthenticated)} />
    </div>
  );
}

export default App;
