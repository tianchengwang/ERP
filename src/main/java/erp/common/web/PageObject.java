package erp.common.web;

import java.io.Serializable;

/**��װ����ķ�ҳ��Ϣ*/
public class PageObject implements Serializable{
	private static final long serialVersionUID = -8753809986545361268L;
	/**��ǰҳ*/
	private int pageCurrent=1;
	/**ÿҳ�������ʾ�ļ�¼��*/
	private int pageSize=3;
	/**�ܼ�¼��*/
	private int rowCount;
	/**��һҳ�����һ����¼λ��
	 * ��Ӧ:limit startIndex,pageSize;
	 */
	private int startIndex;
	public int getPageCurrent() {
		return pageCurrent;
	}
	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public int getPageCount() {
	  	int pages = rowCount/pageSize;
    	if(0 != rowCount%pageSize) {
    		pages +=1;
    	}
        return pages;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	
	
	
	
	
	
	
}
