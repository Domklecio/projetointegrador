package beans;

import java.io.Serializable;
import javax.persistence.*;

import persistencia.ProdutoDAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "produto")
public class Produto implements Serializable{

	private static final long serialVersionUID = -8023482526632579452L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pro_id")
	private int id;

	@Column(name = "pro_nome", length = 60, nullable = false)
	private String nome;

	@Column(name = "pro_preco", nullable = false)
	private float preco;
	
	@Column(name = "pro_prevista", nullable = false)
	private float vista;
	
	
	@Column(name = "descricao", length = 60, nullable = false)
	private String descricao;
	
	@Column(name = "pro_marca", length = 60, nullable = false)
	private String marca;

	
	@Column(name = "pro_tipo", length = 60, nullable = false)
	private String tipo;

	@Column(name = "pro_modelo", length = 60, nullable = false)
	private String modelo;
	
	
	   

	public float getVista() {
		return vista;
	}

	public void setVista(float vista) {
		this.vista = vista;
	}
	
	
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public float getPreco() {
		return preco;
	}
	
	public void setPreco(float preco) {
		this.preco = preco;
	}
	/*
	public float divisao(){
		if(Produto.getPreco() = getVista) {
			ProdutoDAO.inserir(Produto);
			Produto = new Produto();
			return actionInserir();
		} else {
			ProdutoDAO.alterar(produto);
			produto = new Produto();
			return "form_produto";
		}
	*/
	public List<String> getMarcaa() {
        return Arrays.asList(marca);
    }
     
    public List<Integer> getIdd() {
        return Arrays.asList(id);
    }
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + Float.floatToIntBits(preco);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id != other.id)
			return false;
		if (Float.floatToIntBits(preco) != Float.floatToIntBits(other.preco))
			return false;
		return true;
	}
	

	// Relacionamento de 1 para vários
	
	@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
	private List<Produto> produto = new ArrayList<Produto>();
	
	public List<Produto> getProduto(){
		return produto;
	}
	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	
}
