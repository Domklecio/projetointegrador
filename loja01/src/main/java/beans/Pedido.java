package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;

import javax.persistence.*;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable{

	private static final long serialVersionUID = -8023482526632579452L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ped_id")
	private int id;
	
	@Column(name = "ped_dataEmissao", nullable = true)
	private Date dataEmisao;
	@Column(name = "ped_status", length = 20, nullable = false)
	private String status;
	@Column(name = "ped_dataAutorizacao", nullable = true)
	private Date dataAutorizacao;
	@Column(name = "ped_total", nullable = false)
	private double pedidoTotal;
	@Column(name = "ped_desconto", nullable = false)
	private float desconto;
	
	public  int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Date getDataEmisao() {
		return dataEmisao;
	}
	public void setDataEmisao(Date dataEmisao) {
		this.dataEmisao = dataEmisao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDataautorizacao() {
		return dataAutorizacao;
	}
	public void setIDataautorizacao(Date dataAutorizacao) {
		this.dataAutorizacao = dataAutorizacao;
	}
	public double getPedidototal() {
		return pedidoTotal;
	}
	public void setPedidototal(double pedidoTotal) {
		this.pedidoTotal = pedidoTotal;
	}
	public float getDesconto() {
		return desconto;
	}
	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}
	@ManyToOne
	@JoinColumn (name="pes_id")
	private Pessoa pessoa;

	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	@ManyToOne
	@JoinColumn (name="fpg_id")
	private FormaPgto formaPgto;


	public FormaPgto getFormaPgto() {
		return formaPgto;
	}
	public void setFormaPgto(FormaPgto formaPgto) {
		this.formaPgto = formaPgto;
	}
	
	// Relacionamento de 1 para vários
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<Item> itens = new ArrayList<Item>();

	public List<Item> getItens() {
		return itens;
	}
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	

}
