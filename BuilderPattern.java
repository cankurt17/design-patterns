 
 

 class Book{
    
    private int id;
    private int pageNumber;
    private int edition;
    
    private String name;
    private String authorName;
    
    private double price;
    private double rate;
    
    private boolean defaultBookMarker;
    private boolean eBookVersion;

    @Override
    public String toString() {
        return "Book\n{" + "id=" + id + ", pageNumber=" + pageNumber + ", edition=" + edition + 
                "\nname=" + name + ", authorName=" + authorName + ", "
                + "\nprice=" + price + ", rate=" + rate + 
                "\ndefaultBookMarker=" + defaultBookMarker + ", eBookVersion=" + eBookVersion + '}';
    }
    
    
    public void setId(int id) {
        this.id = id;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setDefaultBookMarker(boolean defaultBookMarker) {
        this.defaultBookMarker = defaultBookMarker;
    }

    public void seteBookVersion(boolean eBookVersion) {
        this.eBookVersion = eBookVersion;
    }
    
    
}

class BookBuilder{
    
    private int id;
    private int pageNumber;
    private int edition;
    
    private String name;
    private String authorName;
    
    private double price;
    private double rate;
    
    private boolean defaultBookMarker;
    private boolean eBookVersion;
    
    public static BookBuilder startBuild(int id, int pageNumber, String name){
       
        BookBuilder bookBuilder = new BookBuilder();
        
        bookBuilder.id = id;
        bookBuilder.pageNumber = pageNumber;
        bookBuilder.name = name;
        
        return bookBuilder;
    }

    public static BookBuilder buildBookWithEBookVersion(int id, int pageNumber, String name, boolean eBookVersion){
        BookBuilder bookBuilder = new BookBuilder();
        
        bookBuilder.id = id;
        bookBuilder.pageNumber = pageNumber;
        bookBuilder.name = name;
        
        bookBuilder.eBookVersion = eBookVersion;
        
        return bookBuilder;
    }
    
    public BookBuilder setDefaultBookMarker(boolean defaultBookMarker) {
        this.defaultBookMarker = defaultBookMarker;
        return this;
    }
     
    public Book build(){
        Book book = new Book();
        
        book.setId(id);
        book.setPageNumber(pageNumber);
        book.setEdition(edition);
        
        book.setName(name);
        book.setAuthorName(authorName);
        
        book.setPageNumber(pageNumber);
        book.setPrice(price);
        
        book.setDefaultBookMarker(defaultBookMarker);
        book.seteBookVersion(eBookVersion);
        
        return book;
    }
    
}

public class BuilderPattern{
    public static void main(String[] args){
        
        //Default özelliklere sahip kitap;
        Book book1 = BookBuilder.startBuild(1, 432,"Kuzuların Sessizliği").build();
        
        //Default özellikler + ebook özelliğine sahip kitap;
        Book book2 = BookBuilder.buildBookWithEBookVersion(2, 172, "Otomatik Portokal", true).build();
        
        //Default özellikler + book marker özelliğines sahip kitap;
        Book book3 = BookBuilder.startBuild(3, 140, "Psycho").setDefaultBookMarker(true).build();
        
        //Kitap özelliklerini görüntüleme; 
        System.out.println(book1.toString()+"\n");
        System.out.println(book2.toString()+"\n");
        System.out.println(book3.toString());
    }
}