import { Link } from "react-router-dom";
import Logo from "../components/Logo";
import "../styles/homepage.css";

const HomePage = () => {
  return (
    <div className="home-page">
      {/* Top Header */}
      <header className="home-header">
        <Logo />

        {/* Profile and Search buttons on the top-right */}
        <div className="top-right-buttons">
          <Link to="/search">
            <button className="cta-btn small-btn">Search</button>
          </Link>
          <Link to="/profile">
            <button className="cta-btn small-btn">Profile</button>
          </Link>
        </div>
      </header>

      {/* Main Content */}
      

          
       

        {/* Frequently Asked Questions */}
        <main>
          <div>
        <section className="faq-section">
          <h2>Frequently Asked Questions</h2>

          <div className="faq-item">
            <h3>How to integrate React with API?</h3>
            <p>Learn how to fetch data using React and display it in components.</p>
            <Link to="/search">Read More</Link>
          </div>

          <div className="faq-item">
            <h3>How do I create a React Project?</h3>
            <p>Step-by-step guide to set up your React development environment.</p>
            <Link to="/search">Read More</Link>
          </div>

          <div className="faq-item">
            <h3>What is Redux in React?</h3>
            <p>An overview of Redux and how it helps with state management.</p>
            <Link to="/search">Read More</Link>
          </div>
        </section>
        </div>
      </main>
    </div>
  );
};

export default HomePage;
