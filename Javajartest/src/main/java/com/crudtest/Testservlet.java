package com.crudtest;

import java.io.IOException;
import java.io.PrintWriter;
//import com.task2.Getalldata;
//import com.training.Employees;
//import com.task2.Updatedata;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.*;

import com.google.gson.Gson;

public class Testservlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try {
		String empid = request.getParameter("id");

			int i = Integer.parseInt(empid);
			Hashtable<Integer, Employees> tab = new Hashtable<Integer, Employees>();
			tab.put(1, new Employees(1, "arun", 50000, "contract"));
			tab.put(2, new Employees(2, "varun", 60000, "Permanent"));
			tab.put(3, new Employees(3, "arav", 70000, "Parttime"));
			
			if(tab.get(i)!=null) {
				out.println(new Gson().toJson(tab.get(i)));	
			}else {
				out.println("{Message: No data found}");
			}
		} catch (Exception e) {
			out.println("{message:'"+e+"'");
			
		}
	}

}

class Employees {
	int empcode;
	String empname;
	double salary;
	String emprole;

	public Employees(int empcode, String empname, double salary, String emprole) {
		this.empcode = empcode;
		this.empname = empname;
		this.salary = salary;
		this.emprole = emprole;
	}

	@Override
	public String toString() {
		return "{" + "empcode:" + empcode + ", empname:'" + empname + '\'' + ", salary:" + salary
				+ ", emprole:'" + emprole + '\'' + '}';
	}
}
