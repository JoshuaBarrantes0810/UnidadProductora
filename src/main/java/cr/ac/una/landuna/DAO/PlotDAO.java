package cr.ac.una.landuna.DAO;

import cr.ac.una.landuna.Connection.Conexion;
import cr.ac.una.landuna.Model.Plot;
import cr.ac.una.landuna.Model.SoilState;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlotDAO implements PlotInterface {
private Connection connection;
    
    public PlotDAO(){
        this.connection=Conexion.getConnection();
    }

    @Override
    public boolean insertPlot(Plot plot) {
         String sql = "INSERT INTO PLOTS (code,plotName,plotLocation,area,soil_type,soil_state) VALUES (?,?,?,?,?,?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, plot.getPlotCode());
            ps.setString(2, plot.getPlotName());
            ps.setString(3, plot.getLocation());
            ps.setBigDecimal(4, plot.getPlotArea());
            ps.setString(5, plot.getSoilType());
            ps.setString(6, plot.getSoilState().getSoilState());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());   
            return false;
        }
    }

    @Override
    public boolean updatePlot(Plot plot) {
        String sql = "UPDATE PLOTS SET plotName = ?, plotLocation = ?, area = ?, soil_type = ?, soil_state = ? WHERE code = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, plot.getPlotName());
            ps.setString(2, plot.getLocation());
            ps.setBigDecimal(3, plot.getPlotArea());
            ps.setString(4, plot.getSoilType());
            ps.setString(5, plot.getSoilState().getSoilState());
            ps.setString(6, plot.getPlotCode());
            ps.executeUpdate();
            return true;
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean deletePlot(Plot plot) {
    String sql = "DELETE FROM PLOTS WHERE code = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, plot.getPlotCode());
            ps.executeUpdate();
            return true;
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Plot> displayPlots() {
       List<Plot> plots = new ArrayList<>();
        String sql = "SELECT * FROM PLOTS";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Plot plot = new Plot(rs.getString("code"),rs.getString("plotName"),rs.getString("plotLocation"),rs.getBigDecimal("area"),rs.getString("soil_type"),SoilState.valueOf(rs.getString("soil_state")));
                plots.add(plot);
            }
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return null;
        }
        return plots;
    }

    @Override
    public Plot findPlot(String code) {
      String sql = "SELECT * FROM PLOTS WHERE code = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Plot(rs.getString("code"),rs.getString("plotName"),rs.getString("plotLocation"),rs.getBigDecimal("area"),rs.getString("soil_type"),SoilState.valueOf(rs.getString("soil_state")));
            }
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return null;
        } 
        return null;
    } 
}
    
