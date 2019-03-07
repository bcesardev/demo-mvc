package com.cesar.bruno.curso.boot.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "DEPARTAMENTOS")
public class Departamento extends AbstractEntity<Long> {

	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;

	/*
	 * Muitos cargos para um departamento, mappedBy necessário porque o
	 * relacionamento entre departamento e entidade será bidirecional. Então
	 * obrigatoriamento é necessário identificar qual o lado forte e qual o lado
	 * fraco da relação. O lado forte é o que possui a chave estrangeira (tabela
	 * Cargo). O mappedBy é para mostrar qual o atributo que faz parte do lado forte
	 * da relação, que é o "departamento".
	 */
	@OneToMany(mappedBy = "departamento")
	private List<Cargo> cargos;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

}
