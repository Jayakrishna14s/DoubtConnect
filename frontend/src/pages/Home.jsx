import Navbar from "../components/Navbar";
import "../styles/home.css";
import hero from "../assets/image1.webp";

const Home = () => {
  return (
    <>
      <Navbar />

      <section className="hero">
        <div className="hero-left">
          <h1>
            Have a doubt?<br />
            <span>Connect instantly.</span>
          </h1>

          <p>
            Come indulge in your friendly neighbourhood platform to get your
            doubts solved in the most interactive and personalized way.
          </p>

          <button className="cta-btn">
            ASK YOUR FIRST DOUBT FOR FREE!
          </button>
        </div>
        <div className="hero-right">
  <img src={hero} alt="Doubt solving illustration" />
</div>
      </section>
    </>
  );
};

export default Home;
