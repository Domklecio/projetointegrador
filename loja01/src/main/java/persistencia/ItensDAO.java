package persistencia;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.Item;


public class ItensDAO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public static void inserir(Item Item) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.save(Item);
		t.commit();
		sessao.close();
	}

	public static void alterar(Item Item) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.update(Item);
		t.commit();
		sessao.close();
	}
	
	public static void excluir(Item Item) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.delete(Item);
		t.commit();
		sessao.close();
	}
	
	public static List<Item> listagem(String filtro) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta;
		if(filtro.trim().length() == 0){
			consulta = sessao.createQuery("from itens_pedido order by ipe_id");
		} else {
			consulta = sessao.createQuery("from itens_pedido "
					+ "where ipe_id like :parametro order by ipe_id");
			consulta.setString("parametro", "%" + filtro + "%");
		}
		List<Item> lista = consulta.list();
		sessao.close();
		return lista;
	}

}
