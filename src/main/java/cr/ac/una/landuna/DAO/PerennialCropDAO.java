
package cr.ac.una.landuna.DAO;

import cr.ac.una.landuna.Connection.Conexion;
import cr.ac.una.landuna.Model.PerennialCrop;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PerennialCropDAO implements PerennialCropInterface {
private Connection connection;
    
    public PerennialCropDAO(){
        this.connection=Conexion.getConnection();
    }
    @Override
    public boolean insertPerennialCrop(PerennialCrop perennial) {
        String sqlCrop = "INSERT INTO Crops (code,variety,sowing_Date,crop_Type) VALUES (?,?,?,?)";
        String sqlPerennialCrop = "INSERT INTO Perennial_Crop (code,crop_Name,years_Prodution) VALUES (?,?,?)";
        try{
            PreparedStatement psCrop = connection.prepareStatement(sqlCrop);
            psCrop.setString(1, perennial.getCropCode());
            psCrop.setString(2, perennial.getCropVariety());
            psCrop.setString(3, perennial.getPlantationDate());
            psCrop.setString(4, perennial.getCropType()); 
            psCrop.executeUpdate();
            PreparedStatement psPerennialCrop = connection.prepareStatement(sqlPerennialCrop);
            psPerennialCrop.setString(1, perennial.getCropCode());
            psPerennialCrop.setString(2, perennial.getCropName());
            psPerennialCrop.setInt(3, perennial.getYearProduction());
            psPerennialCrop.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());   
            return false;
        }
        
    }

    @Override
    public boolean updatePerennialCrop(PerennialCrop perennial) {
        String sqlCrop = "UPDATE Crops SET variety = ?,sowing_Date = ?,crop_Type = ? WHERE code = ?";
        String sqlPerennialCrop = "UPDATE Perennial_Crop SET crop_Name = ?,years_Prodution = ? WHERE code = ?";
        try{
            PreparedStatement psPerennialCrop = connection.prepareStatement(sqlPerennialCrop);
            psPerennialCrop.setString(1, perennial.getCropName());
            psPerennialCrop.setInt(2, perennial.getYearProduction());
            psPerennialCrop.setString(3, perennial.getCropCode());
            psPerennialCrop.executeUpdate();
            PreparedStatement psCrop = connection.prepareStatement(sqlCrop);
            psCrop.setString(1, perennial.getCropVariety());
            psCrop.setString(2, perennial.getPlantationDate());
            psCrop.setString(3, perennial.getCropType()); 
            psCrop.setString(4, perennial.getCropCode());
            psCrop.executeUpdate();
            return true;
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return false;
        }
    }
        

    @Override
    public boolean deletePerennialCrop(PerennialCrop perennial) {
    String sqlCrop = "DELETE FROM Crops WHERE code = ?";
    String sqlPerennialCrop = "DELETE FROM Perennial_Crop WHERE code = ?";
    try{
        PreparedStatement psPerennialCrop = connection.prepareStatement(sqlPerennialCrop);
        psPerennialCrop.setString(1, perennial.getCropCode());
        psPerennialCrop.executeUpdate();
        PreparedStatement psCrop = connection.prepareStatement(sqlCrop);
        psCrop.setString(1, perennial.getCropCode());
        psCrop.executeUpdate();
        return true;
    } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return false;
        }
    
    }
    

    @Override
    public List<PerennialCrop> displayPerennialCrop() {
      List<PerennialCrop> perennials = new ArrayList<>();
        String sql = "SELECT pe.code, pe.crop_Name, c.variety, c.sowing_Date, c.crop_Type, pe.years_Production " +
                     "WHERE Perennial_Crop pe JOIN Crops c pe.crop_Name = c.code";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                PerennialCrop perennial = new PerennialCrop(rs.getString("code"),rs.getString("Crop_Name"),rs.getString("variety"),rs.getString("plantation_Date"),rs.getString("crop_Type"),rs.getInt("years_Prodution"));
                perennials.add(perennial);
            }
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return null;
        }
        return perennials;
    }

    @Override
    public PerennialCrop findCrop(String code) {
      String sql = "SELECT pe.code, pe.crop_Name, c.variety, c.sowing_Date, c.crop_Type, pe.years_Production " +
                     "WHERE Perennial_Crop pe JOIN Crops c pe.crop_Name = c.code WHERE pe.crop_Name = ?";
      try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new PerennialCrop(rs.getString("code"),rs.getString("Crop_Name"),rs.getString("variety"),rs.getString("plantation_Date"),rs.getString("crop_Type"),rs.getInt("years_Prodution"));
            }
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return null;
        } 
        return null;
    }
}
