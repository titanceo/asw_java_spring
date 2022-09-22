import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ServicesService {

  private endpoint = 'services/';

  constructor(private httpClient :HttpClient) { }

  public getByCommerce(id_commerce: string){
    return this.httpClient.get(environment.baseUrl+this.endpoint+id_commerce);
  }
}
