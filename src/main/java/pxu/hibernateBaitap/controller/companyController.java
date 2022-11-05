package pxu.hibernateBaitap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pxu.hibernateBaitap.entity.company;
import pxu.hibernateBaitap.service.CompanyService;

@Controller
@RequestMapping("/company")
public class companyController {

	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		List<company> theCompany = companyService.getCompany();
		theModel.addAttribute("company", theCompany);
		return "list-company";
	}
	
	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		company theCompany = new company();
		theModel.addAttribute("company", theCompany);
		return "company-form";
	}
	
	@PostMapping("/saveCompany")
	public String saveCustomer(@ModelAttribute("company") company theCompany) {
		companyService.saveCompany(theCompany);	
		return "redirect:/company/list";
	}
	
	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("companyId") int theId,
									Model theModel) {
		company theCompany = companyService.getCompany(theId);	
		theModel.addAttribute("company", theCompany);
		return "company-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("companyId") int theId) {
		companyService.deleteCompany(theId);
		return "redirect:/company/list";
	}
}
