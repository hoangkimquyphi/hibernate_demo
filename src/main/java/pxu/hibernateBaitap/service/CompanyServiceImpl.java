package pxu.hibernateBaitap.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pxu.hibernateBaitap.entity.company;
import pxu.hibernateBaitap.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private CompanyRepository companyDAO;
	
	@Override
	@Transactional
	public List<company> getCompany() {
		// TODO Auto-generated method stub
		return companyDAO.getCompany();
	}

	@Override
	@Transactional
	public void saveCompany(company theCompany) {
		// TODO Auto-generated method stub
		companyDAO.saveCompany(theCompany);
		
	}

	@Override
	@Transactional
	public company getCompany(int theId) {
		// TODO Auto-generated method stub
		return companyDAO.getCompany(theId);
	}

	@Override
	@Transactional
	public void deleteCompany(int theId) {
		// TODO Auto-generated method stub
		companyDAO.deleteCompany(theId);
	}

}
