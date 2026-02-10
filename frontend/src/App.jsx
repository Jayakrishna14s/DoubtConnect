import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import SignIn from "./pages/SignIn";
import SignUp from "./pages/SignUp";
import Dashboard from "./pages/Dashboard";
import Profile from "./pages/Profile";  
import Search from "./pages/Search";
import HomePage from "./pages/HomePage"; 


function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/signin" element={<SignIn />} />
        <Route path="/signup" element={<SignUp />} />
        <Route path="/dashboard" element={<Dashboard />} />
        <Route path="/profile" element={<Profile />} />  
        <Route path="/search" element={<Search />} />
        <Route path="/homepage" element={<HomePage />} /> 

      </Routes>
    </BrowserRouter>
  );
}

export default App;
