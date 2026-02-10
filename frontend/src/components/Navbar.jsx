import Logo from "./Logo";
import "../styles/navbar.css";

const Navbar = () => {
  return (
    <nav className="navbar">
      <Logo />
      <button
        className="auth-btn"
        onClick={() => {
          window.location.href = "/signin";
        }}
      >
        Sign In / Sign Up
      </button>
    </nav>
  );
};

export default Navbar;
