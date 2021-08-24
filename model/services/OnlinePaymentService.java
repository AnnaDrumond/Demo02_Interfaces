package model.services;

public interface OnlinePaymentService {

	/*
	 * NOTA : Interface é um tipo que define um conjunto de operações que uma classe
	 * deve implementar. A interface estabelece um contrato que a classe deve
	 * cumprir. Pra quê interfaces? • Para criar sistemas com baixo acoplamento e
	 * flexíveis.
	 * 
	 */

	// Aqui na interface não implementamos os métodos, somente declaramos suas assinaturas:
	double paymentFee(double amount);
	
	// Como aqui sempre terei um valor a passar e uma valor a receber, ou sejam neste exemplo não haveria
	// hipótese de valores nulos ou algo do tipo, não preciso usar a wrapper class.
	
	double interest ( double amount, int months);
	
	// Esta é então, a declaração de interface que qualquer serviço de pagamento do exemplo tem que implementar,
	// seja o PaypayService ou outro(s).
}
