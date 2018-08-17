package com.samriddh.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actions")
public class PaymentController {
	private final String sharedKey = "SHARED_KEY";

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public boolean add(@RequestParam(value = "key") String key, @RequestBody Employee request) {
		System.out.println("Key ==> " + key);
		boolean r;
		MdbConnections mdb = new MdbConnections();
		if (sharedKey.equalsIgnoreCase(key)) {
			// Process the request
			// ....
			// Return success response to the client.
			System.out.println(request.getdetails());
			r = mdb.AddEmployee(request);
		} else {
			r=false;
		}
		return r;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public boolean edit(@RequestParam(value = "key") String key, @RequestBody Employee request) {
		System.out.println("Key ==> " + key);
		boolean r;
		MdbConnections mdb = new MdbConnections();
		if (sharedKey.equalsIgnoreCase(key)) {
			// Process the request
			// ....
			// Return success response to the client.
			System.out.println(request.getdetails());
			r = mdb.EditEmployee(request);
		} else {
			r=false;
		}
		return r;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public boolean delete(@RequestParam(value = "key") String key, @RequestBody Employee request) {
		System.out.println("Key ==> " + key);
		boolean r;
		MdbConnections mdb = new MdbConnections();
		if (sharedKey.equalsIgnoreCase(key)) {
			// Process the request
			// ....
			// Return success response to the client.
			System.out.println(request.getdetails());
			r = mdb.DeleteEmployee(request.getid());
		} else {
			r=false;
		}
		return r;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Records list(@RequestParam(value = "key") String key, @RequestBody Paging paging) {
		Records records = new Records();
		List<Employee> ls = new ArrayList<Employee>();
		MdbConnections mdb = new MdbConnections();
		if (sharedKey.equalsIgnoreCase(key)) {
			// Process the request
			// ....
			// Return success response to the client.
			ls = mdb.ListEmployee(paging.getOffset(), paging.getLimit());
			// ls = mdb.ListEmployee();
			records.setEmployees(ls);
		} else {
			Employee e = new Employee();
			try {
				e.setid("-1");
				e.setfirstname("Nothing");
				e.setlastname("here");
				e.setemail("nothing@here.com");
				ls.add(e);
				records.setEmployees(ls);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return records;
	}
}
