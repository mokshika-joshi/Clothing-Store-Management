package com.cdac.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.cdac.dto.Cart;
import com.cdac.dto.Product;


@Repository
public class CartDaoImple implements CartDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public void insertCart(Cart cart) {

		
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				System.out.println(cart);
				session.save(cart);
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
			
		});
	}

	@Override
	public List<Cart> showCartAll(int custId) {

		
		List<Cart> itemList = hibernateTemplate.execute(new HibernateCallback<List<Cart>>() {

			@Override
			public List<Cart> doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from Cart  where custId=?");
				q.setInteger(0, custId);
				List<Cart> li = q.list();
				System.out.println(li); 
				tr.commit();
				session.flush();
				session.close();
				return li;
			}
			
		});
		return itemList;
	}

	@Override
	public boolean deleteCart(int cartId) {
		boolean flag = hibernateTemplate.execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session) {
				try {
					Transaction tr = session.beginTransaction();
					SQLQuery q = session.createSQLQuery("delete from cart where cartId = ?");
					q.setInteger(0, cartId);
					System.out.println("Inside cart dao");
					int row = q.executeUpdate();
					tr.commit();
					session.flush();
					session.close();
					if(row > 0)
						return true;
				}
				catch(HibernateException h) {
					session.flush();
					session.close();
					return false;
				}
				return false;
			}
		});
		return flag;

		
	}
	
	@Override
	public boolean deleteUserRecords(int custId) {
		boolean flag = hibernateTemplate.execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				Transaction tr = session.beginTransaction();
				try {
					SQLQuery q = session.createSQLQuery("delete from cart where custId = ?");
					q.setInteger(0, custId);
					int row = q.executeUpdate();
					tr.commit();
					session.flush();
					session.close();
					if(row > 0)
						return true;
					return false;
				}
				catch(HibernateException e) {
					session.flush();
					session.close();
				}
				catch (Exception e) {
					session.flush();
					session.close();
				}
				return false;
			}
		});
		return flag;
	}


	@Override
	public Cart showCart(int ProductId) {
		Cart cart = hibernateTemplate.execute(new HibernateCallback<Cart>() {

			@Override
			public Cart doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Cart c = (Cart)session.get(Cart.class, ProductId);
				tr.commit();
				session.flush();
				session.close();
				return c;
			}
			
		});
		return cart;
	}

	
	

}
