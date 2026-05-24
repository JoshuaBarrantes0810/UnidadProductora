
package cr.ac.una.landuna.DAO;

import cr.ac.una.landuna.Model.Responsible;
import java.util.List;

public interface ResponsibleInterface {
    boolean insertResponcible(Responsible responsible);
    boolean updateResponcible (Responsible responsible);
    boolean deleteResponcible (Responsible responsible);
    
    List<Responsible> displayResponsible();
    Responsible findResponsible(String code);
}
