public class Page<T> {
	// 一页的数据
	private List<T> list = null;
	// 一页数据的起始位置
	private int offset = 0;
	// 一页数据的大小
	private int pageSize = 2;
	// 总记录数
	private int recordCount = 0;
	// 总页数
	private int pageCount = 0;
	//当前页索引
	private int currentPage = 0;
	
	// 分页条宽度
	private int width = 10;
	// 分页条起始位置
	private int begin;
	// 分页条结束位置
	private int end;
	
	public Page(int rCount, int currPage) {
		recordCount = rCount;
		currentPage = currPage;
		
		pageCount = recordCount / pageSize + (recordCount % pageSize == 0 ? 0 : 1);
		
		offset = (currentPage - 1) * pageSize;
		
		// 计算分页条起始和结束的位置
		// 具体分为两种情况:
		//   1.总页数小于等于分页条宽度
		//   2.总页数大于分页条宽度
		if (pageCount <= width) {
			begin = 1;
			end = pageCount;
		} else {
			// 当总页数多于分页条宽度时, 又分3种情况
			//   1.当前页索引小于等于分页条一半宽度
			//   2.当前页索引大于(总页数-分页条一半宽度)
			//   3.当前页索引介于条件1, 2之间
			int pivot = width / 2;
			if (currentPage <= pivot) {
				begin = 1;
				end = width;
			} else if (currentPage > pageCount - pivot) {
				begin = pageCount - width + 1;
				end = pageCount;
			} else {
				begin = currentPage - pivot;
				// width & 0x1 ^ 0x1的作用相当于width % 2 == 0 : 1 : 0 
				end = currentPage + pivot - (width & 0x1 ^ 0x1);
			}
		}
	}
	public List<T> getList() {
		return list;
	}
	
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getOffset() {
		return offset;
	}
	public int getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRecordCount() {
		return recordCount;
	}
	
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
}