package com.employee;

public class Util {
	
	public static Employee generateEmployee()
	{
		Employee emp = new Employee();
		int i = (int) ((Math.random()* 10)+1);
		emp.setID(""+i);
		emp.setFirstName("First"+i);
		emp.setLastName("last"+i);
		emp.setAddress("CHENNAI"+i);
		emp.setLoggedInUserCaasId(""+(i * 100000));
		return emp;
	}

}
