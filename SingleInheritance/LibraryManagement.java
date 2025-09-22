package SingleInheritance;



class Book {
    private String title;
    private int publicationYear;

    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
}

class Author extends Book {
    private String name;
    private String bio;

    public Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Author Name: " + name);
        System.out.println("Author Bio: " + bio);
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Author book1 = new Author("Effective Java", 2018, "Joshua Bloch", "Joshua Bloch is a software engineer and author, best known for his work on the Java platform.");
        book1.displayInfo();

        System.out.println();

        Author book2 = new Author("Clean Code", 2008, "Robert C. Martin", "Robert C. Martin, also known as Uncle Bob, is a software engineer and author focused on software craftsmanship.");
        book2.displayInfo();
    }
}

