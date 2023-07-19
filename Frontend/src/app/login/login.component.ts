import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  constructor(private http: HttpClient,
    private router: Router){}

  ngOnInit(): void { }

  loginForm = new FormGroup({
    email: new FormControl("", [Validators.required]),
    password: new FormControl("", [Validators.required]) 
  })

  loginSubmitted(){
    this.http.get<any>("http://localhost:8805/api/v1/customers")
    .subscribe(res => {
      const user = res.find((a:any) => {
        return a.email === this.loginForm.value.email && a.password=== this.loginForm.value.password
    });

    if(user){
      alert("Login Success!!");
      this.loginForm.reset();
      this.router.navigate(['customers'])
    }else{
      alert("User not found!!");  
    }
    }, err => {
      alert("Something went wrong!")
    })

  }

  get email(): FormControl{
    return this.loginForm.get("email") as FormControl;
  }

  get password(): FormControl{
    return this.loginForm.get("email") as FormControl;
  }

}
