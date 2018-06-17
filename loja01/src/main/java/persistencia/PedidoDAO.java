package persistencia;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import beans.Pedido;

public class PedidoDAO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public static void inserir(Pedido Pedido) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.save(Pedido);
		t.commit();
		sessao.close();
	}

	public static void alterar(Pedido Pedido) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.update(Pedido);
		t.commit();
		sessao.close();
	}
	
	public static void excluir(Pedido Pedido) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.delete(Pedido);
		t.commit();
		sessao.close();
	}
	
	public static List<Pedido> listagem(String filtro) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta;
		if(filtro.trim().length() == 0){
			consulta = sessao.createQuery("from pedido order by ped_id");
		} else {
			consulta = sessao.createQuery("from pedido "
					+ "where ped_id like :parametro order by ped_id");
			consulta.setString("parametro", "%" + filtro + "%");
		} 
		List<Pedido> lista = consulta.list();
		sessao.close();
		return lista;
	}

	public static Pedido listarUltimoPedidoAdicionado() {
		// TODO Auto-generated method stub
		return null;
	}

}

