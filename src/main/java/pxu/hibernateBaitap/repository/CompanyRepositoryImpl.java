package pxu.hibernateBaitap.repository;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import pxu.hibernateBaitap.entity.company;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyRepositoryImpl implements CompanyRepository{

	@Autowired
	private SessionFactory sessionFactory; 
	
	@Override
	public List<company> getCompany() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<company> cq = cb.createQuery(company.class);
		Root<company> root = cq.from(company.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void saveCompany(company theCompany) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theCompany);
	}

	@Override
	public company getCompany(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		company theCustomer = currentSession.get(company.class, theId);
		return theCustomer;
	}

	@Override
	public void deleteCompany(int theId) {
		Session session = sessionFactory.getCurrentSession();
		company book = session.byId(company.class).load(theId);
		session.delete(book);
		
	}

}
