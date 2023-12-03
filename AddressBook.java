import java.util.HashMap;
import java.util.Scanner;

public class AddressBook {
    
    HashMap<String, Contact> contactList;

    public AddressBook() {
        contactList = new HashMap<String, Contact>();
    }

    public void addContact(Contact contact) {
        if (isDuplicate(contact)) {
            System.out.println("Duplicate entry found. Contact not added.");
        } else {
            contactList.put(contact.getName(), contact);
            System.out.println("Contact added successfully.");
        }
    }

    private boolean isDuplicate(Contact contact) {
        return contactList.values().stream().anyMatch(c -> c.equals(contact));
    }

    // UC 7: Method to check for duplicates in the AddressBook
    public boolean checkForDuplicate() {
        return contactList.values().stream().anyMatch(contact -> isDuplicate(contact));
    }


    public void deleteContact(String name) {
        if (contactList.containsKey(name)) {
            contactList.remove(name);
            System.out.println("Contact found and deleted");
        } else {
            System.out.println("Contact not found.");
        }
    }

    public Contact getContactbyName(String name) {
        if (contactList.containsKey(name)) {
            return contactList.get(name);
        }
        return null;
    }

    public void askForEditContact(Scanner sc) {
        System.out.println("Enter Name to edit Contact: ");
        String name;
        name = sc.nextLine();
        Contact searchContact = this.getContactbyName(name);
        if (searchContact != null) {
            searchContact.editContact(sc);
            System.out.println("Updated Contact: ");
            searchContact.printContact();
        } else {
            System.out.println("No Contact found!");
        }
    }

    public void insertContact(Scanner sc) {
        String moreContact = "y";
        do {
            Contact contact = new Contact();
            contact.inputContact(sc);
            contact.printContact();
            this.addContact(contact);
            System.out.println("Want to add more contact? Press Y: ");
            moreContact = sc.nextLine();
        } while (moreContact.equalsIgnoreCase("y"));
    }

}
