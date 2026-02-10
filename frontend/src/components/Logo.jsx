import { useState } from "react";
import { Link } from "react-router-dom";

const Logo = () => {
  // State to manage dropdown visibility
  const [showDropdown, setShowDropdown] = useState(false);

  const handleLogout = () => {
    // Clear user data from localStorage
    localStorage.clear();
    // Redirect to sign-in page
    window.location.href = "/signin";
  };

  return (
    <div className="logo-container">
      <h1>DoubtConnect</h1>

      {/* Hamburger icon */}
      <div className="dropdown">
        <button
          className="dropdown-btn"
          onClick={() => setShowDropdown(!showDropdown)} // Toggle dropdown visibility
        >
          &#9776; {/* This is the hamburger icon */}
        </button>

        {/* Dropdown Menu */}
        {showDropdown && (
          <div className="dropdown-menu">
            <Link to="/profile" className="dropdown-item">Profile</Link>
            <button className="dropdown-item" onClick={handleLogout}>Logout</button>
          </div>
        )}
      </div>
    </div>
  );
};

export default Logo;
