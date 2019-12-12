package LP;

import java.util.Scanner;

public class HandlerContaPoupanca extends HandlerConta {
	static Scanner entrada = new Scanner(System.in);

	public static void criarContaPoupanca(double saldo, double rendimento, String cpf) {
		if (!Principal.listaCliente.isEmpty()) {

			Cliente cliente = HandlerCliente.consultarCliente(cpf);
			Agencia agencia = HandlerAgencia.consultarAgencia();

			if (cliente != null && agencia != null) {

				ContaPoupanca contaAux = new ContaPoupanca(saldo, rendimento, cliente);

				agencia.inserirConta(contaAux);

				System.out.println(agencia.lstContas.toString());
			}
		}
	}

	public static ContaPoupanca consultaContaP(Agencia agencia) {

		System.out.println("Digite o codigo da conta");
		int cod = Util.leInt(entrada);
		ContaPoupanca conta = new ContaPoupanca(cod);

		if (agencia != null) {
			int index = agencia.lstContas.indexOf(conta);

			if (index > -1)
				conta = (ContaPoupanca) agencia.lstContas.get(index);
		}

		if (conta != null)
			return conta;
		else
			return null;

	}

}
