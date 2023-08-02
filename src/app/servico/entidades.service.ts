import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Entidade } from '../componentes/entidades.component';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EntidadesService {

  private url: string = 'http://localhost:8090/controlefinanceiro';
  //private url: string = 'http://localhost:8080/api/colaborador';

  constructor(private http: HttpClient) { }

  public selecionar(): Observable<Entidade[]> {
    return this.http.get<Entidade[]>(this.url);
  }

  public cadastrar(obj: Entidade): Observable<Entidade> {
    return this.http.post<Entidade>(this.url, obj);
  }

  public editar(obj: Entidade): Observable<Entidade> {
    return this.http.put<Entidade>(this.url, obj);
  }

  public remover(idEntidade: number): Observable<void> {
    return this.http.delete<void>(this.url + '/' + idEntidade);
  }


  
  public buscar(razaosocial: string): Observable<Entidade> {
    return this.http.get<Entidade>(this.url);
  }

}
