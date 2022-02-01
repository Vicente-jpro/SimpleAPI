import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {Student} from './student';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  //enviriment.ts -> We defined the default back and port
  private apiServerUrl = environment.apiBaseUrl;
  
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

  public search(keyWord: string): Observable<Student>{
    return this.http.get<Student>(`${this.apiServerUrl}/student/search/${keyWord}`);
  }
}
