package com.orgmange;

import java.util.List;

public class FormatEmployees {
    private List<Employee> fillEmployees(){
        return List.of(new Employee("Иван Иванов", 20, "IT", 50000.0),
        new Employee("Петр Петров", 30, "HR", 60000.0),
        new Employee("Анна Снатко", 35, "Finance", 70000.0),
        new Employee("Илья Балахнин", 37, "Marketing", 55000.0),
        new Employee("Татьяна Ким", 49, "Sales", 65000.0));
    }

    private List<String> format(List<Employee> employees){
        return employees.stream()
                .map(Employee::toString)
                .toList();
    }

    public void run(){
        List<Employee> employees = fillEmployees();
        System.out.println(format(employees));
    }
}
class Employee{
    private String fullName;
    private Integer age;
    private String department;
    private Double salary;

    public Employee(String fullName, Integer age, String department, Double salary) {
        this.fullName = fullName;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString(){
        return "%s - %s".formatted(fullName, department);
    }
}