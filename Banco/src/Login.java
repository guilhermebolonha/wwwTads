import java.io.File;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Login {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		boolean sair1 = false;
		boolean sair2 = false;
		int op1, op2;
		int num = 0;
		String senhaRecuperada;
		String usuarioLogado;
		String statusLogin = "N�o h� nenhum usu�rio logado no sistema";
		String[] usuario = new String[10];
		String[] senha = new String[10];

		do {
			try {
				// Menu principal
				System.out.println("\nOl�\n" + statusLogin + "\n\nDig�te o n�mero correspondente a op��o desejada\n"
						+ "1 � Cadastro de usu�rio\r\n" + "2 � Fazer login\r\n" + "3 � Recuperar senha\r\n"
						+ "4 � Definir nova senha\r\n" + "0 � Encerrar programa\n");
				op1 = Integer.valueOf(entrada.nextLine());

				switch (op1) {
				case 1:
					usuario = cadastrarUsuario(num, usuario, entrada);
					senha = cadastrarSenha(num, senha, entrada);
					num++;
					break;
				case 2:
					usuarioLogado = login(usuario, senha, num, entrada);
					if (!usuarioLogado.equals("")) {
						statusLogin = usuarioLogado;
						do {
							try {
								System.out.println("\nOl�\n" + statusLogin
										+ "\n\nDig�te o n�mero correspondente a op��o desejada\n"
										+ "1 � Fazer logoff\r\n" + "0 � Encerrar programa");
								op2 = Integer.valueOf(entrada.nextLine());

								switch (op2) {
								case 1:
									sair2 = true;
									statusLogin = "N�o h� nenhum usu�rio logado no sistema";
									break;
								case 0:
									sair2 = true;
									sair1 = true;
									break;
								default:
									System.out.println("Op��o inv�lida");
									break;
								}
							} catch (Exception e) {
								System.out.println("Comando Inv�lido");
							}
						} while (!sair2);
					}
					break;
				case 3:
					senhaRecuperada = recuperarSenha(usuario, senha, num, entrada);
					System.out.println(senhaRecuperada);
					break;
				case 4:
					redefinirSenha(usuario, senha, num, entrada);
					break;
				case 0:
					sair1 = true;
					break;
				default:
					System.out.println("Op��o inv�lida");
					break;
				}
			} catch (Exception e) {
				System.out.println("Comando Inv�lido");
			}

		} while (!sair1);
		entrada.close();
	}

	public static String[] cadastrarUsuario(int num, String[] usuario, Scanner entrada) {
		String usuarioDigitado;
		String mensagem = "";
		boolean sair = false;

		do {
			boolean erro = false;
			System.out.println("Dig�te um novo nome de usu�rio");
			usuarioDigitado = entrada.nextLine();

			if (num > 0) {
				for (int i = 0; i < num; i++) {
					if (usuario[i].equals(usuarioDigitado)) {
						erro = true;
					}
				}
			}
			if (erro) {
				System.out.println("Nome de usu�rio indispon�vel!");
			} else {
				usuario[num] = usuarioDigitado;
				sair = true;
			}
		} while (!sair);
		return usuario;
	}

	public static String[] cadastrarSenha(int num, String[] senha, Scanner entrada) {
		boolean sair = false;
		do {
			System.out.println("Dig�te uma nova senha");
			senha[num] = entrada.nextLine();
			sair = true;
		} while (!sair);
		System.out.println("Usu�rio cadastrado com sucesso!");

		return senha;
	}

	public static String login(String[] usuario, String[] senha, int num, Scanner entrada) {
		boolean sair = false;
		boolean sair2 = false;
		int t = 0;
		String usuarioDigitado = "";
		String senhaDigitada;
		// Verificar se o usu�rio digitado corresponde aos registros
		if (num > 0) {
			do {
				System.out.println("Dig�te o nome do usu�rio, ou dig�te 0 para voltar ao menu");
				usuarioDigitado = entrada.nextLine();

				for (int i = 0; i < num; i++) {
					if (usuario[i].equals(usuarioDigitado)) {
						sair = true;
						t = i;
					}
				}
				if (usuarioDigitado.equals("0")) {
					sair = true;
					usuarioDigitado = "";
					sair2 = true;
				} else if (!sair) {
					System.out.println("Nome de usu�rio inexistente!");
				}
			} while (!sair);
			sair = false;
			// Verificar se a senha digitada corresponde aos registros
			while (!sair && !sair2) {
				System.out.println("Dig�te a senha, ou digite 0 para voltar ao menu");
				senhaDigitada = entrada.nextLine();
				if (senha[t].equals(senhaDigitada)) {
					sair = true;
				} else if (senhaDigitada.equals("0")) {
					usuarioDigitado = "";
					sair = true;
				} else {
					System.out.println("Senha incorreta!");
				}
			}
		} else {
			System.out.println("N�o h� usu�rios cadastrados no sistema");
		}

		return usuarioDigitado;
	}

	public static String recuperarSenha(String[] usuario, String[] senha, int num, Scanner entrada) {
		String usuarioDigitado;
		String senhaRecuperada = "";
		boolean sair = false;
		int t = -1;
		do {
			System.out.println("Dig�te seu nome de usu�rio");
			usuarioDigitado = entrada.nextLine();

			for (int i = 0; i < num; i++) {
				if (usuario[i].equals(usuarioDigitado)) {
					sair = true;
					t = i;
				}
			}
			if (sair) {
				senhaRecuperada = "Senha: " + senha[t];
			} else {
				sair = true;
			}
			if (t == -1) {
				senhaRecuperada = "Este usu�rio n�o est� cadastrado";
			}
		} while (!sair);
		return senhaRecuperada;
	}

	public static void redefinirSenha(String[] usuario, String[] senha, int num, Scanner entrada) {
		boolean sair = false;
		boolean sair2 = false;
		int t = 0;
		String usuarioDigitado = "";
		String senhaDigitada;
		// Verificar se o usu�rio digitado corresponde aos registros
		if (num > 0) {
			do {
				System.out.println("Dig�te o nome do usu�rio, ou dig�te 0 para voltar ao menu");
				usuarioDigitado = entrada.nextLine();

				for (int i = 0; i < num; i++) {
					if (usuario[i].equals(usuarioDigitado)) {
						sair = true;
						t = i;
					}
				}
				if (usuarioDigitado.equals("0")) {
					sair = true;
					usuarioDigitado = "";
					sair2 = true;
				} else if (!sair) {
					System.out.println("Nome de usu�rio inexistente!");
				}
			} while (!sair);
			sair = false;
			// Verificar se a senha digitada corresponde aos registros
			while (!sair && !sair2) {
				System.out.println("Dig�te a senha, ou digite 0 para voltar ao menu");
				senhaDigitada = entrada.nextLine();
				if (senha[t].equals(senhaDigitada)) {
					sair = true;
				} else if (senhaDigitada.equals("0")) {
					usuarioDigitado = "";
					sair = true;
				} else {
					System.out.println("Senha incorreta!");
				}
			}
		} else {
			System.out.println("N�o h� usu�rios cadastrados no sistema");
		}
		// Local para definir nova senha
		if (!usuarioDigitado.equals("")) {
			System.out.println("Defina sua nova senha");
			senha[t] = entrada.nextLine();
			System.out.println("Senha redefinida com sucesso!");
		}
	}
}