import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import './index.css';
import { RouterProvider } from 'react-router-dom';  // Importa RouterProvider
import router from './Router'; // Importa el router que has definido

createRoot(document.getElementById("root")).render(
  <StrictMode>
    <RouterProvider router={router} />  {/* Solo utiliza RouterProvider */}
  </StrictMode>
);
