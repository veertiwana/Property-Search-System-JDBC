	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;

	public class PropertyDAO {

	    private Connection connection;
	    

	    public PropertyDAO() {
	        makeConnection();
	    }

	    public void makeConnection() {
	        String url = "Jdbc:Oracle:thin:@localhost:1521:orcl"; // Replace with your database URL
	        String username = "scott";
	        String password = "tiger";

	        try {
	            connection = DriverManager.getConnection(url, username, password);
	            System.out.println("Connected to the database.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new RuntimeException("Failed to connect to the database.");
	        }
	    }
	   
	    public int addProperty(Property prop) {
	        int rowsAffected = 0;
	        String query = "INSERT INTO PROPERTY (PROPERTYID, NOOFROOMS, AREAINSQFT, FLOORNO, CITY, STATE, COST, OWNERNAME, OWNERCONTACTNO) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?)";
	        
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	           // preparedStatement.setInt(1, prop.getNoOfRooms());
	        	preparedStatement.setInt(1, prop.getPropertyId());
	        	preparedStatement.setString(2, prop.getNoOfRooms());
	            preparedStatement.setDouble(3, prop.getAreaInSqFt());
	            preparedStatement.setInt(4, prop.getFloorNo());
	            preparedStatement.setString(5, prop.getCity());
	            preparedStatement.setString(6, prop.getState());
	            preparedStatement.setDouble(7, prop.getCost());
	            preparedStatement.setString(8, prop.getOwnerName());
	            preparedStatement.setString(9, prop.getOwnerContactNo());
	            
	            rowsAffected = preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	        	System.out.println(e.getMessage());
	            e.printStackTrace();
	        }
	        return rowsAffected;
	    }
//	    catch(SQLException e) {
//	    	e.printStackTrace();
//	    }

	    public int deleteProperty(int propId) {
	        int rowsAffected = 0;
	        String query = "DELETE FROM PROPERTY WHERE PROPERTYID = ?";
	        
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setInt(1, propId);
	            
	            rowsAffected = preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        return rowsAffected;
	    }

	    public boolean updatePropertyCost(int propId, double newCost) {
	        boolean updated = false;
	        String query = "UPDATE PROPERTY SET COST = ? WHERE PROPERTYID = ?";
	        
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setDouble(1, newCost);
	            preparedStatement.setInt(2, propId);
	            
	            int rowsAffected = preparedStatement.executeUpdate();
	            updated = rowsAffected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        return updated;
	    }

	    public List<Property> searchByCity(String city) {
	        List<Property> properties = new ArrayList<>();
	        String query = "SELECT * FROM PROPERTY WHERE CITY = ?";
	        
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setString(1, city);
	            
	            ResultSet resultSet = preparedStatement.executeQuery();
	            
	            while (resultSet.next()) {
	                Property prop = new Property();
	                prop.setPropertyId(resultSet.getInt("PROPERTYID"));
	                prop.setNoOfRooms(resultSet.getString("NOOFROOMS"));
	                prop.setAreaInSqFt(resultSet.getDouble("AREAINSQFT"));
	                prop.setFloorNo(resultSet.getInt("FLOORNO"));
	                prop.setCity(resultSet.getString("CITY"));
	                prop.setState(resultSet.getString("STATE"));
	                prop.setCost(resultSet.getDouble("COST"));
	                prop.setOwnerName(resultSet.getString("OWNERNAME"));
	                prop.setOwnerContactNo(resultSet.getString("OWNERCONTACTNO"));
	                
	                properties.add(prop);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        return properties;
	    }

	    public List<Property> showAllProperties() {
	        List<Property> properties = new ArrayList<>();
	        String query = "SELECT * FROM PROPERTY";
	        
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            ResultSet resultSet = preparedStatement.executeQuery();
	            
	            while (resultSet.next()) {
	                Property prop = new Property();
	                prop.setPropertyId(resultSet.getInt("PROPERTYID"));
	                prop.setNoOfRooms(resultSet.getString("NOOFROOMS"));
	                prop.setAreaInSqFt(resultSet.getInt("AREAINSQFT"));
	                prop.setFloorNo(resultSet.getInt("FLOORNO"));
	                prop.setCity(resultSet.getString("CITY"));
	                prop.setState(resultSet.getString("STATE"));
	                prop.setCost(resultSet.getDouble("COST"));
	                prop.setOwnerName(resultSet.getString("OWNERNAME"));
	                prop.setOwnerContactNo(resultSet.getString("OWNERCONTACTNO"));
	                
	                properties.add(prop);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        return properties;
	    }

	    public List<Property> searchByCost(double minCost, double maxCost) {
	        List<Property> properties = new ArrayList<>();
	        String query = "SELECT * FROM PROPERTY WHERE COST BETWEEN ? AND ?";
	        
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setDouble(1, minCost);
	            preparedStatement.setDouble(2, maxCost);
	            
	            ResultSet resultSet = preparedStatement.executeQuery();
	            
	            while (resultSet.next()) {
	                Property prop = new Property();
	                prop.setPropertyId(resultSet.getInt("PROPERTYID"));
	                prop.setNoOfRooms(resultSet.getString("NOOFROOMS"));
	                prop.setAreaInSqFt(resultSet.getDouble("AREAINSQFT"));
	                prop.setFloorNo(resultSet.getInt("FLOORNO"));
	                prop.setCity(resultSet.getString("CITY"));
	                prop.setState(resultSet.getString("STATE"));
	                prop.setCost(resultSet.getDouble("COST"));
	                prop.setOwnerName(resultSet.getString("OWNERNAME"));
	                prop.setOwnerContactNo(resultSet.getString("OWNERCONTACTNO"));
	                
	                properties.add(prop);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        return properties;
	    }

	    public List<Property> searchByNoOfRoomsAndCity(String city, String numberOfRooms) {
	        List<Property> properties = new ArrayList<>();
	        String query = "SELECT * FROM PROPERTY WHERE CITY = ? AND NOOFROOMS = ?";
	        
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setString(1, city);
	            preparedStatement.setString(2, numberOfRooms);
	            
	            ResultSet resultSet = preparedStatement.executeQuery();
	            
	            while (resultSet.next()) {
	                Property prop = new Property();
	                prop.setPropertyId(resultSet.getInt("PROPERTYID"));
	                prop.setNoOfRooms(resultSet.getString("NOOFROOMS"));
	                prop.setAreaInSqFt(resultSet.getDouble("AREAINSQFT"));
	                prop.setFloorNo(resultSet.getInt("FLOORNO"));
	                prop.setCity(resultSet.getString("CITY"));
	                prop.setState(resultSet.getString("STATE"));
	                prop.setCost(resultSet.getDouble("COST"));
	                prop.setOwnerName(resultSet.getString("OWNERNAME"));
	                prop.setOwnerContactNo(resultSet.getString("OWNERCONTACTNO"));
	                
	                properties.add(prop);
	            }
	        } catch (SQLException e) {System.out.print(e);
	            //e.printStackTrace();
	        }
	        
	        return properties;
	    }

	    public void closeConnection() {
	        try {
	            if (connection != null) {
	                connection.close();
	                System.out.println("Database connection closed.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}
