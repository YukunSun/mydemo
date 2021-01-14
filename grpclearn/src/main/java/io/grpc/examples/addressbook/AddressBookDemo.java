package io.grpc.examples.addressbook;

import java.io.*;

/**
 * @author sunyk
 **/
public class AddressBookDemo {
    public static void main(String[] args) throws IOException {
        AddressBookProto.Person person = AddressBookProto.Person.newBuilder()
                .setEmail("1")
                .setName("hello")
                .build();
        System.out.println(person.toString());
        System.out.println(person.isInitialized());
        System.out.println(person.toByteArray());


        if (args.length != 1) {
            System.err.println("Usage:  AddPerson ADDRESS_BOOK_FILE");
            System.exit(-1);
        }

        AddressBookProto.AddressBook.Builder addressBook = AddressBookProto.AddressBook.newBuilder();

        // Read the existing address book.
        try {
            addressBook.mergeFrom(new FileInputStream(args[0]));
        } catch (FileNotFoundException e) {
            System.out.println(args[0] + ": File not found.  Creating a new file.");
        }

        // Add an address.
        addressBook.addPeople(
                PromptForAddress(new BufferedReader(new InputStreamReader(System.in)),
                        System.out));

        // Write the new address book back to disk.
        FileOutputStream output = new FileOutputStream(args[0]);
        addressBook.build().writeTo(output);
        output.close();
    }

    // This function fills in a Person message based on user input.
    static AddressBookProto.Person PromptForAddress(BufferedReader stdin,
                                                    PrintStream stdout) throws IOException {
        AddressBookProto.Person.Builder person = AddressBookProto.Person.newBuilder();

        stdout.print("Enter person ID: ");
        person.setId(Integer.valueOf(stdin.readLine()));

        stdout.print("Enter name: ");
        person.setName(stdin.readLine());

        stdout.print("Enter email address (blank for none): ");
        String email = stdin.readLine();
        if (email.length() > 0) {
            person.setEmail(email);
        }
        while (true) {
            stdout.print("Enter a phone number (or leave blank to finish): ");
            String number = stdin.readLine();
            if (number.length() == 0) {
                break;
            }
            AddressBookProto.Person.PhoneNumber.Builder phoneNumber =
                    AddressBookProto.Person.PhoneNumber.newBuilder().setNumber(number);

            stdout.print("Is this a mobile, home, or work phone? ");
            String type = stdin.readLine();
            if (type.equals("mobile")) {
                phoneNumber.setPhoneType(AddressBookProto.Person.PhoneType.MOBILE);
            } else if (type.equals("home")) {
                phoneNumber.setPhoneType(AddressBookProto.Person.PhoneType.HOME);
            } else if (type.equals("work")) {
                phoneNumber.setPhoneType(AddressBookProto.Person.PhoneType.WORK);
            } else {
                stdout.println("Unknown phone type.  Using default.");
            }

            person.addPhones(phoneNumber);
        }
        return person.build();
    }
}
