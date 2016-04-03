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
@SessionAttributes({ "emp" })
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
        emp.setFirstName(cassId.toUpperCase());
        emp.setLastName("VC");
        emp.setID("1");
        emp.setLang("ENGLISH");
        uiModel.addAttribute("emp", emp);

		return Operations.WELCOME.getOperations();
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.POST)
	public String submitWelcome(@ModelAttribute("emp") Employee emp, 
			@RequestParam(value="operation", required=false) String operation,
			Model uiModel,
			final HttpServletRequest request,
			final HttpServletResponse response) {

		System.out.println("Operation done: "+operation);
		System.out.println("User retrieved from Welcome page: " + emp.getFirstName());
		uiModel.addAttribute(emp);
		return Operations.create.getOperations();
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	//@ResponseBody
	public String createEmp(@ModelAttribute("emp") Employee emp,
			Model uiModel,
			HttpServletRequest request,
			HttpServletResponse response) {

		getEmpList().add(emp);
		System.out.println("Successfully "+ emp.getFirstName()+ " Employee is added to Employee Association");
		// return "Successfully "+ emp.getFirstName()+ " Employee is added to Employee Association";
		return "redirect:showAll";
	}
	
	@RequestMapping(value = "/showAll", method = RequestMethod.GET)
	public ModelAndView showAllEmp(HttpServletRequest request,
			HttpServletResponse response) {
		// empModel.addAttribute("empList", getEmpList());
		return new ModelAndView("showAll", "empList",getEmpList());
	}
	
	@RequestMapping(value = "/showAll", method = RequestMethod.POST)
	public ModelAndView UpdateEmp(@ModelAttribute("emp") Employee emp, HttpServletRequest request,
			HttpServletResponse response) {
		// empModel.addAttribute("empList", getEmpList());
		return new ModelAndView("update", "emp",emp);
	}


	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView updateEmp(@ModelAttribute("emp")Employee emp, HttpServletRequest request,
			HttpServletResponse response) {

		for(Employee empE : getEmpList()){
			if(empE.getID() == emp.getID()){
				empE.setFirstName(emp.getFirstName());
				empE.setLastName(emp.getLastName());
				empE.setLang(emp.getLang());
				empE.setAddress(emp.getAddress());
			}
		}
		return new ModelAndView("updatedMessage");
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView deleteEmp(Model empModel, HttpServletRequest request,
			HttpServletResponse response) {

		return new ModelAndView("delete");
	}

	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView readEmp(Model empModel, HttpServletRequest request,
			HttpServletResponse response) {

		return new ModelAndView("search");
	}
	
}
