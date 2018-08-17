package details;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Store {
	private HashMap<String, Employee> hashMap = new HashMap<String, Employee>();

	public boolean search(String id) {
		return hashMap.containsKey(id);
	}
	
	public boolean AddEmployee(Employee e) {
		if (hashMap.containsKey(e.getId())) {
			System.out.println("id is already in use");
			return false;
		}
		hashMap.put(e.getId(), e);
		System.out.println("New Employee added " + e.getdetails());
		return true;
	}

	public boolean EditEmployee(Employee r) {
		if (hashMap.containsKey(r.getId())) {
			hashMap.put(r.getId(),r);
			System.out.println("Edited Employee " + r.getdetails());
			return true;
		}else {
			System.out.println("No such id exist");
			return false;
		}
	}

	public boolean DeleteEmployee(String id) {
		return hashMap.remove(id) != null ? true : false;
	}

	public List<Employee> ListEmployee() {//java-8
		List<Employee> ls = new ArrayList<Employee>(hashMap.values());
		return ls;
	}
	
	/*public List<Employee> Find(String n){
		List<Employee> ls = new ArrayList<Employee>(hm.values());
		return ls;
	}*/
}
