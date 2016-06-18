
public class Conta {
	private int numero;
	private double saldo;

	public Conta(int numero) {
		this.numero = numero;
	}

	public void deposita (double valor) {
		this.saldo += valor;
	}

	public void saca (double valor) {
		this.saldo -= valor;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}
}
