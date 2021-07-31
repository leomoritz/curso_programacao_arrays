package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Funcionario;

public class ProgramFuncionario {

	public static void main(String[] args) {

		// corre��o do exerc�cio: https://www.youtube.com/watch?v=Xj-osdBe3TE
		// c�digo professor: https://github.com/acenelio/list1-java

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Funcionario> lfunc = new ArrayList<>();
		Funcionario func = new Funcionario();

		// Cadastrando colaboradores (adicionando na lista)
		System.out.print("Quantos colaboradores ser�o registrados? ");
		int qtdFun = sc.nextInt();

		for (int i = 1; i <= qtdFun; i++) {
			System.out.println("\nEmployee #" + i + ":");
			System.out.print("ID: ");
			int codFun = sc.nextInt();
			while (func.validaCodFun(lfunc, codFun) == true) {
				System.out.println("ID j� existe. Informe um ID diferente");
				System.out.print("ID: ");
				codFun = sc.nextInt();
			}
			sc.nextLine();
			System.out.print("Nome: ");
			String nomFun = sc.nextLine();
			System.out.print("Sal�rio: ");
			double salFun = sc.nextDouble();
			func = new Funcionario(codFun, nomFun, salFun);
			lfunc.add(func);
		}

		// Listando os colaboradores adc (percorrendo valores da lista e impr..)
		System.out.println("\nLista de Colaboradores Adicionados: ");
		for (Funcionario x : lfunc) {
			System.out.println(x.toString());
		}

		// Aumento Salarial para o funcion�rio indicado por c�digo
		int lenght = 1;
		boolean achou = false;
		System.out.print("\nInforme o id do colaborador que dever� ter um " + "aumento salarial: ");
		int codFun = sc.nextInt();
		System.out.print("Informe o percentual de aumento: ");
		double percentualAumento = sc.nextDouble();
		for (Funcionario x : lfunc) {
			if (x.getCodFun() == codFun) {
				if (lfunc.indexOf(x) >= 0) {
					x.aumentoSalarial(percentualAumento);
					achou = true;
				}
			} else if (lenght == lfunc.size() & achou == false) {
				System.out.println("Colaborador n�o encontrado." + "Opera��o cancelada!");
			}
			lenght++;
		}

		// Listagem dos colaboradores atualizada.
		System.out.println("\nLista de Colaboradores Atualizada");
		for (Funcionario x : lfunc) {
			System.out.println(x.toString());
		}

		// Escolha o que deseja fazer (outras fun��es de lista):
		int opcao;
		do {
			System.out.println("\nEscolha uma op��o desejada conforme op��es abaixo: " 
					+ "\n 1 - Consultar colaborador"
					+ "\n 2 - Remover Elementos da Lista" 
					+ "\n 3 - Consultar posi��o colaborador por nome"
					+ "\n 4 - Listar colaborador por filtro" 
					+ "\n 5 - Listar 1� ocorr�ncia por filtro"
					+ "\n 6 - Quantidade de colaboradores cadastrados" 
					+ "\n 7 - Listagem Colaboradores "
					+ "\n 8 - Cancelar");
			
			opcao = sc.nextInt();

			switch (opcao) {
			case 1:
				System.out.println(consultaColaborador(lfunc));
				break;
			case 2:
				System.out.println(removerFuncionario(lfunc));
				break;
			case 3:
				System.out.println(consultaPorNome(lfunc));
				break;
			case 4:
				for (Funcionario x : listaFuncionarioLambda(lfunc)) {
					System.out.println(x.toString());
				}
				break;
			case 5:
				System.out.println(listaPrimeiraOcorrenciaLambda(lfunc).toString());
				break;
			case 6:
				System.out.println(lfunc.size());
				break;
			case 7:
				System.out.println("\nLista de Colaboradores Atualizada");
				for (Funcionario x : lfunc) {
					System.out.println(x.toString());
				}
				break;
			case 8:
				System.out.println("Programa encerrado!");
				break;
			default:
				System.out.println("Op��o n�o encontrada! Tente novamente.\n");
				break;
			}
		} while (opcao != 7);

		sc.close();
	}

	// Fun��es De Lista que s�o chamadas no switch case acima
	public static String consultaColaborador(List<Funcionario> lfunc) {
		Scanner sc = new Scanner(System.in);
		String colaborador = null;
		System.out.print("\nInforme o c�digo do colaborador: ");
		int codFun = sc.nextInt();
		for (Funcionario x : lfunc) {
			if (x.getCodFun() == codFun) {
				colaborador = x.toString();
			}
		}
		sc.close();
		if (colaborador != null) {
			return colaborador;
		} else {
			return "Colaborador n�o encontrado!";
		}

	}

	public static String removerFuncionario(List<Funcionario> lfunc) {
		Scanner sc = new Scanner(System.in);
		boolean removido = false;
		System.out.println("Informe o c�digo do colaborador para remover: ");
		int codFun = sc.nextInt();
		for (Funcionario x : lfunc) {
			if (x.getCodFun() == codFun) {
				lfunc.remove(x);
				removido = true;
			}
		}
		sc.close();
		if (removido == true) {
			return String.format("Colaborador %d removido com sucesso", codFun);
		}
		return "Colaborador n�o encontrado!";
	}

	public static String consultaPorNome(List<Funcionario> lfunc) {
		Scanner sc = new Scanner(System.in);
		String retorno = null;
		System.out.println("Informe o nome do colaborador: ");
		String nomeFun = sc.nextLine();
		for (Funcionario x : lfunc) {
			if (x.getNomFun().contains(nomeFun) && lfunc.indexOf(x) >= 0) {
				retorno = String.format("Colaborador %s � o %d da lista", x.getNomFun(), lfunc.indexOf(x));
			}
		}
		sc.close();
		if (retorno != null) {
			return retorno;
		} else {
			return "Colaborador n�o encontrado";
		}
	}

	public static List<Funcionario> listaFuncionarioLambda(List<Funcionario> lfunc) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Informe o c�digo do colaborador: ");
		int codFun = sc.nextInt();
		List<Funcionario> result = lfunc.stream().filter(x -> x.getCodFun() == codFun).collect(Collectors.toList());
		sc.close();
		return result;
	}

	public static Funcionario listaPrimeiraOcorrenciaLambda(List<Funcionario> lfunc) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o nome do Colaborador para encontrar a 1� ocorr�ncia: ");
		String nomeFun = sc.nextLine();
		Funcionario func = lfunc.stream().filter(x -> x.getNomFun().contains(nomeFun)).findFirst().orElse(null);
		sc.close();
		return func;
	}
}
