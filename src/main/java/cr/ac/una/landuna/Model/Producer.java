package cr.ac.una.landuna.Model;

public class Producer {
     private String producerLandName;
     private String producerId;
    
    public Producer(String producerId,String producerLandName){
        this.producerId=producerId;
        this.producerLandName=producerLandName;
    }
    
    public void setProducerId(String id){
        this.producerId=id;
    }
    public void setProducerLandName(String land){
        this.producerLandName=land;
    }

    public String getProducerId(){
        return this.producerId;
    }
    public String getProducerLandName(){
        return this.producerLandName;
    }
}
