import { useState } from "react";
import Logo from "../components/Logo";
import "../styles/auth.css";

const SignUp = () => {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();

    // Store user details in localStorage after sign-up
    localStorage.setItem("firstName", firstName);
    localStorage.setItem("lastName", lastName);
    localStorage.setItem("username", username);
    localStorage.setItem("email", email);

    // Redirect to the Profile page after successful sign-up
    window.location.href = "/profile";
  };

  return (
    <div className="auth-page">
      <div className="auth-header">
        <Logo />
      </div>

      <div className="auth-card">
        <h2>Create your account</h2>
        <p>Start solving doubts smarter with DoubtConnect</p>

        <form className="auth-form" onSubmit={handleSubmit}>
          <input
            type="text"
            placeholder="First Name"
            value={firstName}
            onChange={(e) => setFirstName(e.target.value)}
          />
          <input
            type="text"
            placeholder="Last Name"
            value={lastName}
            onChange={(e) => setLastName(e.target.value)}
          />
          <input
            type="text"
            placeholder="Username"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
          />
          <input
            type="email"
            placeholder="Email address"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
          <input
            type="password"
            placeholder="Create password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
          <button type="submit">Sign Up</button>
        </form>

        <span className="auth-footer">
          Already have an account? <a href="/signin">Sign in</a>
        </span>
      </div>
    </div>
  );
};

export default SignUp;
