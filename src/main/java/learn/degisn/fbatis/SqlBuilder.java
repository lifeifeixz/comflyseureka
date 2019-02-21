package learn.degisn.fbatis;

/**
 * SQL拼接
 *
 * @author flysLi
 * @date 2018/11/27
 */
public interface SqlBuilder {

    /**
     * 拼接SQL语句
     *
     * @param future
     * @return
     */
    String buildSql(Object future);
}
