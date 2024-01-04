public class Vehicle {
    private String carPlate,carModel,acquirePrice,salesPrice,carStatus;
    public Vehicle(String carplate,String model,String aprice,String status,String sprice){
        carPlate=carplate;
        carModel=model;
        acquirePrice=aprice;
        carStatus=status;
        salesPrice=sprice;
    }
    public String getCarPlate(){
        return carPlate;
    }
    public String getCarModel(){
        return carModel;
    }
    public String getAcquirePrice(){
        return acquirePrice;
    }
    public String getCarStatus(){
        return carStatus;
    }
    public String getSalesPrice(){
        return salesPrice;
    }
}