import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class AddressBookSystem {

    HashMap<String, AddressBook> addressBooks;

    public AddressBookSystem() {
        addressBooks = new HashMap<String, AddressBook>();
    }

    public void addAddressBook(String name, AddressBook addressBook) {
        addressBooks.put(name, addressBook);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Address Book Program");

        AddressBookSystem addressBookSystem = new AddressBookSystem();

        AddressBook addressBook1 = new AddressBook();
        addressBook1.insertContact(sc);
        addressBook1.askForEditContact(sc);

        AddressBook addressBook2 = new AddressBook();
        addressBook2.insertContact(sc);
        addressBook2.askForEditContact(sc);

        addressBookSystem.addAddressBook("Address book 1", addressBook1);
        addressBookSystem.addAddressBook("Address book 2", addressBook2);
        AddressBook addressBook = new AddressBook();

        // Use case: Adding contacts with duplicate check
        addressBook.insertContact(sc);

       // Display all contacts in the address book
       System.out.println("All Contacts:");
         addressBook1.contactList.forEach(Contact::printContact);


          // UC 7: Duplicate Check
          if (addressBook1.checkForDuplicate()) {
            System.out.println("Duplicate found in Address Book 1.");
        } else {
            System.out.println("No duplicate found in Address Book 1.");
        }

// UC 8: Search Person in City or State across multiple AddressBooksjkfjdf
        System.out.print("Enter the city or state to search: ");
        String searchLocation = sc.nextLine();

        // Search in the first address book
        List<Contact> result1 = addressBook1.searchPersonInCityOrState(searchLocation);
        displaySearchResult("Address Book 1", result1);

        // Search in the second address book
        List<Contact> result2 = addressBook2.searchPersonInCityOrState(searchLocation);
        displaySearchResult("Address Book 2", result2);

        System.out.println("Enter name of contact to delete");
        String contactToDelete = sc.nextLine();
        addressBook1.deleteContact(contactToDelete);

        // UC 9: View Persons by City or State
        // View persons by city
        System.out.print("Enter the city to view persons: ");
        String viewCity = sc.nextLine();
        List<Contact> personsByCity = addressBook1.viewPersonsByCity(viewCity);
        displayViewResult("City", personsByCity);

        // View persons by state
        System.out.print("Enter the state to view persons: ");
        String viewState = sc.nextLine();
        List<Contact> personsByState = addressBook2.viewPersonsByState(viewState);
        displayViewResult("State", personsByState);

    // UC 10: Count Persons by City or State
    System.out.print("Enter the city to count persons: ");
    String countCity = sc.nextLine();
    long countByCity = addressBook1.countPersonsByCity(countCity);
    System.out.println("Number of persons in " + countCity + ": " + countByCity);

    System.out.print("Enter the state to count persons: ");
    String countState = sc.nextLine();
    long countByState = addressBook2.countPersonsByState(countState);
    System.out.println("Number of persons in " + countState + ": " + countByState);

    sc.close();
    }
    private static void displaySearchResult(String addressBookName, List<Contact> result) {
        System.out.println("Search result in " + addressBookName + ":");
        if (result.isEmpty()) {
            System.out.println("No matching contacts found.");
        } else {
            result.forEach(Contact::printContact);
        }
    }
    private static void displayViewResult(String category, List<Contact> result) {
        System.out.println("Persons in " + category + ":");
        if (result.isEmpty()) {
            System.out.println("No persons found.");
        } else {
            result.forEach(Contact::printContact);
        }
    }
}
