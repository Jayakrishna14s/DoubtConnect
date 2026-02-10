import { useState } from "react";
import Logo from "../components/Logo";  // Import Logo with dropdown
import "../styles/profile.css";
import profileImage from "../assets/profile.webp";

const Profile = () => {
  // Fetch user data from localStorage (values saved during sign-up)
  const username = localStorage.getItem("username") || "john_doe";  // Username from localStorage
  const email = localStorage.getItem("email") || "john.doe@example.com"; // Email from localStorage

  // First Name and Last Name from localStorage (after sign-up)
  const [firstName, setFirstName] = useState(localStorage.getItem("firstName") || "John");
  const [lastName, setLastName] = useState(localStorage.getItem("lastName") || "Doe");

  // State to manage the toggle for questions and comments
  const [displayContent, setDisplayContent] = useState("questions");
  const [myQuestions, setMyQuestions] = useState([
    "How do I integrate React with an API?",
    "What is useState in React?"
  ]);  // Mock questions
  const [myComments, setMyComments] = useState([
    "React makes front-end development easier and faster.",
    "Using hooks like useState simplifies managing state."
  ]);  // Mock comments

  // Function to display My Questions
  const showQuestions = () => {
    setDisplayContent("questions");
  };

  // Function to display My Comments
  const showComments = () => {
    setDisplayContent("comments");
  };

  return (
    <div className="profile-page">
      {/* Header with Logo dropdown */}
      <header className="profile-header">
        <Logo />
      </header>

      {/* Main Content */}
      <main className="profile-content">
        <div className="profile-card">
          <h2>Profile Details</h2>

          <div className="profile-info">
            <div className="profile-pic">
              <img src={profileImage} alt="Profile" />
            </div>

            <div className="profile-details">
              <p><strong>Username:</strong> {username}</p>
              <p><strong>Email:</strong> {email}</p>
              <p><strong>First Name:</strong> {firstName}</p>
              <p><strong>Last Name:</strong> {lastName}</p>
              <p><strong>Account Status:</strong> Active</p>
            </div>
          </div>

          <div className="profile-actions">
            {/* Buttons side by side */}
            <button className="action-btn" onClick={showQuestions}>My Questions</button>
            <button className="action-btn" onClick={showComments}>My Comments</button>
          </div>

          {/* Display content based on the selected button */}
          <div className="content-section">
            {displayContent === "questions" && (
              <>
                <h3>My Questions</h3>
                <ul>
                  {myQuestions.map((question, index) => (
                    <li key={index}>{question}</li>
                  ))}
                </ul>
              </>
            )}
            {displayContent === "comments" && (
              <>
                <h3>My Comments</h3>
                <ul>
                  {myComments.map((comment, index) => (
                    <li key={index}>{comment}</li>
                  ))}
                </ul>
              </>
            )}
          </div>
        </div>
      </main>
    </div>
  );
};

export default Profile;
