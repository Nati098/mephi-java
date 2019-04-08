package ru.mephi.module05;

public class HourlyEmployee extends Employee {

    //factor - число часов

    public HourlyEmployee(int id, String name, double rate, double factor){
        super(id, name, rate);
        this.factor = factor;
    }

    public double countSalary(double ... profit){
        return this.rate*this.factor;
    }

    public double countYearSalary(double ... profits){
        return 12*this.rate*this.factor;
    }

}
