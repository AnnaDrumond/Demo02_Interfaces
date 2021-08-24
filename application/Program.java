package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypayService;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter contract data");

		System.out.print("Number: ");
		Integer number = scanner.nextInt();
		
		System.out.print("Date (dd/MM/yyyy): "); 
		Date date = sdf.parse(scanner.next());// Aqui teremos de ler uma data digitada pelo usu�rio em formato String e mudar para Date:

		System.out.print("Contract value: ");
		Double totalValue = scanner.nextDouble();
		
		// J� tenho o numero, data e valor total do contrato, com isso j� o posso instanciar:
		Contract contract = new Contract(number, date, totalValue); // contrato lido, criado e instanciado.
		
		System.out.print("Enter number of installments: ");
		int N = scanner.nextInt();
		
		//Processar o contrato, para instanciar as parcelas, para isso instanciar um ContractService, que � a classe respons�vel por processar os contratos:
		ContractService cs = new ContractService(new PaypayService());
		// Aqui instanciei a classe, e injetei a dependencia do ContractService em rela��o  PaypayService.
		
		//Processar o contrato:
		cs.processContract(contract, N);
		
		System.out.print("Installments: ");
		System.out.println();
		
		//Imprimir as parcelas:
		// Para cada it do tipo Installment, da minha LISTA Installments que est� na classe contract fa�a:
		for (Installment it : contract.getInstallments()) {
			System.out.println(it);
		}

		scanner.close();

	}

}
