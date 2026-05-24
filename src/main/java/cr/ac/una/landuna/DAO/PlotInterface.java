
package cr.ac.una.landuna.DAO;

import cr.ac.una.landuna.Model.Plot;
import java.util.List;

public interface PlotInterface {
 boolean insertPlot(Plot plot);
 boolean updatePlot(Plot plot);
 boolean deletePlot(Plot plot);
 List <Plot> displayPlots();
 Plot findPlot(String code);
}
