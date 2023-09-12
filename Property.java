//import java.util.Scanner;
//import java.util.List;
//
//public class PropertyMenu {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        PropertyDAO propertyDAO = new PropertyDAO(); // Instantiate your DAO class
//
//        while (true) {
//            System.out.println("Welcome to the Property Management System");
//            System.out.println("1. Add Property");
//            System.out.println("2. Delete Property");
//            System.out.println("3. Update Property Cost");
//            System.out.println("4. Search by City");
//            System.out.println("5. Show All Properties");
//            System.out.println("6. Search by Cost Range");
//            System.out.println("7. Search by No. of Rooms and City");
//            System.out.println("8. Exit");
//            System.out.print("Please select an option: ");
//
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // Consume newline
//            makeConnection();
//            switch (choice) {
//                case 1:
//                	System.out.println("Add details of property to be added");
//                	System.out.println("")
//                    // Add Property
//                    // Implement this functionality using propertyDAO.addProperty method
//                	
//                    break;
//                case 2:
//                    // Delete Property
//                    // Implement this functionality using propertyDAO.deleteProperty method
//                    break;
//                case 3:
//                    // Update Property Cost
//                    // Implement this functionality using propertyDAO.updatePropertyCost method
//                    break;
//                case 4:
//                    // Search by City
//                    // Implement this functionality using propertyDAO.searchByCity method
//                    break;
//                case 5:
//                    // Show All Properties
//                    // Implement this functionality using propertyDAO.showAllProperties method
//                    break;
//                case 6:
//                    // Search by Cost Range
//                    // Implement this functionality using propertyDAO.searchByCost method
//                    break;
//                case 7:
//                    // Search by No. of Rooms and City
//                    // Implement this functionality using propertyDAO.searchByNoOfRoomsAndCity method
//                    break;
//                case 8:
//                    System.out.println("Exiting...");
//                    scanner.close();
//                    System.exit(0);
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//        }
//    }
//}
import java.util.Scanner;
import java.util.List;

public class PropertyMenu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PropertyDAO propertyDAO = new PropertyDAO(); // Instantiate your DAO class

        while (true) {
            System.out.println("Welcome to the Property Management System");
            System.out.println("1. Add Property");
            System.out.println("2. Delete Property");
            System.out.println("3. Update Property Cost");
            System.out.println("4. Search by City");
            System.out.println("5. Show All Properties");
            System.out.println("6. Search by Cost Range");
            System.out.println("7. Search by No. of Rooms and City");
            System.out.println("8. Exit");
            System.out.print("Please select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                	try {
                    // Add Property
                    // Add Property
                    System.out.print("Enter property details (propertyId, noOfRooms, areaInSqft, floorNo, city, state, cost, ownerName, ownerContactNo): ");
                    String propertyDetails = scanner.nextLine();
                    String[] propertyInfo = propertyDetails.split(",");
                    
                    if (propertyInfo.length == 9) {
                        Property property = new Property(
                            Integer.parseInt(propertyInfo[0].trim()),
                            (propertyInfo[1].trim()),
                            Double.parseDouble(propertyInfo[2].trim()),
                            Integer.parseInt(propertyInfo[3].trim()),
                            propertyInfo[4].trim(),
                            propertyInfo[5].trim(),
                            Double.parseDouble(propertyInfo[6].trim()),
                            propertyInfo[7].trim(),
                            propertyInfo[8].trim()
                        );
                        propertyDAO.addProperty(property);
                        System.out.println("Property added successfully!");
                    } else {
                        System.out.println("Invalid input format. Please try again.");
                    }
                    System.out.print("\n");
                    break;}
                	catch(Exception e) {System.out.print(e);}
                
                case 2:
                    // Delete Property
                    try{
                    System.out.print("Enter the property ID to delete: ");
                    int propertyIdToDelete;
                     propertyIdToDelete = scanner.nextInt();
                    propertyDAO.deleteProperty(propertyIdToDelete);
//                    System.out.print("Property Deleted Successfully :)");
                    System.out.print("\n");
                    break;
                    }
                    catch(java.util.InputMismatchException e) {
                    	System.out.println("Invalid Property ID");
                    	if(scanner.hasNext()) scanner.next();
                    	break;
                    }

                case 3:
                    // Update Property Cost
                    System.out.print("Enter the property ID to update cost: ");
                    int propertyIdToUpdate = scanner.nextInt();
                    System.out.print("Enter the new cost: ");
                    double newCost = scanner.nextDouble();
                    propertyDAO.updatePropertyCost(propertyIdToUpdate, newCost);
                    System.out.print("Property Cost Updated");
                    System.out.print("\n");
                    
                    break;

                case 4:
                    // Search by City
                    System.out.print("Enter the city to search for properties: ");
                    String searchCity = scanner.nextLine();
                    List<Property> propertiesByCity = propertyDAO.searchByCity(searchCity);
                    // Print the properties found
                    if(propertiesByCity.isEmpty())
                    	System.out.print("No Property Found :(");
                    
                    for (Property property : propertiesByCity) {
                        System.out.println(property.toString());
                    }
                    System.out.print("\n");
                    
                    break;

                case 5:
                    // Show All Properties
                    List<Property> allProperties = propertyDAO.showAllProperties();
                    // Print all properties
                    if(allProperties.isEmpty()) {System.out.println("No Results Found");
                    	break;
                    }
                    if(allProperties.isEmpty())
                    	System.out.print("No Property Found :(");
                    for (Property property : allProperties) {
                        System.out.println(property.toString());
                    }
                    System.out.print("\n");
                    break;

                case 6:
                    // Search by Cost Range
                    System.out.print("Enter minimum cost: ");
                    double minCost = scanner.nextDouble();
                    System.out.print("Enter maximum cost: ");
                    double maxCost = scanner.nextDouble();
                    List<Property> propertiesByCostRange = propertyDAO.searchByCost(minCost, maxCost);
                    // Print the properties found
                    if(propertiesByCostRange.isEmpty())
                    	System.out.print("No Property Found :(");
                    for (Property property : propertiesByCostRange) {
                        System.out.println(property.toString());
                    }
                    System.out.print("\n");
                    break;

                case 7:
                    // Search by No. of Rooms and City
                    System.out.print("Enter the number of rooms: ");
                    String numRooms = scanner.nextLine();
                    System.out.print("Enter the city to search for properties: ");
                    String searchCityAndRooms = scanner.nextLine();
                    List<Property> searchByNoOfRoomsAndCity = propertyDAO.searchByNoOfRoomsAndCity( searchCityAndRooms,numRooms);
                    // Print the properties found
                    if(searchByNoOfRoomsAndCity.isEmpty())
                    	System.out.print("No Property Found :(");
                    
                    for (Property property : searchByNoOfRoomsAndCity) {
                        System.out.println(property.toString());
                    }
                    System.out.println("\n");
                    break;

                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
