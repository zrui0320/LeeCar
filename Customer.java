public class Customer {
    private String custId,custName,phoneNum,postcode;
    public Customer(){
    }
    public Customer(String id,String name,String phnum,String code){
        custId=id;
        custName=name;
        phoneNum=phnum;
        postcode=code;
    }
    public String getCustId(){
        return custId;
    }
    public String getCustName(){
        return custName;
    }
    public String getPhoneNum(){
        return phoneNum;
    }
    public String getPostcode(){
        return postcode;
    }
}