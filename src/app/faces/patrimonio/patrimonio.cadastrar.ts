import { AutocompleteFilterExample } from './../../shared/autocomplete-filter-example/autocomplete-filter-example.component';
import { EntidadesService } from './../../servico/entidades.service';
import { Component, ViewChild } from '@angular/core';
import { Patrimonio } from '../../model/patrimonio.component';
import { PatrimonioService } from '../../servico/patrimonio.service';
import { Entidade } from '../../model/entidades.component';


@Component({
  selector: 'app-principal-patrimonio',
  templateUrl: './patrimonio.cadastrar.html',
  styleUrls: ['../../../../src/styles.css', './patrimonio.cadastrar.html']
})

export class PrincipalPatrimonioComponent {

  @ViewChild(AutocompleteFilterExample) autocomplete!: AutocompleteFilterExample;
  patrimonio: Patrimonio = new Patrimonio();
  pickedEntidade: Entidade = new Entidade();
  btnCadastro: boolean = true;  
  btnBusca: boolean = true;
  buscando: boolean = false;
  tabela: boolean = true;
  PatrimonioArray: Patrimonio[] = [];  
  
  constructor(private servicoPatrimonio: PatrimonioService, private servicoEntidade: EntidadesService) {};
  
  entidadesArray!: Entidade[];

  selecionarEntidades(): void {
    this.servicoEntidade.selecionar()
    .subscribe(
      retorno => {       
        this.entidadesArray = retorno;        
      },
      error => console.error('Erro:', error),
      () => console.log('Observable completado')
    );
  }

  entidadeEscolhida(entidade: Entidade) {
    this.pickedEntidade = entidade;

    this.patrimonio.identidade = this.pickedEntidade.identidade;
    this.patrimonio.razaosocial = this.pickedEntidade.razaosocial;
    this.patrimonio.classe = this.pickedEntidade.classe;
    this.patrimonio.subclasse = this.pickedEntidade.subclasse;
    this.patrimonio.tipo = this.pickedEntidade.tipo;
    this.patrimonio.infad = this.pickedEntidade.infad;
    
    // console.log(minhaEntidade);
  }

  limparCampo() {
    this.autocomplete.limpar();
  }

  buscar(){
    this.PatrimonioArray = this.PatrimonioArray
    .filter(p => p.razaosocial.includes(this.autocomplete.getValor()));
    this.limparCampo();
    this.buscando = true;    
  }




  formatDate(date: Date) {
    return new Date(date).toLocaleDateString('pt-BR');
  }  

  selecionar(): void {
    this.servicoPatrimonio.selecionar()
    .subscribe(retorno => this.PatrimonioArray = retorno);
  }

  cadastrar(): void {
    this.servicoPatrimonio.cadastrar(this.patrimonio)
    .subscribe(retorno => {
      this.PatrimonioArray.push(retorno);
      this.patrimonio = new Patrimonio();
      this.limparCampo();
      alert('Patrimonio cadastrada com sucesso !');
    });
  }  

  selecionarPatrimonio(posicao: number): void {
    this.patrimonio = this.PatrimonioArray[posicao];
    this.btnCadastro = false;
    this.tabela = false;
    this.autocomplete.setRazaosocial(this.patrimonio.razaosocial);
  }

  editar(): void {
    this.servicoPatrimonio.editar(this.patrimonio)
    .subscribe(retorno => {
      this.patrimonio = new Patrimonio();
      this.btnCadastro = true;
      this.tabela = true;
      this.limparCampo();
      alert('Patrimonio editada com sucesso !');
    });
  }

  remover(): void {
    this.servicoPatrimonio.remover(this.patrimonio.idpatrimonio)
    .subscribe(retorno => {
      let posicao = this.PatrimonioArray.findIndex(obj => {
        return obj.idpatrimonio == this.patrimonio.idpatrimonio;
      });

      this.PatrimonioArray.splice(posicao, 1);
      this.patrimonio = new Patrimonio();
      this.btnCadastro = true;
      this.tabela = true;
      alert('Patrimonio excluida com sucesso !');      
    });
  }

  cancelar(): void {
    this.patrimonio = new Patrimonio();
    this.btnCadastro = true;
    this.tabela = true;    
    this.selecionar();
    this.limparCampo();
    this.buscando = false;
  }

  
  ngOnInit() {    
    this.selecionarEntidades(); 
    this.selecionar();   
  }

}
