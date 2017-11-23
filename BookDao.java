public class BookDao {
	/**
	 * 获取一页图书数据
	 * 
	 * @param offset
	 * @param size
	 * @return
	 */
	public List<Book> getPageData(int offset, int size) {
		List<Book> list = new ArrayList<Book>();
		
		Connection con = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		try {
			con = DBUtils.getConnection();
			String sql = "select * from book limit ?, ?";
			pStmt = con.prepareStatement(sql);
			
			// 设置参数
			pStmt.setInt(1, offset);
			pStmt.setInt(2, size);
			// 执行查询
			rs = pStmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String author = rs.getString(3);
				double price = rs.getDouble(4);
				String publisher = rs.getString(5);
				String type = rs.getString(6);
				
				Book book = new Book(id, name, author, price, publisher, type);
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.release(con, pStmt, rs);
		}
		return list;
	}
	
	/**
	 * 获取统计的图书记录数
	 * 
	 * @return
	 */
	public int getCount() {
		int count = 0;
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			con = DBUtils.getConnection();
			stmt = con.createStatement();
			String sql = "select count(*) from book";
			rs = stmt.executeQuery(sql);
			rs.next();
			count = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.release(con, stmt, rs);
		}
		
		return count;
	}
	
	/**
	 * 插入图书数据
	 * 
	 * @param book
	 */
	public void insert(Book book) {
		Connection con = null;
		PreparedStatement pStmt = null;
		
		try {
			con = DBUtils.getConnection();
			String sql = "insert into book values(?, ?, ?, ?, ?, ?)";
			pStmt = con.prepareStatement(sql);
			
			// 设置参数
			pStmt.setString(1, book.getId());
			pStmt.setString(2, book.getName());
			pStmt.setString(3, book.getAuthor());
			pStmt.setDouble(4, book.getPrice());
			pStmt.setString(5, book.getPublisher());
			pStmt.setString(6, book.getType());
			// 执行
			pStmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.release(con, pStmt, null);
		}
	}
	
	/**
	 * 删除所有图书数据
	 */
	public void deleteAll() {
		Connection con = null;
		Statement stmt = null;
		
		try {
			con = DBUtils.getConnection();
			stmt = con.createStatement();
			String sql = "delete from book";
			stmt.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.release(con, stmt, null);
		}
	}
}