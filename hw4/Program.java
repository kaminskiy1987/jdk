package jdk.hw4;

import java.time.LocalDate;

public class Program {
    public static void main(String[] args) {
        EmployeeList employees = new EmployeeList(10);
        Employee worker1 = new Employee("Alexey","12345", LocalDate.of(2010,1,10));
        Employee worker2 = new Employee("Boris","23456", LocalDate.of(2011,1,11));
        Employee worker3 = new Employee("Vladimir","34567", LocalDate.of(2012,2,12));
        Employee worker4 = new Employee("Grigory","45678", LocalDate.of(2012,3,13));
        Employee worker5 = new Employee("Denis","56789", LocalDate.of(2014,4,14));
        Employee worker6 = new Employee("Denis","123456", LocalDate.of(2015,5,15));
        Employee worker7 = new Employee("Pavel","234567", LocalDate.of(2016,6,16));

        employees.add(worker1);
        employees.add(worker2);
        employees.add(worker3);
        employees.add(worker4);
        employees.add(worker5);
        employees.add(worker6);
        employees.add(worker7);

        System.out.println(employees.getEmployeeByNo(1002));
        System.out.println(employees.getEmployeesByExp(11));
        System.out.println(employees.getPhone("Denis"));
    }
}