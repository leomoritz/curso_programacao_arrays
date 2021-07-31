package entities;

import java.util.List;

public class Funcionario {

	private Integer codFun;
	private String nomFun;
	private Double salFun;

	public Funcionario() {

	}

	public Funcionario(int codFun, String nomFun, double salFun) {
		this.codFun = codFun;
		this.nomFun = nomFun;
		this.salFun = salFun;
	}

	public String getNomFun() {
		return nomFun;
	}

	public void setNomFun(String nomFun) {
		this.nomFun = nomFun;
	}

	public Integer getCodFun() {
		return codFun;
	}

	public Double getSalFun() {
		return salFun;
	}

	public boolean validaCodFun(List<Funcionario> lfunc, int codFun) {
		for (Funcionario x : lfunc) {
			if (x.getCodFun() == codFun) {
				return true;
			}
		}
		return false;
	}

	public void aumentoSalarial(double percentualAumento) {
		this.salFun += this.salFun * (percentualAumento / 100);
	}

	public String toString() {
		return this.codFun + ", " + this.nomFun + String.format(", R$%.2f", this.salFun);
	}

}
