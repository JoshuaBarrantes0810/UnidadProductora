
package cr.ac.una.landuna.DAO;

import cr.ac.una.landuna.Model.Producer;
import java.util.List;

public interface ProducerInterface {
    boolean insertProducer(Producer producer);
    boolean updateProducer(Producer producer);
    boolean deteleProducer(Producer producer);
    List<Producer> displayProducer();
    Producer findProducer(String code);
}
