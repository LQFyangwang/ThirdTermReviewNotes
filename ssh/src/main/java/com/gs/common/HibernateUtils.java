package com.gs.common;

import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class HibernateUtils {

    public static <T> Pager<T> pager(Session session, Pager<T> pager, T t, Class<T> tClass) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(tClass);
        Root<T> root = criteriaQuery.from(tClass);
        criteriaQuery = HibernateUtils.rebuildRowsCriteriaQuery(criteriaQuery, criteriaBuilder, root, t);
        Query query = session.createQuery(criteriaQuery);
        query.setFirstResult(pager.getBeginIndex());
        query.setMaxResults(pager.getPageSize());
        pager.setRows(query.list());
        return pager;
    }

    public static <T> Long count(Session session, T t, String fieldCount, Class<T> tClass) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<T> root = criteriaQuery.from(tClass);
        if (fieldCount == null) {
            fieldCount = "id";
        }
        criteriaQuery.select(criteriaBuilder.count(root.get(fieldCount)));
        criteriaQuery = HibernateUtils.rebuildCountCriteriaQuery(criteriaQuery, criteriaBuilder, root, t);
        return session.createQuery(criteriaQuery).uniqueResult();
    }

    public static <T> CriteriaQuery<T> rebuildRowsCriteriaQuery(CriteriaQuery<T> criteriaQuery,
                                                            CriteriaBuilder criteriaBuilder,
                                                            Root<T> root,
                                                            T t) {
        return rebuildCriteriaQuery(criteriaQuery, criteriaBuilder, root, t);



    }

    public static <T> CriteriaQuery<Long> rebuildCountCriteriaQuery(CriteriaQuery<Long> criteriaQuery,
                                                            CriteriaBuilder criteriaBuilder,
                                                            Root<T> root,
                                                            T t) {
        return rebuildCriteriaQuery(criteriaQuery, criteriaBuilder, root, t);
    }


    private static <T> CriteriaQuery rebuildCriteriaQuery(CriteriaQuery criteriaQuery,
                                                                    CriteriaBuilder criteriaBuilder,
                                                                    Root<T> root,
                                                                    T t) {
        if (t != null) {
            Field[] fields = t.getClass().getDeclaredFields();
            List<Predicate> predicateList = new ArrayList<>();
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName();
                try {
                    Object value = field.get(t);
                    if (value != null && value instanceof String) {
                        predicateList.add(criteriaBuilder.like(root.get(fieldName), "%" + (String) value + "%"));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            if (predicateList.size() > 0) {
                criteriaQuery.where(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        }
        return criteriaQuery;
    }

    public static <T> List<T> buildBean(List<Object[]> data, String[] aliasArray, Class<T> tClass) {
        List<T> list = new ArrayList<>();
        try {
            for (Object[] row : data) {
                T t = tClass.newInstance();
                for (int i = 0, len = row.length; i < len; i++) {
                    Object value = row[i];
                    String fieldName = aliasArray[i];
                    Field field = tClass.getDeclaredField(fieldName);
                    field.setAccessible(true);
                    if (value != null && value instanceof BigInteger) {
                        field.set(t, ((BigInteger) value).longValue());
                    } else {
                        field.set(t, value);
                    }
                }
                list.add(t);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return list;
    }

}
