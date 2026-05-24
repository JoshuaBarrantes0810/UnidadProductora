package cr.ac.una.landuna.Model;

public class PerennialCrop extends Crop {
 
      @Override
    public String getDescription() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private int productionYears;

    public PerennialCrop(String code, String name, String variety, String plantationDate, String cropType, int productionYears) {
        super(code, name, variety, plantationDate, cropType);
        this.productionYears = productionYears;
    }
    public void setYearProduction(int years){
        this.productionYears = years;
    }
    public int getYearProduction(){
        return this.productionYears;
    }
}
