package beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "fone")
public class Fone implements Serializable{
	
	private static final long serialVersionUID = -8023482526632579452L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fon_id")
	private int id;	
	@Column(name = "fon_numero", length = 20, nullable = true)
	private int numero;
	@Column(name = "fon_descricao", length = 30, nullable = true)
	private String descricao;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	// Relacionamento de varios para 1
	

	@ManyToOne
	@JoinColumn(name="pes_id")
	private Pessoa pessoa;
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
}
