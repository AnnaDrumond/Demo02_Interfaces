package model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {
	
	private Integer number;
	private Date date;
	private Double totalValue;
	
	// De acordo com o diagrama UML Contract está associada a vários Installments:
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

	// NOTA: no caso de listas/coleções não deixamos/usamos o método SET (modificar), pois não posso permitir que seja 
	// trocada a lista associada ao meu objeto, eu só posso adicionar/remover elementos da lista, e não a lista todo - usamos somente o GET (aceder)
	

}
