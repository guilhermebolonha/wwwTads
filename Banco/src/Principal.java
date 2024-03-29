import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Principal {

	//Autores: Guilherme e Hiago.
	
	protected static ArrayList<Agencia> lstAgencias = new ArrayList();
	protected static ArrayList<Conta> lstContas = new ArrayList();
	protected static ArrayList<Cliente> lstClientes = new ArrayList();
	protected static ArrayList<Gerente> lstGerentes = new ArrayList();
	protected static ArrayList<Pessoa> lstPessoas = new ArrayList();

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		boolean sair = false;
		int menu1 = 100;

//		lstAgencias = GerenciaArquivo.lerObj("Agencias");
//		lstContas = GerenciaArquivo.lerObj("Contas");
//		lstClientes = GerenciaArquivo.lerObj("Clientes");
//		lstGerentes = GerenciaArquivo.lerObj("Gerentes");
//		lstPessoas = GerenciaArquivo.lerObj("Pessoas");

		do {
			try {
				System.out.println("Informe a op��o desejada senhor(a)" + "\n1 - Cadastro" + "\n2 - Exclus�o"
						+ "\n3 - Consultar dados" + "\n4 - Logar em conta" + "\n0 - Sair do sistema");
				menu1 = Integer.valueOf(entrada.nextLine());

				switch (menu1) {
				case 1:
					menuCadastro(entrada);
					break;
				case 2:
					menuExclusao(entrada);
					break;
				case 3:
					menuConsultaDados(entrada);
					break;
				case 4:
					Conta continha = GerenciaConta.entrar(entrada);
					if(continha != null) {
						menuOperacoesBancarias(continha, entrada);						
					}
					break;
				case 0:
					GerenciaArquivo.gravaObj(lstAgencias, "Agencias");
					GerenciaArquivo.gravaObj(lstContas, "Contas");
					GerenciaArquivo.gravaObj(lstClientes, "Clientes");
					GerenciaArquivo.gravaObj(lstGerentes, "Gerentes");
					GerenciaArquivo.gravaObj(lstPessoas, "Pessoas");
					sair = true;
					break;
				default:
					System.out.println("Op��o inv�lida!");
					break;
				}

			} catch (Exception e) {
				System.err.println("Erro!");
			}
		} while (!sair);

	}

	private static void menuOperacoesBancarias(Conta continha, Scanner entrada) {
		boolean sair = false;
		do {
			System.out.println("Qual opera��o banc�ria deseja realizar?" + "\n1- Ver saldo" + "\n2- Depositar "
					+ "\n3- Sacar" + "\n4- Transferir" + "\n5- Virar o m�s" + "\n6- Ver extrato"+ "\n0 - Voltar ao menu principal");
			int menu2 = Integer.valueOf(entrada.nextLine());
			try {
				switch (menu2) {
				case 1:
					System.out.println("Saldo: R$" + continha.getSaldo());
					break;
				case 2:
					System.out.println("Digite o valor que deseja depositar");
					double valorDeposito = Double.valueOf(entrada.nextLine());
					
					Operacao operacaoD = new Deposito(continha, valorDeposito);

					if (operacaoD.efetuar())
						continha.lstOperacoes.add(operacaoD);
					else {
						System.err.println("N�o foi possivel realizar");
					}
					break;
				case 3:

					System.out.println("Digite o valor que deseja sacar");
					double valor2 = Double.valueOf(entrada.nextLine());

					Operacao operacao = new Saque(continha, valor2);

					if (operacao.efetuar())
						continha.lstOperacoes.add(operacao);
					else {
						System.err.println("N�o foi possivel realizar");
					}
					break;
				case 4:
					Cliente clientinho = GerenciaCliente.selecionarCliente(entrada);
					if (clientinho != null) {
						Conta contaDestino = GerenciaConta.selecionarConta(clientinho, entrada);
						if (contaDestino.getNumConta() > 0 && contaDestino.getNumConta() != continha.getNumConta()) {
							
							System.out.println("Insira o valor que deseja transferir");
							double valor = Double.valueOf(entrada.nextLine());
							Operacao operacaoTransfer = new Transferencia(valor, continha, contaDestino);
							if (operacaoTransfer.efetuar())
								continha.lstOperacoes.add(operacaoTransfer);
							else {
								System.err.println("N�o foi possivel realizar");
							}
						}
					}
					break;
				case 5:
					if (continha instanceof ContaCorrente) {
						Operacao operacaoT = new Tarifacao(continha);  
						if (operacaoT.efetuar()) {
							
						}
					} else {
						Operacao operacaoT = new Rendimento(continha);
					}
					continha.viraMes();
					System.out.println("M�s virado");
					break;
				case 6:
					
					System.out.println(continha.extrato());
					break;
				case 0:
					sair = true;
					break;
				default:
					System.out.println("Op��o inv�lida");
					break;
				}
			} catch (Exception e) {
				System.err.println("Erro!");
			}
		} while (!sair);
	}

	private static void menuConsultaDados(Scanner entrada) {
		boolean sair = false;
		do {
			System.out.println("O que deseja consultar?" + "\n1- Clientes" + "\n2- Ag�ncias" + "\n3- Gerentes"
					+ "\n4- Contas" + "\n5- Pessoas" + "\n6- Hist�rico de opera��es" + "\n0 - Voltar ao menu anterior");

			int menu2 = Integer.valueOf(entrada.nextLine());
			try {
				switch (menu2) {
				case 1:
					System.out.println(lstClientes.toString());
					break;
				case 2:
					System.out.println(lstAgencias.toString());
					break;
				case 3:
					System.out.println(lstGerentes.toString());
					break;
				case 4:
					System.out.println(lstContas.toString());
					break;
				case 5:
					System.out.println(lstPessoas.toString());
					break;
				case 6:
					Cliente clientinho = GerenciaCliente.selecionarCliente(entrada);
					if (clientinho.getCodCliente() != 0) {
						Conta continha = GerenciaConta.selecionarConta(clientinho, entrada);
						if (continha.getNumConta() != 0) {
							continha.lstOperacoes.toString();
						}
					}
				case 0:
					sair = true;
					break;
				default:
					System.out.println("Op��o inv�lida");
					break;
				}

			} catch (Exception e) {
				System.err.println("Erro!");
			}
		} while (!sair);
	}

	private static void menuExclusao(Scanner entrada) {
		boolean sair = false;
		do {
			System.out.println("O que deseja Excluir?" + "\n1- Clientes" + "\n2 - Ag�ncias" + "\n3 - Gerentes"
					+ "\n4 - Contas" + "\n0 - Voltar ao menu anterior");

			int menu2 = Integer.valueOf(entrada.nextLine());
			try {
				switch (menu2) {
				case 1:
					GerenciaCliente.excluirCliente(entrada);

					break;
				case 2:
					if (lstAgencias.size() > 0) {
						Agencia ag = GerenciaAgencia.selecionarAgencia(entrada);
						int numAgencia = ag.getNumeroAg();

						if (GerenciaAgencia.cancelarAgencia(numAgencia)) {
							System.out.println("Agencia cancelada com sucesso");
						} else {
							System.out.println("Falha ao cancelar agencia");
						}
					} else {
						System.out.println("N�o possui nenhuma ag�ncia cadastrada");
					}

					break;
				case 3:
					if (lstGerentes.size() > 0) {
						Gerente excluido = GerenciaGerente.selecionarGerente(entrada);

						if (GerenciaGerente.cancelarGerente(excluido.getCodGerente())) {
							System.out.println("Gerente excluido com sucesso");
						} else {
							System.out.println("Falha ao excluir gerente");
						}
					} else {
						System.out.println("N�o existe nenhum gerente cadastrado");
					}

					break;
				case 4:
					GerenciaConta.mostraContas();
					System.out.println("Informe o n�mero da conta");
					int numConta = Integer.valueOf(entrada.nextLine());
					if (GerenciaConta.CancelarConta(numConta)) {
						System.out.println("Conta excluida com sucesso");
					} else {
						System.out.println("Falha ao excluir conta");
					}
					break;
				case 0:
					sair = true;
					break;
				default:
					System.out.println("Op��o inv�lida");
					break;
				}
			} catch (Exception e) {
				System.err.println("Erro!");
			}
		} while (!sair);
	}

	private static void menuCadastro(Scanner entrada) {
		boolean sair = false;
		do {
			System.out.println("O que deseja cadastrar?" + "\n1- Clientes" + "\n2 - Ag�ncias" + "\n3 - Gerentes"
					+ "\n4 - Contas" + "\n0 - Voltar ao menu anterior");

			int menu2 = Integer.valueOf(entrada.nextLine());
			try {
				switch (menu2) {
				case 1:
					if (GerenciaCliente.criarCliente(entrada)) {
						System.out.println("Cliente cadastrado com sucesso");
					}
					break;
				case 2:
					if (GerenciaAgencia.criarAgencia(entrada)) {
						System.out.println("Ag�ncia cadastrada com sucesso");
					}
					break;
				case 3:
					if (GerenciaGerente.cadastraGerente(entrada)) {
						System.out.println("Gerente cadastrado com sucesso!");
					} else {
						System.out.println("Falha ao cadastrar o gerente!");
					}
					break;
				case 4:
					GerenciaConta.cadastraConta(entrada);
					break;
				case 0:
					sair = true;
					break;
				default:
					System.out.println("Op��o inv�lida");
					break;
				}
			} catch (Exception e) {
				System.err.println("Erro!");
			}
		} while (!sair);
	}
}
