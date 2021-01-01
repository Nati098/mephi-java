package ru.mephi.module05;


import java.util.ArrayList;
import java.util.stream.DoubleStream;

public class Executive extends Employee {

    // factor - percent

    public Executive(int id, String name, double rate, double factor){
        super(id, name,rate);
        this.factor = factor;
    }

    public double countSalary(double ... profit){
        return this.rate * this.factor * DoubleStream.of(profit).sum();
    }

    public double countYearSalary(double ... profits){

        int sum = 0;
        ArrayList<Double> profit = new ArrayList<>();

        for (int i=0; i < profits.length; i++){
            profit.add(profits[i]);
            sum += this.rate*this.factor*profit.stream().mapToDouble(a -> a).sum();
        }

        return sum;
    }

    public Executive createInstance(int id, String name, double rate, double factor){
        Executive man = new Executive(id, name, rate, factor);
        return man;
    }

}
