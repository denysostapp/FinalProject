import java.util.ArrayList;
import java.util.Scanner;

class Item {
    private String title;
    private int year;  // Numeric property for sorting

    // Constructor
    public Item(String title, int year) {
        this.title = title;
        this.year = year;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    // Other methods
    public String getDescription() {
        return "Title: " + title + "\nYear: " + year;
    }
}

class Collection {
    private ArrayList<Item> items;

    // Constructor
    public Collection() {
        this.items = new ArrayList<>();
    }

    // Basic version methods
    public void add(Item item) {
        items.add(item);
    }

    public void remove(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
        }
    }

    public void printOne(int index) {
        if (index >= 0 && index < items.size()) {
            System.out.println(items.get(index).getDescription());
        }
    }

    public void printAll() {
        for (Item item : items) {
            System.out.println(item.getDescription());
        }
    }

    public void printList() {
        int index = 1;
        for (Item item : items) {
            System.out.println(index + " - " + item.getTitle());
            index++;
        }
    }

    public void search(String phrase) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getTitle().contains(phrase)) {
                System.out.println(i + " - " + items.get(i).getDescription());
            }
        }
    }

    public void searchByYear(int year) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getYear() == year) {
                System.out.println(i + " - " + items.get(i).getDescription());
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Collection collection = new Collection();

        while (true) {
            System.out.println("Welcome to the hobby object database!");
            System.out.println("Choose an option to proceed:");
            System.out.println("1 - print list");
            System.out.println("2 - add new player");
            System.out.println("3 - remove player");
            System.out.println("4 - search players");
            System.out.println("5 - search players by year");
            System.out.println("6 - print all list");
            System.out.println("0 - exit the program");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    collection.printList();
                    break;
                case 2:
                    System.out.print("Enter surname of player: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter year of birth: ");
                    int year = scanner.nextInt();
                    collection.add(new Item(title, year));
                    break;
                case 3:
                    System.out.print("Enter the number of the player to delete: ");
                    int playerRemove = scanner.nextInt();
                    collection.remove(playerRemove);
                    break;
                case 4:
                    System.out.print("Enter search phrase: ");
                    String searchPhrase = scanner.nextLine();
                    collection.search(searchPhrase);
                    break;
                case 5:
                    System.out.print("Enter search year: ");
                    int searchYear = scanner.nextInt();
                    collection.searchByYear(searchYear);
                    break;
                case 6:
                    collection.printAll();
                    break;
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
