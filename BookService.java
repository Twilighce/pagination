public class BookService {
	private static BookDao bookDao = new BookDao();
	
	public Page<Book> getPageData(String currentPage) {
		Page<Book> page = null;
		try {
			// 获取总记录数
			int count = bookDao.getCount();
			if (count > 0) {
				int cp = StringUtils.isBlank(currentPage) ? 1 
						: Integer.parseInt(currentPage);
				page = new Page<Book>(count, cp);
				// 获取指定页的数据
				List<Book> list = bookDao.getPageData(page.getOffset(), page.getPageSize());
				page.setList(list);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return page;
	}
}