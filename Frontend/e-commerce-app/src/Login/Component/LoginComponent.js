import React from "react";
import "./LoginComponent.css";
import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

const LoginComponent = () => {
  const navigate = useNavigate();
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const [isUserValid, setIsUserValid] = useState("false");

  const handleSubmit = async (event) => {
    event.preventDefault();
    setError("");

    try {
      const response = await axios.post(
        "http://localhost:8080/api/authenticate",
        {
          email,
          password,
        }
      );

      localStorage.setItem("authToken", response.data.token);
      var token = localStorage.getItem("authToken");
      console.log("token is ", token);
      setIsUserValid("true");

      console.log("Login successful:", response.data);
    } catch (err) {
      setIsUserValid("false");
      console.error(
        "Login failed:",
        err.response ? err.response.data : err.message
      );
      setError("Login failed. Please check your credentials and try again.");
    }

    if (isUserValid) {
      navigate(`/listproducts`);
    } else {
      console.error("Login failed");
    }
  };

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <div class="form-group mx-sm-3 mb-2">
          <label for="InputEmail1">Email address</label>
          <input
            type="email"
            class="form-control custom-input"
            id="InputEmail1"
            aria-describedby="emailHelp"
            placeholder="Enter email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
        </div>
        <div class="form-group mx-sm-3 mb-2">
          <label for="InputPassword">Password</label>
          <input
            type="password"
            class="form-control"
            id="InputPassword"
            placeholder="Password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
        </div>

        {error && <p className="text-danger">{error}</p>}

        <button type="submit" class="btn btn-primary align-items-center">
          Submit
        </button>
      </form>
    </div>
  );
};

export default LoginComponent;
