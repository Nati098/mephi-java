package ru.mephi.module05;

public abstract class Employee {

    int id;
    String name;
    double rate;
    double factor;

    public Employee(int id, String name, double rate){
        this.id = id;
        this.name = name;
        this.rate = rate;
    }

    public abstract double countSalary(double ... factor);

    public abstract double countYearSalary(double ... factor);

    public void setFactor(double newFactor){
        this.factor = newFactor;
    }

    public void printInfo(){
        System.out.printf("%s\t\t%.2f\n", this.name, this.rate);
    }

    public double countMeanMonthSalary(double ... factor){
        return countYearSalary(factor) / factor.length;
    }

    public void setRate(double newRate){
        this.rate = newRate;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public double getRate(){
        return this.rate;
    }

    public double getFactor() { return this.factor;}
}
