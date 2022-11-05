package pxu.hibernateBaitap.service;

import java.util.List;

import pxu.hibernateBaitap.entity.company;

public interface CompanyService {
	public List<company> getCompany();

	public void saveCompany(company theCompany);

	public company getCompany(int theId);

	public void deleteCompany(int theId);
}
