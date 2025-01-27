import React, { useState } from "react";
import { RouterProvider } from "react-router-dom";
import router from "./Router";

function App() {
  const [isAuthenticated, setIsAuthenticated] = useState(false);

  const handleLoginSuccess = () => {
    setIsAuthenticated(true); // Actualiza el estado al autenticarte
  };

  return (
    <div>
      <RouterProvider router={router(handleLoginSuccess, isAuthenticated)} />
    </div>
  );
}

export default App;
