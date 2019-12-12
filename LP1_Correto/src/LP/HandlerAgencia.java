package LP;

import java.util.Scanner;

import LP.Util;

import java.util.Iterator;

public class HandlerAgencia {
	static Scanner entrada = new Scanner(System.in);

	public static void cadastrarAgencia(String nome) {


		Agencia agencia = new Agencia(nome);
		Principal.listaAgencia.add(agencia);

		System.out.println("Agencia cadastrada\n" + agencia.toString() + "\n\n");
	}

	public static String listarAgencia() {
		String saida = "";

		if (Principal.listaAgencia.size() > 0) {
			Iterator<Agencia> iterador = Principal.listaAgencia.iterator(); // para o iterador retornar para o início da
			// lista
			while (iterador.hasNext()) {
				Agencia agencia = (Agencia) iterador.next(); // necessidade de casting
				saida += agencia.toString();
			}
		} else {
			saida += "Sem agencias registradas";
		}

		return saida;

	}

	public static Agencia consultarAgencia(int codAgencia) {

		Agencia agenciaAux = new Agencia(codAgencia);

		int index = Principal.listaAgencia.indexOf(agenciaAux);

		if (index >= 0) {
			return Principal.listaAgencia.get(index);

		} else {

			return null;
		}
	}

	public static boolean removeAgencia(int codAgencia) {

		// ta ok
		Agencia agencia = consultarAgencia(codAgencia);

		if (agencia != null) {
			Principal.listaAgencia.remove(agencia);
			return true;
		} else {
			return false;
		}

	}

	public static void alterarAgencia(int codAgencia) {
		
		Agencia agencia = consultarAgencia(codAgencia);

		if (agencia != null) {

			boolean sair = false;
			int op;
			String menuAlteraAgencia = "Digite a opção desejada: " + "1 - Alterar nome da agência  \n"
					+ "0 - Menu anterior\n";

			try {
				do {
					System.out.println(menuAlteraAgencia);
					op = Util.leInt(entrada);
					switch (op) {
					case 1:
						// precisa colocar o que vem da tela direto aqui
						//agencia.setNome();
						//MUITA ATENÇÃO AQUI.
						System.out.println("\nNome alterado: " + agencia.toString());
						break;

					case 0:
						sair = true;
						break;

					default:
						System.out.println("Insira uma opção valida.");
						break;
					}

				} while (!sair);
			} catch (Exception e) {
				System.out.println("ERRO!");
			}

		} else {
			

		}
	}
	public static void aplicaViraMes(Agencia agencia) {
		Operacao opera;
		
		for (Conta conta : agencia.lstContas) {	
			if(conta instanceof ContaCorrente) {
				opera = new Rendimento(conta);
				opera.efetuar();
				
			}else if(conta instanceof ContaPoupanca) {
				
				opera = new Tarifacao(conta);
				opera.efetuar();
			}
				
			
			
		}
	
		
	}
}
