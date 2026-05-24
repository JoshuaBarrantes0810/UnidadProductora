
package cr.ac.una.landuna.DAO;

import cr.ac.una.landuna.Model.PerennialCrop;
import java.util.List;

public interface PerennialCropInterface {
 boolean insertPerennialCrop(PerennialCrop perennial);
 boolean updatePerennialCrop(PerennialCrop perennial);
 boolean deletePerennialCrop(PerennialCrop perennial);
 List<PerennialCrop> displayPerennialCrop();
PerennialCrop findCrop (String code);
}
