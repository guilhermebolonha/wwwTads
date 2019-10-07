import java.util.Iterator;
import java.util.Scanner;

public class GerenciaConta {
		public static Conta selecionarConta(Scanner entrada) {
			Iterator<Conta> iterConta = Principal.lstContas.iterator();
			String contas = "Insira o c�digo da conta desejada\n";
			Conta contaAux;
			boolean continuar = true;
			try {
				while (continuar) {
					if (iterConta.hasNext()) {
						contaAux = iterConta.next();
						for (int i = 0; i < Principal.lstContas.size(); i++) {
							contas += i + "- " + contaAux.toString() + "\n";
						}
						contas += "ou digite -1 para cancelar";
						System.out.println(contas);
						int index = Integer.valueOf(entrada.nextLine());
						if (index >= 0 && index <= (Principal.lstContas.size() - 1)) {
							return Principal.lstContas.get(index);
						} else if (index == -1) {
							continuar = false;
						}
					}
				}
			} catch (Exception e) {
				System.out.println("Entrada Inv�lida!!");
			}
			return null;
		}
		//cadastra a conta no array list
		public static void cadastraContaCorrente(Scanner entrada) {
			Cliente clientezinho = GerenciaCliente.selecionarCliente(entrada);
			int agencia = clientezinho.getNumeroAg();
			Conta novaConta = new ContaCorrente(agencia, clientezinho.getCodCliente());
			try {
				 if (Principal.lstContas.add(novaConta)) {
					System.out.println("Conta cadastrada com sucesso");
				}else {
					System.out.println("A conta n�o foi cadastrada");
				}

			} catch (Exception e) {
				System.err.println("Quebrou");
			}
		}
		//cadastra a conta no array list
				public static void cadastraContaPoupanca(Scanner entrada) {
					Cliente clientezinho = GerenciaCliente.selecionarCliente(entrada);
					int agencia = clientezinho.getNumeroAg();
					Conta novaConta = new ContaPoupanca(agencia, clientezinho.getCodCliente());
					try {
						 if (Principal.lstContas.add(novaConta)) {
							System.out.println("Conta cadastrada com sucesso");
						}else {
							System.out.println("A conta n�o foi cadastrada");
						}

					} catch (Exception e) {
						System.err.println("Quebrou");
					}
				}
		//exclui uma conta desejada
		public static boolean CancelarConta (int numConta){
			int indice = LocalizarConta(numConta);	
			if (indice != -1){
				Principal.lstContas.remove(indice);
				return true;
			}else{ 
				return false;
			}				
		}
		//metodo que busca uma bonta dentro do arraylist e retorna sua posi��o 
		private static int LocalizarConta (int numero){  
			for (int cont = 0; cont < Principal.lstContas.size(); cont++){
				Conta conta = Principal.lstContas.get(cont);
				
				if (conta.getNumConta() == numero){								
					return cont;
				}
			}		
				return -1;
		}
		//m�todo para mostrar todas as contas que est�o cadastradas no sistema
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
