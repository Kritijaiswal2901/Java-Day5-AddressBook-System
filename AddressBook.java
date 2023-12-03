import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;


public class AddressBook {
    
    List<Contact> contactList;
    private Map<String, List<Contact>> cityDictionary;
    private Map<String, List<Contact>> stateDictionary;

    public AddressBook() {
        contactList = new ArrayList<>();
        cityDictionary = new HashMap<>();
        stateDictionary = new HashMap<>();
    }

    public void addContact(Contact contact) {
        if (isDuplicate(contact)) {
            System.out.println("Duplicate entry found. Contact not added.");
        } else {
            contactList.add(contact);
            updateDictionaries(contact);
            System.out.println("Contact added successfully.");
        }
    }
    public boolean checkForDuplicate() {
        return contactList.stream().anyMatch(this::isDuplicate);
    }
    
    public void deleteContact(String name) {
        Contact contact = contactList.stream()
                .filter(c -> c.getFirstName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);

        if (contact != null) {
            contactList.remove(contact);
            removeFromDictionaries(contact);
            System.out.println("Contact found and deleted.");
        } else {
            System.out.println("Contact not found.");
        }
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

    public Contact getContactbyName(String name) {
        return contactList.stream()
                .filter(contact -> contact.getFirstName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public List<Contact> searchPersonInCityOrState(String location) {
        return contactList.stream()
                .filter(contact -> contact.getCity().equalsIgnoreCase(location)
                        || contact.getState().equalsIgnoreCase(location))
                .collect(Collectors.toList());
    }

     public List<Contact> viewPersonsByCity(String city) {
        return cityDictionary.getOrDefault(city, new ArrayList<>());
    }

    public List<Contact> viewPersonsByState(String state) {
        return stateDictionary.getOrDefault(state, new ArrayList<>());
    }

    private void updateDictionaries(Contact contact) {
        cityDictionary.computeIfAbsent(contact.getCity(), k -> new ArrayList<>()).add(contact);
        stateDictionary.computeIfAbsent(contact.getState(), k -> new ArrayList<>()).add(contact);
    }

    private void removeFromDictionaries(Contact contact) {
        cityDictionary.computeIfPresent(contact.getCity(), (k, v) -> {
            v.remove(contact);
            return v.isEmpty() ? null : v;
        });
        stateDictionary.computeIfPresent(contact.getState(), (k, v) -> {
            v.remove(contact);
            return v.isEmpty() ? null : v;
        });
    }

    private boolean isDuplicate(Contact contact) {
        return contactList.stream().anyMatch(c -> c.equals(contact));
    }

    public long countPersonsByCity(String city) {
        return contactList.stream()
                .filter(contact -> contact.getCity().equalsIgnoreCase(city))
                .count();
    }
    
    public long countPersonsByState(String state) {
        return contactList.stream()
                .filter(contact -> contact.getState().equalsIgnoreCase(state))
                .count();
    }
    
}


