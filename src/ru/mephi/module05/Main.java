package ru.mephi.module05;

import java.util.Random;

public class Main {

    private static void generateEmployees(Company company){

        Random rand = new Random();

        for (int i=0; i < 10; i++) {
            company.hireEmployee(new HourlyEmployee(i, "he"+i, 100+rand.nextDouble()*10000, 20), HourlyEmployee.class);
        }

        for (int i=0; i < 10; i++) {
            company.hireEmployee(new SalariedEmployee(i+10, "se"+i, 1000+rand.nextDouble()*10000), SalariedEmployee.class);
        }

        for (int i=0; i < 5; i++) {
            company.hireEmployee(new Manager(i+20,"m"+i, 3500+rand.nextDouble()*100000, rand.nextDouble()), Manager.class);
        }

        for (int i=0; i < 2; i++) {
            company.hireEmployee(new Executive(i+25, "e"+i, 7000+rand.nextDouble()*100000, rand.nextDouble()), Executive.class);
        }

    }

    public static void main(String[] args) {
        double[] monthProfit = {500, 300, 1000, 4000, 6000, 2300,
                                11000, 700, 4500, 19000, 30000, 23000};
        Company company = new Company("Example", monthProfit);

        // hiring
        generateEmployees(company);

        // firing
        company.fireEmp(50);
        company.fireEmp(16);

        //change position
        company.changePosition(50, Manager.class);
        company.changePosition(3, HourlyEmployee.class);
        double[] newParams = {500,0};
        company.changePosition(3, SalariedEmployee.class, newParams);

        // print info
        company.printEmplsInfo();
        company.printMonthSalaries(4);
        company.printYearSalaries();
        company.printStatistics();
        company.printGroupStatistics();
    }

}
