package cr.ac.una.landuna.Model;

public class AnnualCrop extends Crop{

    @Override
    public String getDescription() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     public AnnualCrop(String code, String name, String variety, String plantationDate, String cropType, int productionDays) {
        super(code, name, variety, plantationDate, cropType);
    }
     public int productionDays;
     
     public void setProductionDays(int days){
         this.productionDays = days;
     }
     public int getProductionDays(){
         return this.productionDays;
     }
}
