package it.unirc.txw.prototipo.beans.studente;

import java.util.Date;

public class Studente {
	private int matricola;
	private String nome;
	private Date dataDiNascita;
	private Integer cdl;
	


	public Studente() {
		super();
	}

	public Studente(int matricola, String nome, Date dataDiNascita, Integer cdl) {
		super();
		this.matricola = matricola;
		this.nome = nome;
		this.dataDiNascita = dataDiNascita;
		this.cdl = cdl;
	}

	public int getMatricola() {
		return matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public Integer getCdl() {
		return cdl;
	}

	public void setCdl(Integer cdl) {
		this.cdl = cdl;
	}

	@Override
	public String toString() {
		return "Studente [matricola=" + matricola + ", nome=" + nome + ", dataDiNascita=" + dataDiNascita + ", cdl="
				+ cdl + "]";
	}
	
	

}
