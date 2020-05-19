package labolatorio1;

import java.util.regex.Pattern;

public class Conta {
	private double saldo;
	private String numero;
	
	public Conta(String numero) {
		this.numero = numero;
	}
	public void depositar(double valor) {
		saldo += valor;
	}
	
	public void sacar(double valor) {
		saldo -= valor;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nSALDO:");
		sb.append(saldo);
		sb.append("\nNUMERO DA CONTA:");
		sb.append(numero);
		sb.append("\n");
		return sb.toString();
	}
	public double getSaldo() {
		return saldo;
	}
	public String getNumero() {
		return numero;
	}
	
	public static final boolean testaNumero(String numero) {
		
		Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
		
		if(numero==null || numero.isEmpty()) {
			return false;
		}
		return pattern.matcher(numero).matches();
	}
	
}
