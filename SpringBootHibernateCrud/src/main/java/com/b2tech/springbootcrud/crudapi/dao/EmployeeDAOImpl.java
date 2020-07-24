package com.b2tech.springbootcrud.crudapi.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.b2tech.springbootcrud.crudapi.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

	@Autowired
	private EntityManager entityManager;
	
	
	@Override
	public List<Employee> get() {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		Criteria cr = session.createCriteria(Employee.class);
		List<Employee> em=cr.list();
		
		return em;
	}

	@Override
	public Employee get(int id) {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		Employee emp=session.get(Employee.class,id);
		return emp;
	}

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		session.saveOrUpdate(employee);
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		Employee emp=session.get(Employee.class, id);
		session.delete(emp);
		
	}

}
