public class Book {
	private String id;
	private String name;
	private String author;
	private double price;
	private String publisher;
	private String type;
	
	public Book() {
		
	}
	public Book(String id, String name, String author, double price,
			String publisher, String type) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
		this.publisher = publisher;
		this.type = type;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author
				+ ", price=" + price + ", publisher=" + publisher + ", type="
				+ type + "]";
	}
	// 省略get/set方法
}