import React from 'react'
import { Link } from 'react-router-dom'


const NavBar = () => {
  return (
    <div>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">SONY</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home</a>
      </li>
      <li><Link className="nav-link" to="/listproducts">
            Products
          </Link></li>
      <li class="nav-item">
        <a class="nav-link" href="#">My Cart</a>
      </li>
      <li class="nav-item my-2 my-lg-0">
        <a class="nav-link" href="#">Contact Us</a>
      </li>
    </ul>
    <div class="collapse navbar-collapse justify-content-end">
    <ul class="navbar-nav">
    <li><Link className="nav-link" to="/login">
            Login
          </Link></li>
      <li class="nav-item">
        <a class="nav-link" href="#">Register</a>
      </li>
    </ul>
    </div>

  </div>
</nav>
    </div>
  )
}

export default NavBar