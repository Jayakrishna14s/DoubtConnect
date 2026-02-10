import Logo from "../components/Logo";
import "../styles/auth.css";

const SignIn = () => {
  const handleSubmit = (e) => {
    e.preventDefault();

    const email = e.target.email.value;

    // Store email (username already exists if signed up earlier)
    localStorage.setItem("email", email);

    // ✅ Redirect to DASHBOARD
    window.location.href = "/dashboard";
  };

  return (
    <div className="auth-page">
      <div className="auth-header">
        <Logo />
      </div>

      <div className="auth-card">
        <h2>Welcome back</h2>
        <p>Sign in to continue to DoubtConnect</p>

        <form className="auth-form" onSubmit={handleSubmit}>
          <input type="email" name="email" placeholder="Email address" required />
          <input type="password" placeholder="Password" required />

          <button type="submit">Sign In</button>
        </form>

        <span className="auth-footer">
          New to DoubtConnect? <a href="/signup">Create an account</a>
        </span>
      </div>
    </div>
  );
};

export default SignIn;
