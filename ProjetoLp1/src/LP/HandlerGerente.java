package LP;

import java.util.Iterator;
import java.util.Scanner;

import LP.Util;

public class HandlerGerente {
	static Scanner entrada = new Scanner(System.in);

	public static boolean cadastraGerente(String nome, String cpf, String endereco, int matricula, double salario) {

	//	if (!Principal.listaAgencia.isEmpty()) {

			if (!UtilBanco.pesquisaGerente(cpf)) {

				//Agencia agencia = HandlerAgencia.consultarAgencia();

				Gerente gerente = new Gerente(nome, cpf, endereco, null, salario, matricula);

				Principal.listaGerente.add(gerente);

				System.out.println("Gerente criado\n" + gerente.toString() + "\n");
				
				return true;
			}
	//	}
		return false;

	}

//	public static boolean removeGerente(String cpf) {
//
//		boolean removido = false;
//
//		boolean gerente = consultarGerente(cpf);
//
//		if (gerente != null) {
//
//			Principal.listaGerente.remove(gerente);
//			removido = true;
//
//		} else {
//			removido = false;
//		}
//		return removido;
//
//	}

	public static boolean consultarGerente(String cpf) {

		boolean encontrado = false;
		

		Gerente gerenteAux = null;
		Iterator<Gerente> iterador = Principal.listaGerente.iterator();
		iterador = Principal.listaGerente.iterator(); // para o iterador retornar para o início da lista

		while (iterador.hasNext() && !encontrado) {
		    gerenteAux = iterador.next(); // sem casting
			encontrado = gerenteAux.getCpf().equals(cpf);
		}

		if (encontrado) {
			return true;
		} else {
			return false;
		}

	}

	public static String listarGerente() {

		String saida = "";

		if (Principal.listaGerente.size() > 0) {
			Iterator<Gerente> iterador = Principal.listaGerente.iterator(); // para o iterador retornar para o início da
			// lista
			while (iterador.hasNext()) {
				Gerente gerente = (Gerente) iterador.next(); // necessidade de casting
				saida += gerente.toString();
			}
		} else {
			saida += "Sem gerentes registrados";
		}

		return saida;

	}

//	public static void alterarGerente(String cpf) {
//
//		Gerente gerenteAux = consultarGerente(cpf);
//		if (gerenteAux != null) {
//
//			boolean sair = false;
//			int op;
//			String menuAlteraGerente = "Digite a opção desejada: " + "1 - Alterar dados pessoais \n"
//					+ "2 - Alterar matricula\n" + "3 - Alterar salario\n" + "0 - Retornar ao menu anterior\n";
//
//			try {
//				do {
//					System.out.println(menuAlteraGerente);
//					op = Util.leInt(entrada);
//					switch (op) {
//					case 1:
//						System.out.println("Digite o novo endereço: ");
//						String endereco = Util.leString(entrada);
//						System.out.println("Digite o novo nome: ");
//						String nome = Util.leString(entrada);
//						gerenteAux.setEndereco(endereco);
//						gerenteAux.setNome(nome);
//						System.out.println("Dados alterados \n" + gerenteAux.toString());
//						break;
//
//					case 2:
//						System.out.println("Digite o novo numero de matricula: ");
//						int matricula = Util.leInt(entrada);
//						gerenteAux.setMatricula(matricula);
//						System.out.println("Matricula alterada \n" + gerenteAux.toString());
//						break;
//
//					case 3:
//						System.out.println("Digite o novo salario: ");
//						double salario = Util.leDouble(entrada);
//						gerenteAux.setSalario(salario);
//						System.out.println("Salario alterado \n" + gerenteAux.toString());
//						break;
//
//					case 0:
//						sair = true;
//						break;
//
//					default:
//						System.out.println("Insira uma opção valida.");
//						break;
//					}
//
//				} while (!sair);
//			} catch (Exception e) {
//				System.out.println("ERRO!");
//			}
//
//		} else {
//			System.out.println("Gerente não encontrado!");
//
//		}
//	}

}
