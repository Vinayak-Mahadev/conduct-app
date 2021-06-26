import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ConductsService {

  private baseUrl = 'http://localhost:8080/datagrokr/ui/api';
  private httpOptions = {
    headers: new HttpHeaders({
      
      'Authorization': 'Basic ' + btoa('admin:admin@123')
    })
  };

  constructor(private http: HttpClient) { }

  getConduct(id: number): Observable<any> {
    // return { "firstName": "Vinayak", "lastName": "Mahadev", "country": "India", "pincode": 6531010, "phoneNumber": 97874800000, "city": "Bangalore", "name": "VinayakMahadev", "createdTime": "2021-06-26 13:41:35", "emailId": "vinayakmahadev@gmail.com", "lastUpdatedTime": "2021-06-26 13:41:35", "id": 101, "state": "Karnataka" };
    let response = this.http.get(`${this.baseUrl}/conducts/${id}`, this.httpOptions);
    console.log(response);
    return response;
  }

  createConduct(conduct: Object): Observable<any> {
    let response = this.http.post(`${this.baseUrl}/conducts`, conduct, this.httpOptions);
    console.log(response);
    return response;
  }

  updateConduct(id: number, conduct: Object): Observable<any> {
    let response = this.http.put(`${this.baseUrl}/conducts/${id}`, conduct, this.httpOptions);
    console.log(response);
    return response;
  }

  deleteConduct(id: number): Observable<any> {
    let response = this.http.delete(`${this.baseUrl}/conducts/${id}`, this.httpOptions);
    console.log(response);
    return response;
  }

  getConductsList(): Observable<any> {
    let response = this.http.get(`${this.baseUrl}/conducts`, this.httpOptions);
    console.log(response);
    return response;
  }
}
