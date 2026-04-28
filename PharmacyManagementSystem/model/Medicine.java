package model;

public abstract class Medicine{
    private String name;
    private String genericName;
    private String batchID;
    private double price;
    private int stock;
    private String expiryDate;
    public int length;



    public Medicine(){
        System.out.println("E-CONSTRUCTOR MEDICINE");
    }

    public Medicine(String name, String genericName, String batchID, double price,int stock, String expiryDate){
        setName(name);
        setGenericName(genericName);
        setBatchID(batchID);
        setPrice(price);
        setStock(stock);
        setExpiryDate(expiryDate);
    }


    //Setters & Getters

    public void setName(String name){
        if(!name.isEmpty()){
            this.name = name;
        }else{
            System.out.println("Please Enter a name for Medicine");
        }
    }

    public void setGenericName(String genericName){
        if(!genericName.isEmpty()){
            this.genericName = genericName;
        }else{
            System.out.println("Please Enter a Generic name for Medicine");
        }
    }

    public void setBatchID(String batchID){
        if(!batchID.isEmpty()){
            this.batchID = batchID;
        }else{
            System.out.println("Please Enter a Generic name for Medicine");
        }
    }

    public void setPrice(double price){
        if(price > 0){
            this.price = price;
        }else{
            System.out.println("Please Enter a Valid Price");
        }
    }

    public void setStock(int stock){
        if(stock > 0){
            this.stock = stock;
        }else{
            System.out.println("Please Enter a Valid Stock");
        }
    }


    public void setExpiryDate(String expriryDate){
        this.expiryDate = expriryDate;
    }

    public String getName(){
        return name;
    }
    public String getGenericName(){
        return genericName;
    }
    public String getBatchID(){
        return batchID;
    }
    public double getPrice(){
        return price;
    }
    public int getStock(){
        return stock;
    }

    public String getExpiryDate(){
        return expiryDate;
    }


    public abstract String getDetails();

}