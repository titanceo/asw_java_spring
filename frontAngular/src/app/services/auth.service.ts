import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private endpoint = 'auth/';
  constructor(private httpClient :HttpClient) { }

  public login(data: any){
    return this.httpClient.post(environment.baseUrl+this.endpoint,data);
  }
}
