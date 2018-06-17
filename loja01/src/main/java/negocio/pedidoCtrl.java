package negocio;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


import beans.FormaPgto;
import beans.Produto;
import beans.Pedido;
import persistencia.ProdutoDAO;
import persistencia.FormaPgtoDAO;
import persistencia.PedidoDAO;

@ManagedBean
@SessionScoped

public class pedidoCtrl implements Serializable {
		
		private static final long serialVersionUID =1L;
		private Pedido Pedido = new Pedido();
		private String filtro = "";
		public Pedido getPedido() {
			return Pedido;
		}
		public void setPedido(Pedido Pedido) {
			this.Pedido = Pedido;
		}
		public String getFiltro() {
			return filtro;
		}
		public void setFiltro(String filtro) {
			this.filtro = filtro;
		}
		
		public List<Pedido>getListagem(){
			return PedidoDAO.listagem(filtro);
		}
		
		public String actionGravar() {
			FacesContext context = 	FacesContext.getCurrentInstance();
			if(Pedido.getId() == 0) {
				PedidoDAO.inserir(Pedido);
				context.addMessage(null, new FacesMessage("Sucesso",  "Inserido com sucesso!") );
			}
			else {
				PedidoDAO.alterar(Pedido);
				context.addMessage(null, new FacesMessage("Sucesso",  "Alterado com sucesso!") );
			}
			return "/admin/lista_Pedido";
		}
		
		public String actionInserir() {
			Pedido = new Pedido();
			return "/admin/lista_pedido";
		}
		
		public String actionExcluir() {
		PedidoDAO.excluir(Pedido);
			 return "/admin/lista_pedido";
			 
		}
		
		
}
