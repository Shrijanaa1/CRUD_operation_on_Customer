  import { HttpClient } from '@angular/common/http';
  import { Injectable } from '@angular/core';
  import { Observable } from 'rxjs';
  import { Customer } from '../entity/customer';

  @Injectable({
    providedIn: 'root'
  })

  export class CustomerService {

    private baseURL = "http://localhost:8805/api/v1/customers";
    

    // For injecting HttpClientModule
    // allows the CustomerService to make HTTP requests.
    constructor(private httpClient: HttpClient) { }

    // <Customer[]> --> This means the type is array of Customer
    // when the getCustomersList() method is called, it sends an HTTP GET request to the specified URL and expects a response of type Customer[]. The response is wrapped in an Observable, which can be subscribed to in order to retrieve the data asynchronously.
    //  url is placed inside backtick `` 
    getCustomersList(): Observable<Customer[]>{
      return this.httpClient.get<Customer[]>(`${this.baseURL}`);
    }

    // //This is post request so we have to send data in body of post method
    // createCustomer(customer: Customer): Observable<Object>{
    //   return this.httpClient.post(`${this.baseURL}`, customer);
    // }

    //now we are going to pass as form data
    createCustomer(customer: Customer): Observable<Object>{
      return this.httpClient.post(`${this.baseURL}`, customer);
    }

    //get customer by id
    getCustomerById(id: number): Observable<Customer>{
      return this.httpClient.get<Customer>(`${this.baseURL}/${id}`);
      // return this.httpClient.get(`${this.updateURL}/${id}`);
    } 

    updateCustomer(id: number, customer: Customer): Observable<Object>{
      return this.httpClient.put(`${this.baseURL}/${id}`, customer);  
    }

    deleteCustomer(id: number): Observable<Object>{
      return this.httpClient.delete(`${this.baseURL}/${id}`);
    } 

  }
