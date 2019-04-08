package ru.mephi.module05;

public class Manager extends Employee {

    // factor - percent

    public Manager(int id, String name, double rate, double factor){
        super(id, name, rate);
        this.factor = factor;
    }

    public double countSalary(double ... profit){
        return profit[0]*this.factor*this.rate;
    }

    public double countYearSalary(double ... profits){
        double sum = 0;
        for (int i=0; i < profits.length; i++){
            sum += profits[i] * this.factor * this.rate;
        }
        return sum;
    }

}
