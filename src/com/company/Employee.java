package com.company;

public class Employee {
    public final short CURRENT_YEAR = 2021;
    public final Double BONUS_PRICE_PER_HOUR = 30.0;
    public final Double WEEKLY_WORK_HOUR_LIMIT = 40.0;
    public final Double TOTAL_WORK_YEAR_LIMIT = 10.0;
    public final Double TAX_THRESHOLD_VALUE = 10.0;

    private final String name;
    private final Double salary;
    private final Integer workHours;
    private final short hireYear;

    public Employee(String name, Double salary, Integer workHours, short hireYear){
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    public Double tax(){
        if(salary > TAX_THRESHOLD_VALUE){
            return 0.97;
        }
        return 1.0;
    }

    public Double bonus(){
        if(workHours > WEEKLY_WORK_HOUR_LIMIT){
            return ( (workHours - WEEKLY_WORK_HOUR_LIMIT) * BONUS_PRICE_PER_HOUR) * 4;
        }
        return 0.0;
    }

    public Double raiseSalary(){
        final int totalWorkYear = CURRENT_YEAR - hireYear;
        if(totalWorkYear < TOTAL_WORK_YEAR_LIMIT){
            return (((salary + bonus()) * 1.05) * tax()) - salary;
        }else if(totalWorkYear > 9 && totalWorkYear < 20){
            return (((salary + bonus()) * 1.1) * tax()) - salary;
        }else{
            return (((salary + bonus()) * 1.15) * tax()) - salary;
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Salary: " + salary + "\n" +
                "Work Hours: " + workHours + "\n" +
                "Hire Year: " + hireYear + "\n" +
                "Monthly Bonus: " + bonus() + "\n" +
                "Hire Year: " + hireYear + "\n" +
                "Raise Salary: " + raiseSalary() + "\n" +
                "Total Salary: " + (Double)(salary + raiseSalary()) + "\n";
    }

}
