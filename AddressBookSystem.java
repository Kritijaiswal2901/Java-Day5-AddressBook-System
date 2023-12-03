import java.util.HashMap;
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
        addressBook.contactList.values().forEach(Contact::printContact);

          // UC 7: Duplicate Check
          if (addressBook1.checkForDuplicate()) {
            System.out.println("Duplicate found in Address Book 1.");
        } else {
            System.out.println("No duplicate found in Address Book 1.");
        }


        System.out.println("Enter name of contact to delete");
        String contactToDelete = sc.nextLine();
        addressBook1.deleteContact(contactToDelete);
        sc.close();
    }
}
