import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TurnsService {

  private endpoint_create = 'turns/createTurns/';
  private endpoint_getAll = 'turns/';
  
  constructor(private httpClient :HttpClient) { }

  public createTurns( data: any){
    return this.httpClient.post(environment.baseUrl+this.endpoint_create,data);
  }

  public getAll(){
    return this.httpClient.get(environment.baseUrl+this.endpoint_getAll);
  }
}
