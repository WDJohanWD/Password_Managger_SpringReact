import 'bootstrap/dist/css/bootstrap.min.css';
import { Link } from 'react-router-dom';

function Home() {
  return (
    <div className="container text-center mt-5">
      <p className="h4 mb-4">Welcome to the password manager!</p>
      
      <div className="d-grid gap-2 d-md-block">
         <button className="btn btn-primary me-2"><Link to="/login" className='text-white'>Login</Link></button>
        <button className="btn btn-secondary " disabled><Link to="/register" className='text-white'>Register</Link></button>
      </div>
    </div>
  );
}

export default Home;
