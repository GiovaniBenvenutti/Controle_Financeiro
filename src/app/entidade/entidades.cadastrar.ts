import { Component } from '@angular/core';
import { Entidade } from '../componentes/entidades.component';
import { EntidadesService } from '../servico/entidades.service';
import { EnumClasse } from "../enum/classe.enum";
import { SubClasse } from '../enum/subclasse.const';
import { exibeSubClasse } from '../enum/subclasse.const';
import { exibeTipo } from '../enum/tipo.const';

@Component({
  selector: 'app-principal-entidade',
  templateUrl: './entidades.cadastrar.html',
  styleUrls: ['../../../src/styles.css']
})
export class PrincipalEntidadeComponent {

  Entidade = new Entidade();

  classes = Object.values(EnumClasse);  
  subClasses: any ;  
  tipos: any ;
  btnCadastro: boolean = true;  
  btnBusca: boolean = true;
  tabela: boolean = true;
  entidadesArray: Entidade[] = [];
  EnumClasse: any;
  SubClasse: any;
  
  onClasseChange(selectedValue1: string) {
    // Access a property or method of the SubClasse constant to update the subClasses array
    this.subClasses = exibeSubClasse(selectedValue1, SubClasse);
  }      
  onSubClasseChange(selectedValue2: string) {
    // Access a property or method of the tipo constant to update the tipos array
    this.tipos = exibeTipo(selectedValue2);
  }  

  constructor(private servico: EntidadesService) {};

  selecionar(): void {
    this.servico.selecionar()
    .subscribe(retorno => this.entidadesArray = retorno);
  }

  cadastrar(): void {
    this.servico.cadastrar(this.Entidade)
    .subscribe(retorno => {
      this.entidadesArray.push(retorno);
      this.Entidade = new Entidade();
      alert('Entidade cadastrada com sucesso !');
    });
  }

  buscar(): void {
    this.servico.buscar(this.Entidade.razaosocial)
      .subscribe(retorno => {
        if (retorno) {
          const posicao = this.entidadesArray.findIndex(entidade => 
            entidade.razaosocial === this.Entidade.razaosocial);
          if (posicao >=0){  
          this.selecionarEntidade(posicao);
          alert('Entidade encontrada');
          } else {             
            // por alguma razãoisso nunca entra no else !
            alert('Entidade não encontrada');
            this.Entidade.razaosocial = "";
          }
        } 
      });
  }

  selecionarEntidade(posicao: number): void {
    this.Entidade = this.entidadesArray[posicao];
    this.btnCadastro = false;
    this.tabela = false;
  }

  editar(): void {
    this.servico.editar(this.Entidade)
    .subscribe(retorno => {
      this.Entidade = new Entidade();
      this.btnCadastro = true;
      this.tabela = true;
      alert('Entidade editada com sucesso !');
    });
  }

  remover(): void {
    this.servico.remover(this.Entidade.identidade)
    .subscribe(retorno => {
      let posicao = this.entidadesArray.findIndex(obj => {
        return obj.identidade == this.Entidade.identidade;
      });

      this.entidadesArray.splice(posicao, 1);
      this.Entidade = new Entidade();
      this.btnCadastro = true;
      this.tabela = true;
      alert('Entidade escluida com sucesso !');      
    });
  }

  cancelar(): void {
    this.Entidade = new Entidade();
    this.btnCadastro = true;
    this.tabela = true;    
    this.selecionar();
  }

  ngOnInit() {
    this.selecionar();
  }
}
