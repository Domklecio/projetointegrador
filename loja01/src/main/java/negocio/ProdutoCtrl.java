package negocio;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import beans.Produto;
import persistencia.ProdutoDAO;

@ManagedBean
@SessionScoped
public class ProdutoCtrl implements Serializable {

	private static final long serialVersionUID = 1L;

	private Produto produto;

	public Produto getProduto() {
		if(produto == null) {
			produto = new Produto();
		}
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public List<Produto> getListagem() {
		return ProdutoDAO.listagem("");
	}
	
	
	public List<Produto> getDados() {
		return ProdutoDAO.dados("");
	}
	public String actionGravar(){
		if(produto.getId() == 0) {
			ProdutoDAO.inserir(produto);
			produto = new Produto();
			return actionInserir();
		} else {
			ProdutoDAO.alterar(produto);
			produto = new Produto();
			return "form_produto";
		}
	}
	public String actionInserir() {
		produto = new Produto();
		return "form_produto";
	}
	
	public String actionExcluir(Produto p){
		ProdutoDAO.excluir(p);
		return "form_produto";
	}
	
	public String actionAlterar(Produto p){
		this.produto = p;
		return "form_produto";
	}
	
	@ManagedBean
	public class GrowlView {
	     
	    private String message;
	 
	    public String getMessage() {
	        return message;
	    }
	 
	    public void setMessage(String message) {
	        this.message = message;
	    }
	  
	}
}
