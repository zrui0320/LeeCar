public class Sales {
    private String salesId,dateTime,carPlate,custId,employeeId;
    public Sales(String sid,String datetime,String carplate,String cid,String eid){
        salesId=sid;
        dateTime=datetime;
        carPlate=carplate;
        custId=cid;
        employeeId=eid;
    }
    public String getEmployeeId(){
        return employeeId;
    }
    public String getDateTime(){
        return dateTime;
    }
    public String getCarPlate(){
        return carPlate;
    }
    public String getCustId(){
        return custId;
    }
    public String getSalesId(){
        return salesId;
    }
}