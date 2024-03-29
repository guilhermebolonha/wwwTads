import java.util.Iterator;
import java.util.Scanner;

public class GerenciaAgencia {

	public static boolean criarAgencia(Scanner entrada) {

		try {
			Agencia novaAgencia = new Agencia();
			System.out.println("Insira o nome da nova ag�ncia");
			novaAgencia.setNome(entrada.nextLine());
			System.out.println("Insira o endere�o da nova ag�ncia");
			novaAgencia.setEndereco(entrada.nextLine());
			return Principal.lstAgencias.add(novaAgencia);

		} catch (Exception e) {
			System.err.println("Quebrou");
		}
		return false;
	}

	public static boolean buscarAgencia(int numeroAg) {
		// Retorna true se encontra o elemento e false se n�o encontra
		Agencia agenciaAux = new Agencia();

		int posElem = Principal.lstAgencias.indexOf(agenciaAux);
		if (posElem > -1) {
			return true;
		}

		return false;
	}

	public static Agencia selecionarAgencia(Scanner entrada) {
		Iterator<Agencia> iterAgencia = Principal.lstAgencias.iterator();
		String agencias = "Insira o n�mero da ag�ncia desejada\n";
		boolean continuar = true;
		boolean encontrado = false;
		Agencia agenciaAux;
		int index = 0;

		try {
			while (continuar) {
				if (iterAgencia.hasNext()) {
					for (int i = 0; i < Principal.lstAgencias.size(); i++) {
						agenciaAux = Principal.lstAgencias.get(i);
						agencias += i + "- " + agenciaAux.toString() + "\n";
					}
					System.out.println(agencias + "ou digite -1 para cancelar");

					int numAg = Integer.valueOf(entrada.nextLine());

					for (int i = 0; i < Principal.lstAgencias.size(); i++) {
						agenciaAux = Principal.lstAgencias.get(i);
						if (numAg == agenciaAux.getNumeroAg()) {
							return Principal.lstAgencias.get(i);
						}
						continuar = false;
					}
					
				} else if(Principal.lstAgencias.isEmpty()) {
					System.out.println("Nenhuma Ag�ncia cadastrada!");
					return null;
				}
			}
		} catch (Exception e) {
			System.out.println("Entrada Inv�lida!!");
		}
		return null;
	}

	public static boolean cancelarAgencia(int numAgencia) {
		int indice = localizarAgencia(numAgencia);
		if (indice != -1) {
			Principal.lstAgencias.remove(indice);
			return true;
		}
		return false;
	}

	private static int localizarAgencia(int numAgencia) {
		for (int index = 0; index < Principal.lstAgencias.size(); index++) {
			Agencia conta = Principal.lstAgencias.get(index);

			if (conta.getNumeroAg() == numAgencia) {
				return index;
			}
		}
		return -1;
	}

	// m�todo para mostrar todas as ag�ncias que est�o cadastradas no sistema
	public static void mostraAgencias() {
		Iterator<Agencia> iterAgencia = Principal.lstAgencias.iterator();
		Agencia AgenciaAux = iterAgencia.next();
		String agencias = "";
		for (int i = 0; i < Principal.lstContas.size(); i++) {
			agencias += i + "- " + AgenciaAux.toString() + "\n";
		}
		System.out.println(agencias);
	}

}
