import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwIfEmpty } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CommerceService {

  private endpoint = 'commerces/';

  constructor(private httpClient :HttpClient) { }

  public getAll(){
    return this.httpClient.get(environment.baseUrl+this.endpoint);
  }
}
