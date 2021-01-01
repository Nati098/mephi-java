package ru.mephi.module05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Company {

    private String name;
    private double[] monthProfits;

    HashMap<Class, ArrayList<Employee>> empls = new HashMap<>();
    ArrayList<Employee> firedEmpls = new ArrayList<>();

    public Company(String name, double[] mprofits){
        this.name = name;
        this.monthProfits = mprofits;
    }

    public HashMap<Class, ArrayList<Employee>> getEmployees(){
        return this.empls;
    }

    public void hireEmployee(Employee newEmp, Class classEmp){
        if (! this.empls.containsKey(classEmp)){
            this.empls.put(classEmp, new ArrayList<>());
        }

        this.empls.get(classEmp).add(newEmp);
    }

    public void fireEmp(int empId){

        for (Map.Entry<Class, ArrayList<Employee>> entry : this.empls.entrySet()){

            for (int i=0; i < entry.getValue().size(); i++){
                Employee e = entry.getValue().get(i);

                if (e.getId() == empId){

                    this.firedEmpls.add(e);
                    this.empls.get(e.getClass()).remove(e);
                    return;
                }
            }
        }

        System.err.println("Fire: There is no such employee");
    }

    public void changePosition(int empId, Class newClass, double ... newParams){
        for (Map.Entry<Class, ArrayList<Employee>> entry : this.empls.entrySet()){

            for (int i=0; i < entry.getValue().size(); i++){

                Employee e = entry.getValue().get(i);

                if (e.getId() == empId){

                    if (entry.getKey().equals(newClass)){
                        System.err.println("ChangePosition: Employee is already in this position");
                        return;
                    }

                    entry.getValue().remove(e);

                    e.setRate(newParams[0]);
                    e.setFactor(newParams[1]);
                    this.empls.get(newClass).add(e);
                    return;
                }
            }

        }

        System.err.println("ChangePosition: There is no such employee");
    }

    public void printEmplsInfo(){
        System.out.println("\n\n================About Employees================");

        for (Map.Entry<Class, ArrayList<Employee>> entry : this.empls.entrySet()){

            entry.getValue().forEach((e) -> e.printInfo());
        }
    }

    public void printMonthSalaries(int month){
        System.out.println("\n\n================Salary for "+month+" month================");

        for (Map.Entry<Class, ArrayList<Employee>> entry : this.empls.entrySet()){

            System.out.println("\nClass "+entry.getKey().getSimpleName()+":");
            entry.getValue().forEach((e) -> System.out.printf("%s\t\t%.2f\n",
                    e.getName(), e.countSalary(this.monthProfits[month])));
        }
    }

    public void printYearSalaries(){
        System.out.println("\n\n================Year salaries================");

        for (Map.Entry<Class, ArrayList<Employee>> entry : this.empls.entrySet()){

            System.out.println("\nClass "+entry.getKey().getSimpleName()+":");
            entry.getValue().forEach((e) ->System.out.printf("%s\t\t%.2f\n", e.getName(),
                    e.countYearSalary(this.monthProfits)));
        }
    }

    public void printStatistics(){

        System.out.println("\n\n================TOTAL Statistics================");

        int count = 0;
        ArrayList<Double> monthSalaries = new ArrayList<>();
        ArrayList<Double> yearSalaries = new ArrayList<>();

        for (Map.Entry<Class, ArrayList<Employee>> entry : this.empls.entrySet()){

            count += entry.getValue().size();

            entry.getValue().forEach((e) -> {
                monthSalaries.add(e.countMeanMonthSalary(this.monthProfits));
                yearSalaries.add(e.countYearSalary(this.monthProfits));
            });
        }

        System.out.println("Total number of employees = "+count);
        System.out.printf("Mean month salary = %.2f\n", monthSalaries.stream().mapToDouble(a -> a).sum() / monthSalaries.size());
        System.out.printf("Mean year salary = %.2f \n\n", yearSalaries.stream().mapToDouble(a -> a).sum() / yearSalaries.size());
    }

    public void printGroupStatistics(){
        System.out.println("\n\n================Statistics by groups================");

        for (Map.Entry<Class, ArrayList<Employee>> entry : this.empls.entrySet()){

            System.out.println("Class "+entry.getKey().getSimpleName()+":");

            int count = entry.getValue().size();

            double meanMonthSalary = entry.getValue().stream()
                    .mapToDouble(e -> e.countMeanMonthSalary(this.monthProfits)).sum() / count;
            double yearSalary = entry.getValue().stream()
                    .mapToDouble(e -> e.countYearSalary(this.monthProfits)).sum() / count;

            System.out.println("Number of employees = "+count);
            System.out.printf("Mean month salary = %.2f\n",+meanMonthSalary);
            System.out.printf("Mean year salary = %.2f \n\n", yearSalary);
        }
    }

}