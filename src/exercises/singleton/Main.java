package exercises.singleton;

import exercises.singleton.classes.Singleton;

public class Main {
  public static void main(String[] args) {
    Singleton config = Singleton.getInstance();

    // Load info into variables
    String name = config.read("name");
    String age = config.read("age");
    String eMail = config.read("email");

    // Get info
    System.out.println("Info after set:");
    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
    System.out.println("E-mail: " + eMail);

    System.out.println(); // radbrytning

    // Change info and save to cfg
    config.save("name", "Fredrik");
    config.save("age", "34");
    config.save("email", "flundell89@gmail.com");

    // Read updated info
    String updatedName = config.read("name");
    String updatedAge = config.read("age");
    String updatedEmail = config.read("email");

    System.out.println("Info after update:");
    System.out.println("Name: " + updatedName);
    System.out.println("Age: " + updatedAge);
    System.out.println("E-mail: " + updatedEmail);
  }


}