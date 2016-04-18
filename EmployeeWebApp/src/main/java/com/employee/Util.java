package com.employee;

public class Util {
	
	public static Employee generateEmployee()
	{
		Employee emp = new Employee();
		int i = (int) ((Math.random()* 10)+1);
		emp.setID(""+i);
		emp.setFirstName("FirstN"+i);
		emp.setLastName("LastN"+i);
		emp.setAddress("CHENNAI"+i);
		emp.setLoggedInUserCaasId("User"+i);
		return emp;
	}

}
