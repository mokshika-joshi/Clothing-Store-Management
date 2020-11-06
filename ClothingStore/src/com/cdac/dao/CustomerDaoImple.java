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

import com.cdac.dto.Customer;

@Repository
public class CustomerDaoImple implements CustomerDao{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public void insertCustomer(Customer customer) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr=session.beginTransaction();
				session.save(customer);
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
		});
		
	}

	@Override
	public boolean checkCustomer(Customer customer) {
		
		boolean b= hibernateTemplate.execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {
				Transaction tr=session.beginTransaction();
				Query q=session.createQuery("from Customer where email=? and custPass=?");
				q.setString(0, customer.getEmail());
				q.setString(1, customer.getCustPass());
				List<Customer> li=q.list();
				System.out.println(li);
				boolean flag=!li.isEmpty();
			
				customer.setCustId(li.get(0).getCustId());
				customer.setCustName(li.get(0).getCustName());
				tr.commit();
				session.flush();
				session.close();
				return flag;
			}
		});
		return b;
	}

	@Override
	public String findPassword(String custEmail) {
		String password = hibernateTemplate.execute(new HibernateCallback<String>() {

			@Override
			public String doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from Customer where email = ?");
				q.setString(0, custEmail);
				List<Customer> li = q.list();
				String pass = null;
				if(!li.isEmpty())
					pass = li.get(0).getCustPass();
				tr.commit();
				session.flush();
				session.close();
				return pass;
			}
			
		});
		return password;

	}

}
