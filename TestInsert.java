@Test
public void testInsert() throws Exception {
	BookDao bookDao = new BookDao();
	for (int i = 0; i < 50; i++) {
		Book book = new Book(UUID.randomUUID().toString(),
				"Thinking In Java" + i,
				"makwan" + i,
				60.0 + i,
				"机械工业出版社" + i,
				"Java编程语言");
		bookDao.insert(book);
	}
}