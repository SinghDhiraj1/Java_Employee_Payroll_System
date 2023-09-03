import java.util.*;
abstract class Employee{
    private String name;
    private int id;

    public abstract double calculateSalary();

    public Employee(String name, int id){
        this.name = name;
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }

    @Override
    public String toString(){
        return "Employee[name : "+name+", id : "+id+", salary : "+calculateSalary()+"]";
    }
}

class fullTimeEmployee extends Employee{
    private double monthlySalary;

    public fullTimeEmployee(String name, int id, double monthlySalary){
        super(name, id);
        this.monthlySalary = monthlySalary;
    }
    @Override
    public double calculateSalary(){
        return monthlySalary;
    }
}

class partTimeSalary extends Employee{

    private int hoursWorked;

    private double hourlyRate;

    public partTimeSalary(String name, int id, int hoursWorked, double hourlyRate){
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary(){
        return hoursWorked * hourlyRate;
    }
}
class PayrollSystem{
    private ArrayList<Employee> employeeList;

    public PayrollSystem(){
        employeeList = new ArrayList<>();
    }
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeeToRemove = null;
        //iterate to check the employee with id = id
        for(Employee employee:employeeList){
            if(employee.getId() == id){
                //replace the employeeToRemove to employee
                employeeToRemove = employee;
                break;
            }
        }

        if(employeeToRemove != null){
            //remove the employee from the employeeList
            employeeList.remove(employeeToRemove);
        }
    }
    public void displayEmployee(){
        for(Employee employee:employeeList){
            System.out.println(employee);
        }
    }
}


public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        fullTimeEmployee emp1 = new fullTimeEmployee("Rohit Garud", 1, 15000);
        partTimeSalary emp2 = new partTimeSalary("Anurag Krishnan", 2, 40, 50);
        partTimeSalary emp3 = new partTimeSalary("Dhiraj Singh", 3, 40 , 0);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        payrollSystem.addEmployee(emp3);
        System.out.println("Display all Employees");
        payrollSystem.displayEmployee();
        System.out.println("Remove a Employee");
        payrollSystem.removeEmployee(3);
        System.out.println("Display final Employees");
        payrollSystem.displayEmployee();

    }
}