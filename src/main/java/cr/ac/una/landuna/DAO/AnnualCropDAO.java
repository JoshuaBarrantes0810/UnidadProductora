
package cr.ac.una.landuna.DAO;

import cr.ac.una.landuna.Connection.Conexion;
import cr.ac.una.landuna.Model.AnnualCrop;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class AnnualCropDAO implements AnnualCropInterface{
    private Connection connection;
    public AnnualCropDAO(){
        this.connection=Conexion.getConnection();
    }
    @Override
    public boolean insertAnnualCrop(AnnualCrop annual) {
      String sqlCrop = "INSERT INTO Crops (code,variety,sowing_Date,crop_Type) VALUES (?,?,?,?)";
      String sqlPerennialCrop = "INSERT INTO Annual_Crop (code,crop_Name,duration_Days) VALUES (?,?,?)";
      try{
            PreparedStatement psCrop = connection.prepareStatement(sqlCrop);
            psCrop.setString(1, annual.getCropCode());
            psCrop.setString(2, annual.getCropVariety());
            psCrop.setString(3, annual.getPlantationDate());
            psCrop.setString(4, annual.getCropType()); 
            psCrop.executeUpdate();
            PreparedStatement psPerennialCrop = connection.prepareStatement(sqlPerennialCrop);
            psPerennialCrop.setString(1, annual.getCropCode());
            psPerennialCrop.setString(2, annual.getCropName());
            psPerennialCrop.setInt(3, annual.getProductionDays());
            psPerennialCrop.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());   
            return false;
        }
    }

    @Override
    public boolean updateAnnualCrop(AnnualCrop annual) {
     String sqlCrop = "UPDATE Crops SET variety = ?,sowing_Date = ?,crop_Type = ? WHERE code = ?";
        String sqlPerennialCrop = "UPDATE Annual_Crop SET crop_Name = ?, duration_Days = ? WHERE code = ?";
        try{
            PreparedStatement psPerennialCrop = connection.prepareStatement(sqlPerennialCrop);
            psPerennialCrop.setString(1, annual.getCropName());
            psPerennialCrop.setInt(2, annual.getProductionDays());
            psPerennialCrop.setString(3, annual.getCropCode());
            psPerennialCrop.executeUpdate();
            PreparedStatement psCrop = connection.prepareStatement(sqlCrop);
            psCrop.setString(1, annual.getCropVariety());
            psCrop.setString(2, annual.getPlantationDate());
            psCrop.setString(3, annual.getCropType()); 
            psCrop.setString(4, annual.getCropCode());
            psCrop.executeUpdate();
            return true;
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteAnnualCrop(AnnualCrop annual) {
        String sqlCrop = "DELETE FROM  Crops WHERE code = ?";
        String sqlPerennialCrop = "DELETE FROM Annual_Crop WHERE code = ?";
    try{
        PreparedStatement psPerennialCrop = connection.prepareStatement(sqlPerennialCrop);
        psPerennialCrop.setString(1, annual.getCropCode());
        psPerennialCrop.executeUpdate();
        PreparedStatement psCrop = connection.prepareStatement(sqlCrop);
        psCrop.setString(1, annual.getCropCode());
        psCrop.executeUpdate();
        return true;
    } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return false;
        }
    }

    @Override
    public List<AnnualCrop> displayAnnualCrop() {
      List<AnnualCrop> annuals = new ArrayList<>();
        String sql = "SELECT an.code, an.crop_Name, c.variety, c.sowing_Date, c.crop_Type, an.duration_Days " +
                     "WHERE Annual_Crop an JOIN Crops c an.crop_Name = c.code";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                AnnualCrop annual = new AnnualCrop(rs.getString("code"),rs.getString("Crop_Name"),rs.getString("variety"),rs.getString("duration_Days"),rs.getString("crop_Type"),rs.getInt("years_Prodution"));
                annuals.add(annual);
            }
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return null;
        }
        return annuals;
    }

    @Override
    public AnnualCrop findCrop(String code) {
    String sql = "SELECT an.code, an.crop_Name, c.variety, c.sowing_Date, c.crop_Type, an.duration_Days " +
                     "WHERE Annual_Crop an JOIN Crops c an.crop_Name = c.code WHERE an.crop_Name = ?";  
    try{
        PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new AnnualCrop(rs.getString("code"),rs.getString("Crop_Name"),rs.getString("variety"),rs.getString("plantation_Date"),rs.getString("crop_Type"),rs.getInt("duration_Days"));
            }
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return null;
        } 
        return null;
    }
        
}
