package com.tyss.person;

import java.util.List;

public class TestPerson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Person();
		PersonDao d = new PersonDao();
		//d.savePerson(6, "ajay", 9326983, "ajay@gmail.com", "hello@123", 24);
          Person p5 = d.getPersonById(3);
          if(p5 != null) {
        	  System.out.println("Id is "+p5.id);
              System.out.println("name is "+p5.name);
              System.out.println("phone is "+p5.phone);
              System.out.println("email is "+p5.email);
              System.out.println("password is "+p5.pass);
             System.out.println("Age is "+p5.age);
          }
          else {
        	  System.out.println("Object not found");
          }
          
//		List<Person> al = d.getAllPerson();
//       System.out.println(al);
		//d.deleteHospital(2);
		d.validatePerson("venky@gmail.com", "1234@");
        
	}

}
