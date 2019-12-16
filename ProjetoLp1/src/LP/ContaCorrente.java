package LP;

import java.io.Serializable;
import java.util.Scanner;

public class ContaCorrente extends Conta implements Serializable {
	private double limite;
	private double juros = 0.03;
	private double tarifa = 20;

	static Scanner entrada = new Scanner(System.in);
	

	public ContaCorrente(int cod){
		super(cod);
	}
	
	public ContaCorrente( double saldo, double limite, Cliente cliente, String senha) {
		super(saldo, cliente, senha);
		this.limite = limite;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public double getJuros() {
		return juros;
	}

	public double getTarifa() {
		return tarifa;
	}

	public void viraMes() {
		this.saldo -= this.saldo * juros;
		this.saldo -= tarifa;
		
	}

	public boolean sacar(double valor) {

		double limiteSaque = this.saldo + this.limite;

		if (limiteSaque >= valor) {
			this.saldo -= valor;
			System.out.println("Operação aprovada");
			return true;
		}
		System.out.println("Saldo insuficiente");
		return false;
		
	}


	@Override
	public String toString() {
		return "ContaCorrente [limite=" + limite + ", saldo=" + saldo + ", codigoConta=" + codigoConta + ", cliente="
				+ cliente + "]";
	}

	
}
