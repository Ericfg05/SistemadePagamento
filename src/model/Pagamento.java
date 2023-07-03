package model;

import java.util.Calendar;

public class Pagamento {
	private double pagar;
	private double totalPago;
	private double sobra;
	private Calendar dataPagamento;
	private Calendar dataLimite;
	
	
	
	public Pagamento(double pagar, double totalPago, double sobra, Calendar dataPagamento, Calendar dataLimite) {
		this.pagar = pagar;
		this.totalPago = totalPago;
		this.sobra = sobra;
		this.dataPagamento = dataPagamento;
		this.dataLimite = dataLimite;
	}
	public double getPagar() {
		return pagar;
	}
	public void setPagar(double pagar) {
		this.pagar = pagar;
	}
	public double getTotalPago() {
		return totalPago;
	}
	public void setTotalPago(double totalPago) {
		this.totalPago = totalPago;
	}
	public double getSobra() {
		return sobra;
	}
	public void setSobra(double sobra) {
		this.sobra = sobra;
	}
	public Calendar getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(Calendar dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	public Calendar getDataLimite() {
		return dataLimite;
	}
	public void setDataLimite(Calendar dataLimite) {
		this.dataLimite = dataLimite;
	}
	
	
}
