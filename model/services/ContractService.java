package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	
	// Inversão de Controlo ou IoC.
	
	// não podemos deixar a própria classe ContractService, responsável pelo controlo de qual
	// instância ela vai precisar para executar, pois isso gera um alto acoplamento. Para manter
	// o programa mais flexível, caso a regra de negócio (Taxa) mude, vamos inverter o controle.
	
	// Por isso, NÂO posso por:
	// private OnlinePaymentService paymentService = new PaypalService();
	
	// Quem tem que controlar qual a instancia do objeto dependente que vai ser instanciada
	// é um local a parte  - 
	
	//vamos apenas declarar a variável como sendo do tipo genérico que é a interface:
	
	private OnlinePaymentService onlinePaymentService;
	
	// vou fazer a inversão de controle, por meio da injeção de dependencia usando um construtor:
	
	public ContractService (OnlinePaymentService onlinePaymentService) {	
		this.onlinePaymentService = onlinePaymentService;
	}
	
	// Open Close Principle - a classe pode ser aberta para extensão, porém fechada para alteração.

	// Colocar o método que consta no diagrama UML:
	public void processContract (Contract contract, Integer months) {  // responsavel por instanciar deste deste objeto contract os N objetos/parcelas 
		
		// armazenar em uma var o valor básico de cada prestação/parcela:
		double basicQuota = contract.getTotalValue()/months;
		
		// Criar um for para
		for ( int i = 1; i <= months; i++) {
			
			// Atualizar a quota básica, para o valor mensal incluído os juros mensais de 1% a cada parcela:
			double updateQuota = basicQuota + onlinePaymentService.interest(basicQuota, i); // usei o i, para ir iterando conforme o Loop
			
			//Atualizar este updateQuota, para incluir os juros de 2% por pagamento:
			double fullQuota = updateQuota + onlinePaymentService.paymentFee(updateQuota);
			
			// Depois de fazer o método de acrescimo dos meses, 
			// Pego a data do contrato e nela vou adicionar i meses -- passei estes dados como parâmetro para o método addMonths.
			Date dueDate = addMonths(contract.getDate(), i); // usei o i, para ir iterando conforme o Loop e assim ter a data de venc da parcela 1, 2...
			
			// Já tenho até aqui, o valor e a data de vencimento da parcela, agora vou adicionar ao meu contrato uma nova instância
			// com estes dados, para isso vou acessar a minha lista declarada em Contract
			
			contract.getInstallments().add(new Installment(dueDate, fullQuota));
			// aceder lista de parcelas - adicionar novo objeto - nova parcela, passando como parâmetro a data de venc e valor final da parcela.
			
		}
	}
	
	// temos que ir acrescentando os meses de acordo com a quantidade de meses informada pelo usuário:
	private Date addMonths(Date date, int N) { // vou acrescentar N meses a data informada.
		
		//Primeiro, vamos criar e instanciar uma var do tipo Calendar:
		Calendar calendar = Calendar.getInstance();
		
		// vou colocar a var date do tipo Date dentro da minha var calendar:
		calendar.setTime(date);
		
		//Agora vamos acrescentar os meses:
		calendar.add(Calendar.MONTH, N);
		
		return calendar.getTime();
	}
}
