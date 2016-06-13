package com.java.practice.hibernate;

import org.hibernate.Session;

import com.java.practice.hibernate.entity.Account;
import com.java.practice.hibernate.entity.Employee;
import com.java.practice.hibernate.entity.FamilyMember;

public class AssociationTest {

	   public static void main(String[] args)
	   {
	      Session sessionOne = HibernateUtil.getSessionFactory().openSession();
	      sessionOne.beginTransaction();
	      org.hibernate.Query q=sessionOne.createQuery("from Employee");
	      // Create new Employee object
	      Employee emp = new Employee();
	      emp.setFirstName("Gaurava");
	      emp.setLastName("Agarwal");
	 
	      // Create new Employee object
	      Account acc = new Account();
	      acc.setAccountNumber("DUMMY_ACCOUNT");
	      emp.setAccount(acc);
	      acc.setEmployee(emp);
	 
	      //create family member
	      FamilyMember nisha= new FamilyMember();
	      nisha.setMemberName("Nisha");
	      nisha.setEmploye(emp);
	      FamilyMember ashita= new FamilyMember();
	      ashita.setMemberName("Ashita");
	      ashita.setEmploye(emp);
	      sessionOne.save(nisha);
	      sessionOne.save(ashita);
	      sessionOne.save(acc);
	      sessionOne.save(emp);
	      sessionOne.getTransaction().commit();
	      Integer genMemId = ashita.getMemberId();
	      Integer genEmpId = emp.getEmployeeId();
	      Integer genAccId  = acc.getAccountId();
	 
	      Session sessionTwo = HibernateUtil.getSessionFactory().openSession();
	      sessionTwo.beginTransaction();
	     // Employee employee = (Employee) sessionTwo.get(Employee.class, genEmpId);
	      Account account = (Account) sessionTwo.get(Account.class, genAccId);
	      FamilyMember member = (FamilyMember) sessionTwo.get(FamilyMember.class, genMemId);
	     // System.out.println(employee.getEmployeeId());
	     // System.out.println(employee.getAccount().getAccountNumber());
	     // System.out.println(employee.getMembers().size());
	      System.out.println(account.getAccountId());
	      System.out.println(account.getEmployee().getEmployeeId());
	      System.out.println(member.getMemberName());
	      System.out.println(member.getEmploye().getFirstName());
	 
	      HibernateUtil.shutdown();
	   }
	
}
