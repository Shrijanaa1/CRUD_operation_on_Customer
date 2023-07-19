import { Component, OnInit } from '@angular/core';
import { User } from '../entity/user';
import { UserService } from '../service/user.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit{

  constructor(private userService: UserService,
    private router: Router){}

  ngOnInit(): void {
      
  }

  repeatPassword: string = 'none';

  displayMsg: string = '';
  isAccountCreated: boolean = false;

  registerForm = new FormGroup({
    fname: new FormControl("", [Validators.required]),
    email: new FormControl("", [Validators.required, Validators.email]),
    password: new FormControl("", [Validators.required]),
    confirmPassword: new FormControl(""),
  });

  registerSubmit(){
    if(this.password.value == this.ConfirmPassword.value){
      console.log("Submitted");
      this.repeatPassword = 'none'

      this.userService.addUser([
        this.registerForm.value.fname,
        this.registerForm.value.email,
        this.registerForm.value.password,
      ]).subscribe(
      response => {
        if (response === 'Success') {
          this.displayMsg = 'Account Created Successfully!';
          this.isAccountCreated = true;
        } else if (response === 'AlreadyExist') {
          this.displayMsg = 'Account Already Exists. Try another email!';
          this.isAccountCreated = false;
        } else {
          this.displayMsg = 'Something went wrong!';
          this.isAccountCreated = false;
        }
        this.router.navigate(['/login']);
      },
      error => {
        this.displayMsg = 'Something went wrong!';
        this.isAccountCreated = false;
        console.error(error);
      }
    );
    }else{
      this.repeatPassword = 'inline'
    }
  }

  get UserName(): FormControl{
    return this.registerForm.get("fname") as FormControl;
  }

  get UserEmail(): FormControl{
    return this.registerForm.get("email") as FormControl;
  }

  get UserPassword(): FormControl{
    return this.registerForm.get("password") as FormControl;
  }

  get ConfirmPassword(): FormControl{
    return this.registerForm.get("confirmPassword") as FormControl;
  }

}
