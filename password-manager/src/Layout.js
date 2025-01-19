import { Outlet } from "react-router-dom";

const Layout = () => {
  return (
    <>
      <main>
        <Outlet /> {/* Renderiza las rutas hijas aquí */}
      </main>
    </>
  );
};

export default Layout;