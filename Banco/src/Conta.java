public abstract class Conta {
	protected static int numConta;
	protected int numeroAg;
	protected int codCliente;
	protected double saldo;
	private static int maxNumConta = 1000;

	public Conta(int numeroAg, int codCliente, double saldo, double limite) {
		this.numConta = maxNumConta++;
		this.numeroAg = numeroAg;
		this.saldo = saldo;
		this.codCliente = codCliente;
	}
	protected Conta(int numeroAg,  int codCliente) {
		this.numConta = maxNumConta++;
		this.numeroAg = numeroAg;
		this.saldo = 0.0;
		this.codCliente = codCliente;
	}

	@Override
	public boolean equals(Object obj) {
		Conta conta = (Conta) obj;
		return this.numConta == conta.numConta;
	}
	
	public boolean sacar(double valor) {
		final double txOperacao = 0.5;
		if(valor > 0) {
		this.saldo -= valor * (1 + (txOperacao) / 100);
		return true;
		}
		return false;
		
	}

	public void depositar(double valor) {
		if (valor > 0) {
			this.saldo += valor;
			System.out.println("Opera��o aprovada");
		} else {
			System.out.println("Valor inv�lido");
		}

	}
	
	public static String registrarHistorico(String[] historico, int cont, double valor) {
		String saidaHistorico = "";
		// Registar no vetor as transa��es de dep�sito
		if (valor > 0) {
			historico[cont] = "Dep�sito de R$" + valor + ".";
			saidaHistorico += "\n" + historico[cont];
		}
		// Registrar no hist�rico as transa��es de saque
		else if (valor < 0) {
			valor = -(valor);
			historico[cont] = "Saque de R$" + valor + ".";
			saidaHistorico += "\n" + historico[cont];
		}
		return saidaHistorico;
	}

	
	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public int getAgencia() {
		return numeroAg;
	}

	public void setAgencia(int numeroAg) {
		numeroAg = numeroAg;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getMaxNumConta() {
		return maxNumConta;
	}

	public void setMaxNumConta(int maxNumConta) {
		this.maxNumConta = maxNumConta;
	}

	public void deposito(double valorDeposito) {
		// TODO Auto-generated method stub
	}
	@Override
	public String toString() {
		return "Conta [numConta=" + numConta + ", numeroAg=" + numeroAg + ", saldo=" + saldo
				+ "]";
	}
}