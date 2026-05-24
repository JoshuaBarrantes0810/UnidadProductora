package cr.ac.una.landuna.DAO;

import cr.ac.una.landuna.Model.AnnualCrop;
import java.util.List;

public interface AnnualCropInterface {
 boolean insertAnnualCrop(AnnualCrop annual);
 boolean updateAnnualCrop(AnnualCrop annual);
 boolean deleteAnnualCrop(AnnualCrop annual);
 List<AnnualCrop> displayAnnualCrop();
 AnnualCrop findCrop (String code);
}
