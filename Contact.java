import java.util.Scanner;

public class Contact {
    private String firstName, lastName, address, city, state, zipCode, phoneNumber, email;

    public void inputContact() {
        Scanner sc = new Scanner(System.in);
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
        sc.close();
    }
}