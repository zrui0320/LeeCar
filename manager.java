
import java.util.ArrayList;
import java.util.Random;

public class manager extends base {
    private final double salary = 2200;

    public double getSalary(String saleID){
        ArrayList<Double> saleRecord = getSaleRecord(saleID);
       
        double commission = getCommission(saleRecord);
        double allowance = getAllowance();

        return salary + commission + allowance;
    }


    public double getAllowance(){
        Random g = new Random();
        int number = g.nextInt(2);

        return (number == 1)? 350 : 0;
    }

    private double getBonus(ArrayList<Double> saleRecord){
        double ttl = 0;
        for(Double i : saleRecord){
            ttl += i;
        }

        if(ttl <= 800000.00){
            return 0.01;
        }else if(ttl>800000.00 && ttl<=1600000.00){
            return 0.0115;
        }else if(ttl>1600000.00 && ttl<=2500000.00){
            return 0.0125;
        }else{
            return 0.0135;
        }
    }

    private double getCommission(ArrayList<Double> saleRecord){
        double commission = 0;

        for(Double i : saleRecord){
            commission += i*getBonus(saleRecord);
        }
        return commission;
    }

}
