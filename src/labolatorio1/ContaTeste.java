package labolatorio1;

import java.util.ArrayList;
import java.util.Scanner;

public class ContaTeste {

	public static void main(String[] args) {
		System.out.println("Carregando...");

		Scanner sc = new Scanner(System.in);

		ArrayList<Conta> bancoContas = new ArrayList<Conta>();

		int opcao;
		do {
			System.out.printf(
					"\nO QUE DESEJA FAZER? \n1) - CRIAR UMA CONTA \n2) - DEPOSITAR \n3) - SACAR \n4) - CONSULTAR SALDO \n0) - ENCERRAR\n");
			opcao = sc.nextInt();
			sc.nextLine();
			
			if (opcao == 1) {
				boolean numeroValido = true;
				System.out.println("Digite o número da conta a ser criada:");
				String numero = sc.nextLine();
				while (numeroValido) {
					if (Conta.testaNumero(numero) == true && bancoContas.isEmpty()) {
						break;
					}
					if (Conta.testaNumero(numero) == false) {
						System.out.println("Forneça um número válido:");
						numero = sc.nextLine();

					}

					for (int i = 0; i < bancoContas.size(); i++) {
						if (bancoContas.get(i).getNumero().equals(numero) == true
								|| Conta.testaNumero(numero) == false) {
							numeroValido = true;
						} else {
							numeroValido = false;
						}

					}
					if (numeroValido == true) {
						System.out.println("Forneça um número válido:");
						numero = sc.nextLine();
					}
				}

				Conta x = new Conta(numero);
				bancoContas.add(x);
				System.out.println(x.toString());
				System.out.print("_____________________________________________");
			}


			if (opcao == 2) {
				System.out.println("Digite o número da conta a ser depositada:");
				String numero = sc.next();
				sc.nextLine();
				boolean achou = false;
				int indice = 0;
				for (Conta x : bancoContas) {
					if (x.getNumero().equals(numero)) {
						System.out.println("Numero encontrado:");
						achou = true;
						indice = bancoContas.indexOf(x);
						break;
					}
				}
				if (achou == true) {

					System.out.println("Informe o valor a ser depositado:");
					double valor = sc.nextDouble();
					sc.nextLine();
					bancoContas.get(indice).depositar(valor);
					System.out.printf("\nSaldo atual da conta após o depósito: %.2f\n",
							bancoContas.get(indice).getSaldo());

				} else {
					System.out.println("Numero de conta não encontrado!");
				}
				System.out.print("_____________________________________________");
			}
			
			if (opcao == 3) {
				System.out.println("Digite o número da conta a ser sacada:");
				String numero = sc.nextLine();
				boolean achouSaque = false;
				boolean saldo = false;
				for (Conta x : bancoContas) {
					if (x.getNumero().equals(numero)) {
						achouSaque = true;
						System.out.println("Informe o valor a ser sacado:");
						double valor = sc.nextDouble();
						sc.nextLine();
						if (valor > x.getSaldo()) {
							System.out.println("Saldo insuficiente!!!");
							break;
						} else {
							x.sacar(valor);
							System.out.printf("\nSaldo atual da conta após o saque: %.2f\n", x.getSaldo());
							break;
						}
					}

				}
				if (achouSaque == false) {
					System.out.println("Numero de conta não encontrado.");
				}
				System.out.print("_____________________________________________");
			}
			if (opcao == 4) {
				System.out.println("Digite o número da conta a ser consultado o saldo:");
				String numeroSaldo = sc.nextLine();
				boolean achou = false;
				for (Conta x : bancoContas) {
					if (x.getNumero().equals(numeroSaldo)) {
						achou = true;
						System.out.println(x.toString());
						break;
					}
				}
				if (achou == false) {
					System.out.println("Conta não encontrada!!!");

				}
				System.out.print("_____________________________________________");

			}
		} while (opcao != 0);
		sc.close();
		System.out.println("Encerrando o sistema...");

	}

}
