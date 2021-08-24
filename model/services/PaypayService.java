package model.services;

public class PaypayService implements OnlinePaymentService {
	
	// Como no exemplo, os valores s�o fixos e n�o ser�o buscados fora do sistema, 
	// foi usado um hardcode(utiliza��o de valores fixos dentro do c�digo fonte, ou seja, uma codifica��o r�gida)
	// que seria uma m� pr�tica de programa��o.
	
	private static final double PAYMENT_FEE = 0.02; //2% juros por pagamento
	private static final double MONTHLY_INTEREST = 0.01; //1% juro a cada m�s.
	
	//Como esta classe implementa a interface, ela � obrigada a cumprir o contrato definido
	//na interface e ter os m�todos assinados na interface:

	@Override
	public double paymentFee(double amount) {
		return amount * PAYMENT_FEE; // valor do pagamento x 2% de taxa por pagamento.
	}

	@Override
	public double interest(double amount, int months) {
		return amount* months * MONTHLY_INTEREST;// valor do pagamento x meses x valor do juro mensal.
	}

}
