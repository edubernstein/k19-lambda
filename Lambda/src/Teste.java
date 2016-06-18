import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Teste {

	public static void main(String[] args) {
		List<Conta> contas = new ArrayList<Conta>();
		Conta conta1 = new Conta(100);
		conta1.deposita(200);
		conta1.saca(300);
		Conta conta2 = new Conta(200);
		conta2.deposita(2000);
		conta2.saca(1000);
		Conta conta3 = new Conta(300);
		conta3.deposita(3000);
		conta3.saca(4000);
		Conta conta4 = new Conta(400);
		conta4.deposita(1000);
		conta4.saca(20);
		contas.add(conta1);
		contas.add(conta2);
		contas.add(conta3);
		contas.add(conta4);
		
		imprimeContasComSaldoNegativo(contas);
		imprimeContasComSaldoPositivo(contas);
		imprimeContas(contas, Teste::contaComSaldoNegativo);
		imprimeContas(contas, Teste::contaComSaldoPositivo);
		Predicate<Conta> p = Teste::contaComSaldoNegativo;
		Function<Conta, Boolean> f = Teste::contaComSaldoPositivo;
		imprimeContas(contas, p);
		imprimeContas(contas, f);
		
	}
	
	public static void imprimeContas(List<Conta> contas, Predicate<Conta> condicao) {
		System.out.println("### CONTAS ###");
		for (Conta c : contas) {
			if (condicao.test(c)) {
				System.out.println("Número: " + c.getNumero() + " - Saldo: " + c.getSaldo());
			}
		}
	}
	
	public static void imprimeContas(List<Conta> contas, Function<Conta, Boolean> condicao) {
		System.out.println("### CONTAS ###");
		for (Conta c : contas) {
			if (condicao.apply(c)) {
				System.out.println("Número: " + c.getNumero() + " - Saldo: " + c.getSaldo());
			}
		}
	}
	
	public static boolean contaComSaldoPositivo(Conta c) {
		return c.getSaldo() > 0;
	}
	
	public static boolean contaComSaldoNegativo(Conta c) {
		return c.getSaldo() < 0;
	}
	
	public static void imprimeContasComSaldoNegativo (List<Conta> contas) {
		System.out.println("### CONTAS COM SALDO NEGATIVO ###");
		for (Conta c : contas) {
			if (contaComSaldoNegativo(c)) {
				System.out.println("Número: " + c.getNumero() + " - Saldo: " + c.getSaldo());
			}
		}
	}
	
	public static void imprimeContasComSaldoPositivo (List<Conta> contas) {
		System.out.println("### CONTAS COM SALDO POSITIVO ###");
		for (Conta c : contas) {
			if (contaComSaldoPositivo(c)) {
				System.out.println("Número: " + c.getNumero() + " - Saldo: " + c.getSaldo());
			}
		}
	}

}
