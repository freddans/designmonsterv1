package exercises.proxy;

import exercises.proxy.classes.Proxy;

public class Main {
  public static void main(String[] args) {
    Proxy proxy = new Proxy();

    proxy.addBadWord("bajs");

    proxy.displayInfo("name");
    proxy.displayInfo("age");
    proxy.displayInfo("email");

    System.out.println();

    proxy.write("name", "freds");
    proxy.write("age", "30");
    proxy.write("email", "freds");

    System.out.println();

    proxy.displayInfo("name");
    proxy.displayInfo("age");
    proxy.displayInfo("email");

    System.out.println();

    proxy.write("phone", "0708388404");
    proxy.write("name", "Fredrik");
    proxy.write("age", "34");
    proxy.write("email", "flundell89@gmail.com");
    proxy.write("phone", "0708388404");

    System.out.println();

    proxy.displayInfo("name");
    proxy.displayInfo("age");
    proxy.displayInfo("email");
    proxy.displayInfo("phone");

    proxy.write("phone", "bajs");
    proxy.write("name", "freddan");

    proxy.displayInfo("phone");
    proxy.displayInfo("name");
  }
}