package pxu.hibernateBaitap.repository;

import java.util.List;

import pxu.hibernateBaitap.entity.company;


public interface CompanyRepository {
	public List<company> getCompany();

	public void saveCompany(company theCompany);

	public company getCompany(int theId);

	public void deleteCompany(int theId);
}