package com.javatechie.springboot.restful.api.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javatechie.springboot.restful.api.model.Payment;

@Repository
@Transactional
public class PaymentDaoImpl implements PaymentDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public String payNow(Payment payment) {
	
		Session session=sessionFactory.getCurrentSession();
		session.save(payment);
		return "Payment successfull with amount : "+payment.getAmount();
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Payment> getTransactionInfo(String vendor) {
		
		Session session=sessionFactory.getCurrentSession();
		                    Criteria c=session.createCriteria(Payment.class).add(Restrictions.eq("vendor", vendor));
		                 @SuppressWarnings("unchecked")
						List<Payment> l=c.list();
		return l;
	}

}
