package script.core;

import script.core.beans.Page;

/**
 *
 * @author flysLi
 * @date 2018/12/19
 */
public interface BaseMapper<T, E> {

    T findOne(E e);

    T findAll();

    int delete(E e);

    T update(T t);

    T findAll(T e, Page page);

    int count(T t);
}
