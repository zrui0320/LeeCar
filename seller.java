
import java.util.ArrayList;
import java.util.Random;

public class seller extends base {
    private final double salary = 1200;

    public double getSalary(String saleID){
        ArrayList<Double> saleRecord = getSaleRecord(saleID);

        double commission = getCommission(saleRecord);
        double allowance = getAllowance();
        double bonus = getBonus(saleRecord);

        return salary + commission + allowance + bonus;
    }

    public double getAllowance(){
        Random g = new Random();
        int number = g.nextInt(2);

        return (number == 1)? 250 : 0;
    }

    private double getBonus(ArrayList<Double> saleRecord){
        double ttl = 0;
        for(Double i : saleRecord){
            ttl += i;
        }

        if(saleRecord.size()>15 || ttl>= 1000000){
            return 500;
        }else{
            return 0;
        }
    }

    private double getCommission(ArrayList<Double> saleRecord){
        double commission = 0;

        for(Double i : saleRecord){
            commission += i*0.01;
        }
        return commission;
    }

}