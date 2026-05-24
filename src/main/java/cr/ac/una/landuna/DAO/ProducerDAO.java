
package cr.ac.una.landuna.DAO;

import cr.ac.una.landuna.Connection.Conexion;
import cr.ac.una.landuna.Model.Producer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProducerDAO implements ProducerInterface{
private Connection connection;
    
    public ProducerDAO(){
        this.connection=Conexion.getConnection();
    }
    @Override
    public boolean insertProducer(Producer producer) {
      String sql = "INSERT INTO PRODUCERS (id_producer, producer_name) VALUES (?,?)";
      try{
      PreparedStatement ps = connection.prepareStatement(sql);
         ps.setString(1, producer.getProducerId());
         ps.setString(2, producer.getProducerLandName());
         ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());   
            return false;
        }
      }
    
    @Override
    public boolean updateProducer(Producer producer) {
      String sql = "UPDATE PRODUCERS SET producer_name = ? WHERE id_producer = ?";
      try{
          PreparedStatement ps = connection.prepareStatement(sql);
          ps.setString(1, producer.getProducerLandName());
          ps.setString(2, producer.getProducerId());
          ps.executeUpdate();
          return true;
      }catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean deteleProducer(Producer producer) {
    String sql = "DELETE FROM PRODUCERS WHERE id_producer = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, producer.getProducerId());
            ps.executeUpdate();
            return true;
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Producer> displayProducer() {
       List<Producer> producers = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCERS";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Producer producer = new Producer(rs.getString("id_producer"),rs.getString("producer_name"));
                producers.add(producer);
            }
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return null;
        }
        return producers;
    }

    @Override
    public Producer findProducer(String code) {
     String sql = "SELECT * FROM PRODUCERS WHERE id_producer = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
            return new Producer(rs.getString("id_producer"),rs.getString("producer_name"));
            }
        } catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            return null;
        } 
        return null;
    }
}