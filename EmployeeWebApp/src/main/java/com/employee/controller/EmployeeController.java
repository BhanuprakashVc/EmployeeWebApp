/**
 * 
 */
package com.employee.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.employee.Employee;
import com.employee.Util;
import com.employee.VIEWS.Operations;

/**
 * @author 308040
 * 
 */
@Controller
@RequestMapping("/")
@SessionAttributes({ "user" })
public class EmployeeController {
	
	private List<Employee> empList;
	
	/**
	 * @return the empList
	 */
	public List<Employee> getEmpList() {
		return empList;
	}

	/**
	 * @param empList the empList to set
	 */
	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}

	public EmployeeController()
	{
		empList = new ArrayList<>();
		for(int i=0; i < 5; i++){
			empList.add(Util.generateEmployee());
		}
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(@RequestParam(value = "lang", required = false)
    final String lang, final Model uiModel, final HttpServletRequest request,
			final HttpServletResponse response) {

		Employee emp = new Employee();
		
        String cassId = ((User) (SecurityContextHolder.getContext().getAuthentication().getPrincipal())) .getUsername();
        emp.setLoggedInUserCaasId(cassId);
        emp.setFirstName("FirstName");
        emp.setLastName("LastName");
        emp.setID("12345");
        emp.setAddress("US");
        emp.setLang("ENGLISH");
        uiModel.addAttribute("user", emp);

		return Operations.WELCOME.getOperations();
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.POST)
	public String submitWelcome(@ModelAttribute("emp") Employee emp, 
			@RequestParam(value="operation", required=false) String operation,
			Model uiModel,
			final HttpServletRequest request,
			final HttpServletResponse response) {

		// System.out.println("Operation done: "+operation);
		// System.out.println("User retrieved from Welcome page: " + emp.getFirstName());
		uiModel.addAttribute(emp);
		return Operations.create.getOperations();
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String createEmp(@ModelAttribute("emp") Employee emp,
			Model uiModel,
			HttpServletRequest request,
			HttpServletResponse response) {

		getEmpList().add(emp);
		// System.out.println("Successfully "+ emp.getFirstName()+ " Employee is added to Employee Association");
		return "redirect:showAll";
	}
	
	@RequestMapping(value = "/showAll", method = RequestMethod.GET)
	public ModelAndView showAllEmp(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("showAll", "empList",getEmpList());
	}

	
	@RequestMapping(value = "showAll/{id}/{firstName}/{lastName}/{address}/{loggedInUserCaasId}", method = RequestMethod.POST)
	public ModelAndView updatePageToShow(@PathVariable("id") String id,@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName, 
			@PathVariable("address") String address,
			@PathVariable("loggedInUserCaasId") String loggedInUserCaasId,  @RequestParam(value="operation", required=false) String operation, HttpServletRequest request,
			HttpServletResponse response) {

		Employee empToUpdate = null;
		String viewPage = "";
		viewPage = (operation.equalsIgnoreCase("update") ? ("update") :("delete"));
		empToUpdate = new Employee();
		empToUpdate.setID(id);
		empToUpdate.setFirstName(firstName);
		empToUpdate.setLastName(lastName);
		empToUpdate.setAddress(address);
		empToUpdate.setLoggedInUserCaasId(loggedInUserCaasId);
		
		return new ModelAndView(viewPage, "emp",empToUpdate);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updateEmp(@ModelAttribute("emp") Employee empToUpdate, @RequestParam(value="operation", required=false) String operation, HttpServletRequest request,
			HttpServletResponse response) {
		
		if(operation.equalsIgnoreCase("update")) {
			for(Employee emp : getEmpList()){
				if(emp.getID().equals(empToUpdate.getID()) || emp.getFirstName().equals(empToUpdate.getFirstName())
						 || emp.getLastName().equals(empToUpdate.getLastName())
						 || emp.getAddress().equals(empToUpdate.getAddress())
						 || emp.getLoggedInUserCaasId().equals(empToUpdate.getLoggedInUserCaasId()))
					{
						emp.setID(empToUpdate.getID());
						emp.setFirstName(empToUpdate.getFirstName());
						emp.setLastName(empToUpdate.getLastName());
						emp.setAddress(empToUpdate.getAddress());
						emp.setLoggedInUserCaasId(empToUpdate.getLoggedInUserCaasId());
						break;
					}
			}
		}
		
		return new ModelAndView("showAll", "empList",getEmpList());
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	// @ResponseBody 
	public ModelAndView deleteEmp(@ModelAttribute("emp") Employee empToDelete, @RequestParam(value="operation", required=false) String operation, HttpServletRequest request,
			HttpServletResponse response) {
		if(operation.equalsIgnoreCase("delete")) {
			for(Employee emp : getEmpList()){
				if(emp.getID().equals(empToDelete.getID()) || emp.getFirstName().equals(empToDelete.getFirstName())
						 || emp.getLastName().equals(empToDelete.getLastName())
						 || emp.getAddress().equals(empToDelete.getAddress())
						 || emp.getLoggedInUserCaasId().equals(empToDelete.getLoggedInUserCaasId()))
					{
						getEmpList().remove(emp);
						break;
					}
			}
		}
		
		return new ModelAndView("showAll", "empList",getEmpList());
	}

}
