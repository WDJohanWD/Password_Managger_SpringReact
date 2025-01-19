function Login() {
    return(
        <div className="container mt-5">
            <h1 className="text-center">Login</h1>
            <form className="mt-4">
                <div className="form-group">
                    <input type="text" className="form-control" placeholder="Username" />
                </div>
                <div className="form-group mt-3">
                    <input type="password" className="form-control" placeholder="Password" />
                </div>
                <button type="submit" className="btn btn-primary mt-3">Login</button>
            </form>
        </div>
    )
}

export default Login;