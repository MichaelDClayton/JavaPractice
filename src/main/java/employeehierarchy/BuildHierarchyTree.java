package employeehierarchy;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuildHierarchyTree {
	
	private Map<Integer, Employee> employees = new HashMap<>(); //stores (id, employee) pair
	private Employee root;
	
	//Read data and build map, Iteration, Time O(n), Space O(n), n is number of employees
	public void readDataAndCreateMap(String[] lines)  {        		
		Employee employee = null;
		for (String strLine : lines) { 			
			String[] values = strLine.split(" ");
			if (values.length >= 4)  						
				employee = new Employee(values[0], values[1] + " " + values[2], values[3]);
			else 
				employee = new Employee(values[0], values[1] + " " + values[2], "0");
			employees.put(employee.id, employee);
			if (employee.managerId == 0) 
				root = employee;
		}
	}
	
	 //Build tree, Recursion, Time O(n), Space O(h), n is number of employees, h is levels of hierarchy tree
	 public void buildHierarchyTree(Employee root) {
         List<Employee> subs = getSubsById(root.id);
		 root.subordinates = subs;
		 if (subs.isEmpty())
			 return;
		 for (Employee em : subs) 
	    	buildHierarchyTree(em);
	 }	 
	 
	//Get subordinates list by given id, Time O(n), Space O(k) ~ O(n), k is number of subordinates
	private List<Employee> getSubsById(int managerId) {
		 List<Employee> subs = new ArrayList<Employee>();
		 for (Employee em : employees.values()) {
			 if (em.managerId == managerId) 
				 subs.add(em);
		 }
		 return subs;
	}
		 
	//Print tree, Recursion, Time O(n), Space O(h)
	public void printHierarchyTree(Employee root, int level) {
		for (int i = 0; i < level; i++) 
			System.out.print("\t");	 
		System.out.println(root.name);		 
		List<Employee> subs = root.subordinates;
		for (Employee em : subs) 
			printHierarchyTree(em, level+1);
	}
	 
	public static void main(String[] args) {		  
		 String[] lines = {
				 "1 Rob Choi 6",
				 "2 Paul Marmolejo 5",
				 "3 Lois Lemer 6",
				 "4 Christie Jacobs 5",
				 "5 Moises Medina 6",
				 "6 Joseph Grant",
				 "7 Andy Zuckeman 1",
				 "8 Melaney Partner 3",
				 "9 Cliff Gannett 5",
				 "10 Mark O'Donnell 1"
		 };	   
		 BuildHierarchyTree tree = new BuildHierarchyTree();
	     tree.readDataAndCreateMap(lines);
	     tree.buildHierarchyTree(tree.root);
	     tree.printHierarchyTree(tree.root, 0);
	}
}