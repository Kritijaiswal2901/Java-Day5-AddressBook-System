import java.util.Scanner;

public class Contact {
    private String firstName, lastName, address, city, state, zipCode, phoneNumber, email;

    public String getName() {
        return this.firstName;
    }

    public void inputContact(Scanner sc) {
        System.out.println("Enter your first name : ");
        this.firstName = sc.nextLine();
        System.out.println("Enter your last name : ");
        this.lastName = sc.nextLine();
        System.out.println("Enter your address : ");
        this.address = sc.nextLine();
        System.out.println("Enter your city name : ");
        this.city = sc.nextLine();
        System.out.println("Enter your state name : ");
        this.state = sc.nextLine();
        System.out.println("Enter your zip code : ");
        this.zipCode = sc.nextLine();
        System.out.println("Enter your phone number : ");
        this.phoneNumber = sc.nextLine();
        System.out.println("Enter your email : ");
        this.email = sc.nextLine();
    }

    public void editContact(Scanner sc) {
        String temp = "";
        System.out.println("Edit Contact");
        System.out.println("Enter new address (" + this.address + "): ");
        temp = sc.nextLine();
        this.address = temp;
        System.out.println("Enter new city (" + this.city + "): ");
        temp = sc.nextLine();
        this.city = temp;
        System.out.println("Enter new state (" + this.state + "): ");
        temp = sc.nextLine();
        this.state = temp;
        System.out.println("Enter new zip code (" + this.zipCode + "): ");
        temp = sc.nextLine();
        this.zipCode = temp;
        System.out.println("Enter new phone number (" + this.phoneNumber + "): ");
        temp = sc.nextLine();
        this.phoneNumber = temp;
        System.out.println("Enter new email (" + this.email + "): ");
        temp = sc.nextLine();
        this.email = temp;
    }

    public void printContact() {
        System.out.println("Contact: ");
        System.out.println("First Name: " + this.firstName);
        System.out.println("Last Name: " + this.lastName);
        System.out.println("Address: " + this.address);
        System.out.println("City: " + this.city);
        System.out.println("State: " + this.state);
        System.out.println("Zip code: " + this.zipCode);
        System.out.println("Phone Number: " + this.phoneNumber);
        System.out.println("Email: " + this.email);
    }
}