import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {Student} from './student.js';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  
  private apiServerUrl = '';
  
  constructor(private http: HttpClient) { }

  public getStudents(): Observable<Student[]>{
    return this.http.get<Student[]>(`${this.apiServerUrl}/student/students`);
  }

  public addStudent(student: Student): Observable<Student>{
    return this.http.post<Student>(`${this.apiServerUrl}/student/add`, student);
  }

  public deleteStudent(studentId: number): Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/student/${studentId}`);
  }
}
