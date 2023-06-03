package Model;

public class Entidade {

	private int idEntidade; // chave gerada com autoincremento pelo banco de dados.
	private String razaoSocial;
	private String setor;
	private String dre;
	private String balanco;
	private String presumido;
	private int parcelas;
	private int prazo;
	private boolean mensal;
	
	public Entidade(String razaoSocial, String setor, String dre, String balanco, String presumido,
			int parcelas, int prazo, boolean mensal) {
		super();		
		this.razaoSocial = razaoSocial;
		this.setor = setor;
		this.dre = dre;
		this.balanco = balanco;
		this.presumido = presumido;
		this.parcelas = parcelas;
		this.prazo = prazo;
		this.mensal = mensal;
	}
	public Entidade() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Entidade [idEntidade=" + idEntidade + ", razaoSocial=" + razaoSocial + ", setor=" + setor + ", dre="
				+ dre + ", balanco=" + balanco + ", presumido=" + presumido + ", parcelas=" + parcelas + ", prazo="
				+ prazo + ", mensal=" + mensal + "]";
	}
	
	public int getIdEntidade() {
		return idEntidade;
	}
	/*
	public void setIdEntidade(int idEntidade) {
		this.idEntidade = idEntidade;
	}
	*/
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	public String getDre() {
		return dre;
	}
	public void setDre(String dre) {
		this.dre = dre;
	}
	public String getBalanco() {
		return balanco;
	}
	public void setBalanco(String balanco) {
		this.balanco = balanco;
	}
	public String getPresumido() {
		return presumido;
	}
	public void setPresumido(String presumido) {
		this.presumido = presumido;
	}
	public int getParcelas() {
		return parcelas;
	}
	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}
	public int getPrazo() {
		return prazo;
	}
	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}
	public boolean isMensal() {
		return mensal;
	}
	public void setMensal(boolean mensal) {
		this.mensal = mensal;
	}
	
	
	
}
