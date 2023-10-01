
export class Patrimonio {  

  idpatrimonio!: number;
  identidade!: number;
  razaosocial!: string;
  classe!: string;
  subclasse!: string;
  tipo!: string;
  infad!: string;
  levantamento!: Date;
  valor!: number;

  constructor(
    idpatrimonio?: number,
    identidade?: number,
    razaosocial?: string,
    classe?: string,
    subclasse?: string,
    tipo?: string,
    infad?: string,
    levantamento?: Date,
    valor?: number
  ) {
    this.idpatrimonio = idpatrimonio || 0;
    this.identidade = identidade || 0;
    this.razaosocial = razaosocial || '';
    this.classe = classe || '';
    this.subclasse = subclasse || '';
    this.tipo = tipo || '';
    this.infad = infad || '';
    this.levantamento = levantamento || new Date();
    this.valor = valor || 0;
  }

  toString(): string {
    return `Patrimonio: ${this.idpatrimonio}, ${this.identidade}, ${this.razaosocial}, ${this.classe}, ${this.subclasse}, ${this.tipo}, ${this.infad}, ${this.levantamento}, ${this.valor}`;
  }
}
