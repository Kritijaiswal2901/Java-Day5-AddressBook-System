import java.util.ArrayList;

public class AddressBookSystem {

    private ArrayList<Contact> contactList;

    public AddressBookSystem() {
        contactList = new ArrayList<Contact>();
    }

    public void addContact(Contact contact) {
        contactList.add(contact);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");

        AddressBookSystem addressBook = new AddressBookSystem();
        Contact contact1 = new Contact();
        contact1.inputContact();

        addressBook.addContact(contact1);
    }
}
