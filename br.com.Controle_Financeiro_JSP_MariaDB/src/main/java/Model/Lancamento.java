package Model;

import java.util.Date;
import java.text.SimpleDateFormat;


public class Lancamento {

	private int idLancamento; // chave gerada com autoincremento pelo banco de dados.
	private String credor;
	private String numeroNfe;
	private String setor;
	private String dre;
	private String balanco;
	private int parcelas;
	private Double valorOriginal;
	private Double valorPago;
	private Date emissao;
	private Date vencimento;
	private Date pagamento;
	private String situacao;
	private String observacoes;
	private Double juros;
	private String presumido;
	private int prazo;
	
	public Lancamento(int idLancamento, String credor, String numeroNfe, String setor, String dre, String balanco,
			int parcelas, Double valorOriginal, Double valorPago, Date emissao, Date vencimento, Date pagamento,
			String situacao, String observacoes, Double juros, String presumido, int prazo) {
		super();
		this.idLancamento = idLancamento;
		this.credor = credor;
		this.numeroNfe = numeroNfe;
		this.setor = setor;
		this.dre = dre;
		this.balanco = balanco;
		this.parcelas = parcelas;
		this.valorOriginal = valorOriginal;
		this.valorPago = valorPago;
		this.emissao = emissao;
		this.vencimento = vencimento;
		this.pagamento = pagamento;
		this.situacao = situacao;
		this.observacoes = observacoes;
		this.juros = juros;
		this.presumido = presumido;
		this.prazo = prazo;
	}
	public Lancamento() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Lancamento [idLancamento=" + idLancamento + ", credor=" + credor + ", numeroNfe=" + numeroNfe
				+ ", setor=" + setor + ", dre=" + dre + ", balanco=" + balanco + ", parcelas=" + parcelas
				+ ", valorOriginal=" + valorOriginal + ", valorPago=" + valorPago + ", emissao=" + emissao
				+ ", vencimento=" + vencimento + ", pagamento=" + pagamento + ", situacao=" + situacao
				+ ", observacoes=" + observacoes + ", juros=" + juros + ", presumido=" + presumido + ", prazo=" + prazo
				+ "]";
	}
	public int getIdLancamento() {
		return idLancamento;
	}
	
	public String getCredor() {
		return credor;
	}
	public void setCredor(String credor) {
		this.credor = credor;
	}
	public String getNumeroNfe() {
		return numeroNfe;
	}
	public void setNumeroNfe(String numeroNfe) {
		this.numeroNfe = numeroNfe;
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
	public int getParcelas() {
		return parcelas;
	}
	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}
	public Double getValorOriginal() {
		return valorOriginal;
	}
	public void setValorOriginal(Double valorOriginal) {
		this.valorOriginal = valorOriginal;
	}
	public Double getValorPago() {
		return valorPago;
	}
	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}
	public Date getEmissao() {
		return emissao;
	}
	public void setEmissao(Date emissao) {
		this.emissao = emissao;
	}
	public Date getVencimento() {
		return vencimento;
	}
	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}
	public Date getPagamento() {
		return pagamento;
	}
	public void setPagamento(Date pagamento) {
		this.pagamento = pagamento;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public Double getJuros() {
		return juros;
	}
	public void setJuros(Double juros) {
		this.juros = juros;
	}
	public String getPresumido() {
		return presumido;
	}
	public void setPresumido(String presumido) {
		this.presumido = presumido;
	}
	public int getPrazo() {
		return prazo;
	}
	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}

	

}
