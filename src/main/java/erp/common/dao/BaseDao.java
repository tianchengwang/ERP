package erp.common.dao;
/***
 * 通过此接口实现对子类共�?�的提取
 * @author adminitartor
 * @param <T>
 * 通过类上的泛�??<T>约束类中:
 * 1)方法的参数类�??
 * 2)方法的返回�?�类�??
 */
public interface BaseDao<T> {
	int insertObject(T entity);
	int updateObject(T entity);
}




