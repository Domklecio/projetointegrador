package beans;


import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


public class Item {

	private Integer quantidade;
	private Produto produto;
	private float subtotal;
	private float valorunit;

	

		
	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	public double getValorunit() {
		return valorunit;
	}

	public void setValorunit(float valorunit) {
		this.valorunit = valorunit;
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}


	@ManyToOne
	@JoinColumn(name="ped_id")
	private Pedido pedido;

	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	
	
	

}
