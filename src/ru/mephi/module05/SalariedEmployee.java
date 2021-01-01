package ru.mephi.module05;

public class SalariedEmployee extends Employee{

    public SalariedEmployee(int id, String name, double rate){
        super(id, name, rate);
    }

    public double countSalary(double ... profit){
        return this.rate;
    }

    public double countYearSalary(double ... profits){
        return 12*this.rate;
    }

    @Override
    public void setFactor(double newFactor) {
        // тут в любом случае ничего не поставится
        return;
    }

    public SalariedEmployee createInstance(int id, String name, double rate){
        SalariedEmployee man = new SalariedEmployee(id, name, rate);
        return man;
    }
}
