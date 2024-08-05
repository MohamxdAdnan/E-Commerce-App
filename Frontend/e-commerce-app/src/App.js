import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import './App.css';
import NavBar from './NavBar/NavBar';
import LoginPage from "./Login/LoginPage";
import Products from "./Products/Products";
import ProductCard from "./Products/Card/ProductCard";
import Register from "./Register/Register";


function App() {
  return (
    <div className="App">
     <Router>
        <NavBar />

        <Routes>
          <Route exact path="/login" element={<LoginPage/>} />
          <Route exact path="/listproducts" element={<ProductCard/>} />
          <Route exact path="/register" element={<Register/>} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
