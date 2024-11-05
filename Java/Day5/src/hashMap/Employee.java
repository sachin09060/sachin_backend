package hashMap;

import java.util.HashMap;
import java.util.Map.Entry;

import java.util.Scanner;
import java.util.Set;

public class Employee {
	
    private String name;
    private String designation;
    private String department;
    
    public Employee() {
        super();
    }
    
    public Employee(String name, String designation, String department) {
        super();
        this.name = name;
        this.designation = designation;
        this.department = department;
    }
    
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDesignation() {
        return designation;
    }
    
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    
    public String toString() {
        return this.name+" "+this.designation+" "+this.department+" ";
    }
    

	public static void main(String[] args) {
		HashMap<Integer,Employee> employees = new HashMap<>();
//		LinkedHashMap<Integer, Employee> details = new LinkedHashMap<>();
		Scanner scanner = new Scanner(System.in);
		
		
        
//        details.put(1, new Employee("sachin", "Trainee", "Java"));
//        details.put(2, new Employee("akshay", "Trainee", "Java"));
//        details.put(3, new Employee("someone", "Trainee", "Python"));

//        Set<Entry<Integer, Employee>> entrySet = details.entrySet();
//        
//        for(Entry<Integer, Employee> entry: entrySet) {
//        	System.out.println(entry.getKey()+ "-------->" + entry.getValue());
//        }
        
        while(true) {
            
            System.out.println("Enter Id of Employee: ");
            Integer id = scanner.nextInt();
        	
            System.out.println("Enter Name of Employee: ");
            String name = scanner.next();
            
            System.out.println("Enter designation of Employee: ");
            String designation = scanner.next();
            
            System.out.println("Enter department of Employee: ");
            String department = scanner.next();
            
            System.out.println("Do you want to add some more employees ?");
            String data = scanner.next();
            
            employees.put(id, new Employee(name, designation, department));

            if(!data.equalsIgnoreCase("yes"))
                break;
        }
        
      Set<Entry<Integer, Employee>> entrySet = employees.entrySet();
      
      for(Entry<Integer, Employee> entry: entrySet) {
      	System.out.println(entry.getKey()+ "  -------->  " + entry.getValue());
      }
        scanner.close();
		
	}

}