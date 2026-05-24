package cr.ac.una.landuna.DAO;

import cr.ac.una.landuna.Connection.Conexion;
import cr.ac.una.landuna.Model.AgriculturalWork;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgriculturalWorkDAO implements AgriculturalWorkInterface {
    private Connection connection;

    public AgriculturalWorkDAO(){
        this.connection=Conexion.getConnection();
    }

    @Override
    public boolean insertTypeWork(AgriculturalWork work) {
        String sql = "INSERT INTO Agricultural_Work (code,plot_Code,crops_Code,responsible_ID,realization_date,type_Work,description_Work,estimated_Cost) VALUES (?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, work.getWorkCode());
            ps.setString(2, work.getPlotCode().getPlotCode());
            ps.setString(3, work.getCropCode().getCropCode());
            ps.setString(4, work.getResponsibleId().getIdentification());
            ps.setBigDecimal(5, work.getEstimatedCost());
            ps.setString(6, work.getDateCompletion());
            ps.setString(7, work.getLaborType());
            ps.setString(8, work.getDescription());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());   
            return false;
        }
    }

    @Override
    public boolean updateWork(AgriculturalWork work) {
         String sql = "UPDATE Agricultural_Work SET plot_Code = ?,crops_Code = ?,responsible_ID = ?,realization_date = ?,type_Work = ?,description_Work = ?,estimated_Cost = ? WHERE code = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, work.getPlotCode().getPlotCode());
            ps.setString(2, work.getCropCode().getCropCode());
            ps.setString(3, work.getResponsibleId().getIdentification());
            ps.setBigDecimal(4, work.getEstimatedCost());
            ps.setString(5, work.getDateCompletion());
            ps.setString(6, work.getLaborType());
            ps.setString(7, work.getDescription());
            ps.setString(8, work.getWorkCode());
            ps.executeUpdate();
            return true;
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteWork(AgriculturalWork work) {
    String sql = "DELETE FROM Agricultural_Work WHERE code = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, work.getWorkCode());
            ps.executeUpdate();
            return true;
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return false;
        }    
    
    }

    @Override
    public List<AgriculturalWork> displayWorks() {
     PlotDAO plot = new PlotDAO();
     SupportCrop crop = new SupportCrop();
     ResponsibleDAO res = new ResponsibleDAO();
     List<AgriculturalWork> works = new ArrayList<>();
        String sql = "SELECT * FROM Agricultural_Work";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               AgriculturalWork work = new AgriculturalWork(rs.getString("code"),plot.findPlot(rs.getString("plot_code")),crop.findCrops(rs.getString("crops_Code")),res.findResponsible(rs.getString("responsible_ID")),rs.getString("realization_Date"),rs.getString("type_Work"),rs.getString("description_Work"),rs.getBigDecimal("estimated_Cost"));
               works.add(work);
            }
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return null;
        }
        return works;   
    }

    @Override
    public AgriculturalWork findWork(String code) {
        PlotDAO plot = new PlotDAO();
     SupportCrop crop = new SupportCrop();
     ResponsibleDAO res = new ResponsibleDAO();
    String sql = "SELECT * FROM  Agricultural_Work WHERE code = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
              return new AgriculturalWork(rs.getString("code"),plot.findPlot(rs.getString("plot_code")),crop.findCrops(rs.getString("crops_Code")),res.findResponsible(rs.getString("responsible_ID")),rs.getString("realization_Date"),rs.getString("type_Work"),rs.getString("description_Work"),rs.getBigDecimal("estimated_Cost"));
            }
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return null;
        } 
        return null;
    }
}
