package br.com.igorcrrea.todo.model;

public class Tarefa {

	private Integer id;
	private String descricao;
	private Integer feito;
	
	public Tarefa(Integer id, String descricao, Integer feito){
		this.id = id;
		this.descricao = descricao;
		this.feito = feito;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean getFeito() {
		if(feito==0) {
			return false;
		}else {
			return true;
		}
	}

	public void setFeito(Integer feito) {
		this.feito = feito;
	}
	
	@Override
	public String toString() {
		return "ID: "+id+"| Descricao: "+descricao+"| feito: "+this.getFeito();
	}
}
