import { useState } from "react";
import Logo from "../components/Logo";
import "../styles/search.css";

const Search = () => {
  const [question, setQuestion] = useState("");
  const [results, setResults] = useState([]);

  const handleSearch = () => {
    if (!question.trim()) return;

    // Mock results (later replace with backend / AI)
    setResults([
      `Explanation related to "${question}"`,
      `Common mistakes students make in "${question}"`,
      `Best approach to solve "${question}"`
    ]);
  };

  return (
    <div className="search-page">
      {/* Header */}
      <header className="search-header">
        <Logo />
      </header>

      {/* Content */}
      <main className="search-content">
        <h1>Ask your doubt</h1>
        <p>
          Type your question below and explore relevant explanations and
          solutions.
        </p>

        <div className="search-box">
          <input
            type="text"
            placeholder="Type your question here..."
            value={question}
            onChange={(e) => setQuestion(e.target.value)}
          />
          <button onClick={handleSearch}>Search</button>
        </div>

        {/* Results */}
        {results.length > 0 && (
          <div className="search-results">
            <h2>Results</h2>
            {results.map((item, index) => (
              <div key={index} className="result-card">
                {item}
              </div>
            ))}
          </div>
        )}
      </main>

      {/* Footer with icons */}
      <footer className="footer">
        <div className="footer-buttons">
          <button className="footer-btn" onClick={() => window.location.href = "/homepage"}>
            Home {/* Home Icon */}
          </button>
          <button className="footer-btn" onClick={() => window.location.href = "/profile"}>
            Profile {/* Profile Icon */}
          </button>
          <button className="footer-btn" onClick={() => window.location.href = "/search"}>
            Search {/* Search Icon */}
          </button>
        </div>
      </footer>
    </div>
  );
};

export default Search;
