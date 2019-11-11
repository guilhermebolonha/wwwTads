import java.util.Iterator;
import java.util.Scanner;

public class GerenciaConta {
	public static Conta selecionarConta(Cliente clientx, Scanner entrada) {
		Iterator<Conta> iterConta = Principal.lstContas.iterator();
		String contas = "Insira o n�mero da conta desejada\n";
		Conta contaAux;
		boolean continuar = true;
		int index = 0;
		try {
			while (continuar) {
				if (iterConta.hasNext()) {
					contaAux = iterConta.next();
					for (int i = 0; i < Principal.lstContas.size(); i++) {
						contaAux = Principal.lstContas.get(i);
						if (clientx.equals(contaAux.getTitular())) {
							contas += i + "- " + contaAux.toString() + "\n";
						}
					}
					contas += "ou digite -1 para cancelar";
					System.out.println(contas);
					
					int numConta = Integer.valueOf(entrada.nextLine());

					for (int i = 0; i < Principal.lstContas.size(); i++) {
						contaAux = Principal.lstContas.get(i);
						if (numConta == contaAux.getNumConta()) {
							index = i;
						}
					}
					if (index >= 0 && index <= (Principal.lstContas.size() - 1)) {
						return Principal.lstContas.get(index);
					} else if (index == -1) {
						continuar = false;
					}
				} else if(Principal.lstContas.isEmpty()) {
					System.out.println("Nenhuma conta cadastrada!");
					return null;
				}
			}
		} catch (Exception e) {
			System.out.println("Entrada Inv�lida!!");
		}
		return null;
	}

	protected static void cadastraConta(Scanner entrada) {
		boolean sair = false;
		do {
			try {
				System.out.println("Que tipo de conta?\n1- Corrente\n2- Poupan�a\n0- Voltar ao menu anterior");
				int tipoConta = Integer.valueOf(entrada.nextLine());

				switch (tipoConta) {
				case 1:
					if (GerenciaConta.cadastraContaCorrente(entrada)) {
						sair = true;
					}
					break;
				case 2:
					if (GerenciaConta.cadastraContaPoupanca(entrada)) {
						sair = true;
					}
					break;
				case 0:
					sair = true;
				default:
					System.out.println("Op��o inv�lida!");
					break;
				}
			} catch (Exception e) {
				System.err.println("Erro ao cadastrar conta!");
			}
		} while (!sair);
	}

	// cadastra a conta no array list
	public static boolean cadastraContaCorrente(Scanner entrada) {
		Cliente clientezinho = GerenciaCliente.selecionarCliente(entrada);
		int agencia = clientezinho.getNumeroAg();
		Conta novaConta = new ContaCorrente(agencia, clientezinho);
		try {
			System.out.println("Insira a senha da nova conta");
			novaConta.setSenha(entrada.nextLine());

			if (Principal.lstContas.add(novaConta)) {
				System.out.println("Conta cadastrada com sucesso");
				return true;
			} else {
				System.out.println("A conta n�o foi cadastrada");
			}

		} catch (Exception e) {
			System.err.println("Quebrou");
		}
		return false;
	}

	// cadastra a conta no array list
	public static boolean cadastraContaPoupanca(Scanner entrada) {
		Cliente clientezinho = GerenciaCliente.selecionarCliente(entrada);
		int agencia = clientezinho.getNumeroAg();
		Conta novaConta = new ContaPoupanca(agencia, clientezinho);
		try {
			System.out.println("Insira a senha da nova conta");
			novaConta.setSenha(entrada.nextLine());

			if (Principal.lstContas.add(novaConta)) {
				System.out.println("Conta cadastrada com sucesso");
				return true;
			} else {
				System.out.println("A conta n�o foi cadastrada");
			}

		} catch (Exception e) {
			System.err.println("Quebrou");
		}
		return false;
	}

	// exclui uma conta desejada
	public static boolean CancelarConta(int numConta) {
		int indice = LocalizarConta(numConta);
		if (indice != -1) {
			Principal.lstContas.remove(indice);
			return true;
		} else {
			return false;
		}
	}

	// metodo que busca uma bonta dentro do arraylist e retorna sua posi��o
	private static int LocalizarConta(int numero) {
		for (int cont = 0; cont < Principal.lstContas.size(); cont++) {
			Conta conta = Principal.lstContas.get(cont);

			if (conta.getNumConta() == numero) {
				return cont;
			}
		}
		return -1;
	}

	public static Conta entrar(Scanner entrada) {
		try {
			Cliente clientinho = GerenciaCliente.selecionarCliente(entrada);
			if (clientinho.getCodCliente() != 0) {
				Conta continha = GerenciaConta.selecionarConta(clientinho, entrada);
				if (continha.getNumConta() != 0) {
					System.out.println("Insira a senha da conta");
					String senha = entrada.nextLine();
					if(continha.getSenha().equals(senha)) {
						return continha;
					} else {
						System.out.println("Senha incorreta!");
					}
				}
			}
		} catch (Exception e) {
			System.err.println("Erro ao logar na conta!");
		}
		return null;
	}

	// m�todo para mostrar todas as contas que est�o cadastradas no sistema
	public static void mostraContas() {
		Iterator<Conta> iterConta = Principal.lstContas.iterator();
		Conta contaAux = iterConta.next();
		String contas = "";
		for (int i = 0; i < Principal.lstContas.size(); i++) {
			contas += i + "- " + contaAux.toString() + "\n";
		}
		System.out.println(contas);
	}

}
