import React from "react";
import { Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";

function Home() {
  return (
    <div className="container text-center mt-5">
      <p className="h4 mb-4">Welcome to the password manager!</p>
      <div className="d-grid gap-2 d-md-block">
        <Link to="/login" className="btn btn-primary me-2">
          Login
        </Link>
        <Link to="/register" className="btn btn-secondary" disabled>
          Register
        </Link>
      </div>
    </div>
  );
}

export default Home;
