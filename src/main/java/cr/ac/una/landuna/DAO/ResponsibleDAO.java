package cr.ac.una.landuna.DAO;

import cr.ac.una.landuna.Connection.Conexion;
import cr.ac.una.landuna.Model.AgriculturalTechnician;
import cr.ac.una.landuna.Model.Responsible;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResponsibleDAO implements ResponsibleInterface{
private Connection connection;
        
    public ResponsibleDAO(){
        this.connection=Conexion.getConnection();
    }
    @Override
    public boolean insertResponcible(Responsible responsible) {
       String sql = "INSERT INTO Rensponsible (responsible_ID, responsible_Name, email, phone_Number, responsible_Type, land_Name_Association, technical_Specialty) VALUES (?,?,?,?,?,?,?)";
    try{
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, responsible.getIdentification());
        ps.setString(2, responsible.getResponsibleName());
        ps.setString(3, responsible.getEmail());
        ps.setString(4, responsible.getPhoneNumber());
        ps.setString(5, responsible.getResponsibleType());
        ps.setString(6, responsible.getLandNameAsociation().getProducerId());
        ps.setString(7, responsible.getTechnicalSpeciality().getSpecialty());
        ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());   
            return false;
        }
    }
    

    @Override
    public boolean updateResponcible(Responsible responsible) {
       String sql = "UPDATE Rensponsible SET responsible_Name = ?, email = ?, phone_Number = ?, responsible_Type = ?, land_Name_Association = ?, technical_Specialty = ? WHERE responsible_ID = ?";
       try{
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, responsible.getResponsibleName());
        ps.setString(2, responsible.getEmail());
        ps.setString(3, responsible.getPhoneNumber());
        ps.setString(4, responsible.getResponsibleType());
        ps.setString(5, responsible.getLandNameAsociation().getProducerId());
        ps.setString(6, responsible.getTechnicalSpeciality().getSpecialty());
        ps.setString(7, responsible.getIdentification());
        ps.executeUpdate();
        return true;
        }catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteResponcible(Responsible responsible) {
    String sql = "DELETE FROM Rensponsible WHERE responsible_ID = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, responsible.getIdentification());
            ps.executeUpdate();
            return true;
         } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Responsible> displayResponsible() {
      List<Responsible> responsibles = new ArrayList<>();
      ProducerDAO producer = new ProducerDAO();
        String sql = "SELECT * FROM Responsibles";
        try{
           PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Responsible responsible = new Responsible(rs.getString("responsible_ID"),rs.getString("responsible_Name"),rs.getString("email"),rs.getString("phone_Number"),rs.getString("responsible_Type"),producer.findProducer(rs.getString("land_Name_Association")),AgriculturalTechnician.valueOf(rs.getString("technical_Specialty")));
                responsibles.add(responsible);
            }
        
         } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return null;
        }
        return responsibles;
    }

    @Override
    public Responsible findResponsible(String code) {
      String sql = "SELECT * FROM  Responsibles WHERE responsible_ID = ?";
      ProducerDAO producer = new ProducerDAO();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
            return new Responsible(rs.getString("responsible_ID"),rs.getString("responsible_Name"),rs.getString("email"),rs.getString("phone_Number"),rs.getString("responsible_Type"),producer.findProducer(rs.getString("land_Name_Association")),AgriculturalTechnician.valueOf(rs.getString("technical_Specialty")));
            }
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return null;
        } 
        return null;
    }
}
