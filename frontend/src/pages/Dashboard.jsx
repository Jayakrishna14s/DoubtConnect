import Logo from "../components/Logo";
import "../styles/dashboard.css";
import { Link } from "react-router-dom";  
 

const Dashboard = () => {
  return (
    <div className="dashboard-page">
      {/* Top Bar */}
      <header className="dashboard-header">
        <Logo />
      </header>

      {/* Main Content */}
      <main className="dashboard-content">
        <h1>Welcome back 👋</h1>
        <p>
          Ask doubts, explore solutions, and track your learning — all in one
          place.
        </p>

        
        <div className="dashboard-actions">
          
        <div
          className="action-card home"
          onClick={() => window.location.href = "/homepage"} 
        >
          <span className="icon">🏠</span>
          <h3>Home</h3>
          <p>Go to Home page</p>
        </div>

          <div
  className="action-card search"
  onClick={() => window.location.href = "/search"}
>
  <span className="icon">🔍</span>
  <h3>Search</h3>
  <p>Find doubts & solutions</p>
</div>
          

          <div
  className="action-card profile"
  onClick={() => window.location.href = "/profile"}
>
  <span className="icon">👤</span>
  <h3>Profile</h3>
  <p>View & edit your profile</p>
</div>
        </div>
      </main>
    </div>
  );
};

export default Dashboard;
