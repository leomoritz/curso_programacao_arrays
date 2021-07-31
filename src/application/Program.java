package application;

import java.util.Scanner;

import entities.Aluguel;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Aluguel[] aluguel = new Aluguel[10];

		System.out.print("Informe a quantidade de quartos a ser reservado: ");
		int qtdQuartos = sc.nextInt();

		for (int i = 0; i < qtdQuartos; i++) {
			sc.nextLine();
			System.out.printf("\nReserva #%d:\nNome do estudante: ", i+1);
			String nome = sc.nextLine();
			System.out.print("Email do estudante: ");
			String email = sc.nextLine();
			System.out.print("Número do quarto a ser reservado (0-9): ");
			int numQuarto = sc.nextInt();
			aluguel[numQuarto] = new Aluguel(nome, email);
		}

		System.out.println("\nQuartos Reservados: ");
		for (int i = 0; i < aluguel.length; i++) {
			if (aluguel[i] != null) {
				System.out.println(i + ": " + aluguel[i]);
			}
		}

		sc.close();

	}

}
