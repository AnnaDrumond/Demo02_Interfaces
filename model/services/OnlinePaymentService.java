package model.services;

public interface OnlinePaymentService {

	/*
	 * NOTA : Interface � um tipo que define um conjunto de opera��es que uma classe
	 * deve implementar. A interface estabelece um contrato que a classe deve
	 * cumprir. Pra qu� interfaces? � Para criar sistemas com baixo acoplamento e
	 * flex�veis.
	 * 
	 */

	// Aqui na interface n�o implementamos os m�todos, somente declaramos suas assinaturas:
	double paymentFee(double amount);
	
	// Como aqui sempre terei um valor a passar e uma valor a receber, ou sejam neste exemplo n�o haveria
	// hip�tese de valores nulos ou algo do tipo, n�o preciso usar a wrapper class.
	
	double interest ( double amount, int months);
	
	// Esta � ent�o, a declara��o de interface que qualquer servi�o de pagamento do exemplo tem que implementar,
	// seja o PaypayService ou outro(s).
}
