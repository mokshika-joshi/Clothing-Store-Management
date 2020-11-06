package com.cdac.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.cdac.dto.Product;
@Repository
public class ProductDaoimple implements ProductDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void insertProduct(Product product) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.save(product);
				tr.commit();
				session.flush();
				session.close();
				return null;
				
				
				
			}
			
		});
	}

	@Override
	public void deleteProduct(int ProductId) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.delete(new Product(ProductId));
				tr.commit();
				session.flush();
				session.close();
				return null;
				
				
				
			}
			
		});
		
	}

	@Override
	public Product selectProduct(int ProductId) {
		Product product = hibernateTemplate.execute(new HibernateCallback<Product>() {

			@Override
			public Product doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Product pr = (Product)session.get(Product.class, ProductId);
				tr.commit();
				session.flush();
				session.close();
				return pr;
				
			}
			
		});
		return product;
	}

	@Override
	public void updateProduct(Product product) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.update(product);
				tr.commit();
				session.flush();
				session.close();
				return null;
				
				
				
			}
			
		});
		
	}

	@Override
	public List<Product> selectAll() {
		List<Product> prList = hibernateTemplate.execute(new HibernateCallback<List<Product>>() {

			@Override
			public List<Product> doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("From Product");
			
				List<Product> li = q.list();
				System.out.println(li);
				tr.commit();
				session.flush();
				session.close();
				
				return li;
			}
			
		});
		return prList;
	}

}
