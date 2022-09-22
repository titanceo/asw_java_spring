import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm !: FormGroup;
  forms: FormGroup[] = [];
  error = "";
  
  constructor(private fb: FormBuilder,
              private router: Router,
              private authService: AuthService) { }

  ngOnInit(): void {
    this.createLoginForm();
  }

  private createLoginForm() {
    return this.loginForm = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }
  
  public ingresar(){
    this.error = "";
    this.authService.login(this.loginForm.value).
    subscribe((resp:any)=>{
      console.log(resp.length);
      if(resp.status == "200"){
        localStorage.setItem("usuario",resp.value);
        this.router.navigate(['/','turns'])
      }else{
        this.error = "Credenciales invalidas";
      }
    },error=>{
      if(error.error.status && error.error.status == "401"){
        this.error = error.error.message;
        return;
      }

      this.error = "error desconocido"
      
      console.error(error.error);
    })
  }

  

}
