package LP;

import java.util.Scanner;

import LP.Util;

public class HandlerContaCorrente extends HandlerConta {
	static Scanner entrada = new Scanner(System.in);

	public static void criarContaCorrente(String cpf, double saldo) {

		if (!Principal.listaCliente.isEmpty()) {

			Cliente cliente = HandlerCliente.consultarCliente(cpf);
			Agencia agencia = HandlerAgencia.consultarAgencia();

			if (cliente != null && agencia != null) {

				ContaCorrente contaAux = new ContaCorrente(saldo, 1, cliente);

				agencia.inserirConta(contaAux);
				System.out.println("Conta Criada\n");

			}
		}
	}

	public static ContaCorrente consultaContaC(Agencia agencia) {

		System.out.println("Digite o codigo da conta");
		int cod = Util.leInt(entrada);
		ContaCorrente conta = new ContaCorrente(cod);

		if (agencia != null) {
			int index = agencia.lstContas.indexOf(conta);

			if (index > -1)
				conta = (ContaCorrente) agencia.lstContas.get(index);
		}

		if (conta != null)
			return conta;
		else
			return null;
	}

}
