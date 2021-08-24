package model.services;

public class PaypayService implements OnlinePaymentService {
	
	// Como no exemplo, os valores são fixos e não serão buscados fora do sistema, 
	// foi usado um hardcode(utilização de valores fixos dentro do código fonte, ou seja, uma codificação rígida)
	// que seria uma má prática de programação.
	
	private static final double PAYMENT_FEE = 0.02; //2% juros por pagamento
	private static final double MONTHLY_INTEREST = 0.01; //1% juro a cada mês.
	
	//Como esta classe implementa a interface, ela é obrigada a cumprir o contrato definido
	//na interface e ter os métodos assinados na interface:

	@Override
	public double paymentFee(double amount) {
		return amount * PAYMENT_FEE; // valor do pagamento x 2% de taxa por pagamento.
	}

	@Override
	public double interest(double amount, int months) {
		return amount* months * MONTHLY_INTEREST;// valor do pagamento x meses x valor do juro mensal.
	}

}
