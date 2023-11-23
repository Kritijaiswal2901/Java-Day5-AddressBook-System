import java.util.HashMap;
import java.util.Scanner;

public class AddressBookSystem {

    private HashMap<String, Contact> contactList;

    public AddressBookSystem() {
        contactList = new HashMap<String, Contact>();
    }
    
    public void addContact(Contact contact) {
        contactList.put(contact.getName(), contact);
    }
    
    public Contact getContactbyName(String name) {
        if(contactList.containsKey(name)) {
            return contactList.get(name);
        }
        return null;
    }
    
    public void askForEditContact(Scanner sc) {
        System.out.println("Enter Name to edit Contact: ");
        String name;
        name = sc.nextLine();
        Contact searchContact = this.getContactbyName(name);
        if(searchContact != null) {
            searchContact.editContact(sc);
            System.out.println("Updated Contact: ");
            searchContact.printContact();
        } else {
            System.out.println("No Contact found!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Address Book Program");

        AddressBookSystem addressBook = new AddressBookSystem();
        Contact contact1 = new Contact();
        contact1.inputContact(sc);
        contact1.printContact();
        addressBook.addContact(contact1);

        addressBook.askForEditContact(sc);
        sc.close();
    }
}
