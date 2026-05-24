package cr.ac.una.landuna.DAO;

import cr.ac.una.landuna.Model.Crop;

public class SupportCrop {
    AnnualCropDAO annual = new AnnualCropDAO();
    PerennialCropDAO perennial = new PerennialCropDAO();
    
    public SupportCrop(){
        
    }
    
    public Crop findCrops(String code){
        Crop crop = annual.findCrop(code);
        if(crop==null){
            crop = perennial.findCrop(code);
        }
        return crop;
    }
}