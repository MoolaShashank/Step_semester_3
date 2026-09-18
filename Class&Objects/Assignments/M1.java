class BookInventory {
    String title;
    String author;
    int copiesAvailable;

    public BookInventory(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    void printEntry() {
        System.out.println(title + " by " + author + " " + copiesAvailable + " copies available");
    }

    public static void main(String[] args) {
        BookInventory[] inventory = new BookInventory[4];
        inventory[0] = new BookInventory("Clean Code", "Robert C. Martin", 3);
        inventory[1] = new BookInventory("Effective Java", "Joshua Bloch", 5);
        inventory[2] = new BookInventory("Refactoring", "Martin Fowler", 0);
        inventory[3] = new BookInventory("Design Patterns", "GoF", 2);

        for (BookInventory book : inventory) {
            book.printEntry();
        }
    }
}
