package cr.ac.una.landuna.Model;


public abstract class Crop {
    private String code;
    private String name;
    private String variety;
    private String plantationDate;
    private String cropType;
    
    public Crop(String code,String name,String variety,String plantationDate,String cropType){
        this.code=code;
        this.name=name;
        this.variety=variety;
        this.plantationDate=plantationDate;
        this.cropType=cropType;
    }
        public void setCropCode(String code){
        this.code=code;
    }
    public void setCropName(String name){
        this.name=name;
    }
    public void setCropVariety(String variety){
        this.variety=variety;
    }
    public void setPlantationDate(String plantationDate){
        this.plantationDate=plantationDate;
    }
    public void setCropType(String type){
        this.cropType=type;
    }

    public String getCropCode(){
        return this.code;
    }
    public String getCropName(){
        return this.name;
    }
    public String getCropVariety(){
        return this.variety;
    }
    public String getPlantationDate(){
        return this.plantationDate;
    }
    public String getCropType(){
        return this.cropType;
    }

    public abstract String getDescription();
    
}
