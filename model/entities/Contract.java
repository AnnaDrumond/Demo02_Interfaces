package model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {
	
	private Integer number;
	private Date date;
	private Double totalValue;
	
	// De acordo com o diagrama UML Contract est� associada a v�rios Installments:
	List <Installment> installments = new ArrayList<Installment>();
	
	public Contract () {
	}

	public Contract(Integer number, Date date, Double totalValue) {
		super();
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public List<Installment> getInstallments() {
		return installments;
	}

	// NOTA: no caso de listas/cole��es n�o deixamos/usamos o m�todo SET (modificar), pois n�o posso permitir que seja 
	// trocada a lista associada ao meu objeto, eu s� posso adicionar/remover elementos da lista, e n�o a lista todo - usamos somente o GET (aceder)
	

}
