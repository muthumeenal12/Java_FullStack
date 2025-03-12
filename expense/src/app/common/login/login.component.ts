import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'] // ✅ Corrected property
})
export class LoginComponent {
  username: string = '';
  password: string = '';

  // constructor(private router: Router) {} // ✅ Inject Router for navigation

  login() {
    if (this.username === "peter" && this.password === "password") {
      localStorage.setItem("username", this.username);
      window.location.reload(); // ✅ Redirect to home instead of reloading
    } else 
      alert("Invalid Credentials");
    
  }
}
