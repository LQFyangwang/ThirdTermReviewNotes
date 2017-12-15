package top.zywork.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import top.zywork.common.ExceptionUtils;
import top.zywork.dao.UserDAO;
import top.zywork.dos.UserDO;
import top.zywork.query.PageQuery;
import top.zywork.query.StatusQuery;
import top.zywork.query.UserAccountPasswordQuery;

import java.util.List;

/**
 * 用户DAO实现类<br />
 * 创建于2017-09-05
 *
 * @author 王振宇
 * @version 1.0
 */
public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {

    @Override
    public UserDO getByAccountPassword(UserAccountPasswordQuery userAccountPasswordQuery) {
        UserDO userDO = getHibernateTemplate().execute(new HibernateCallback<UserDO>() {

            @Override
            public UserDO doInHibernate(Session session) throws HibernateException {
                String hql = "from UserDO u where u.password = :password"
                        + " and (u.email = :account or u.phone = :account or u.accountName = :account)";
                try {
                    Query<UserDO> query = session.createQuery(hql, UserDO.class);
                    query.setParameter("password", userAccountPasswordQuery.getPassword());
                    query.setParameter("account", userAccountPasswordQuery.getAccount());
                    return query.uniqueResult();
                } catch (RuntimeException e) {
                    throw ExceptionUtils.daoException(e);
                }
            }
        });
        return userDO;

    }


    @Override
    public void save(UserDO userDO) {

    }

    @Override
    public void remove(UserDO userDO) {

    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public void update(UserDO userDO) {

    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {

    }

    @Override
    public UserDO getById(Long id) {
        return null;
    }

    @Override
    public List<UserDO> listAll() {
        return null;
    }

    @Override
    public List<UserDO> listPage(PageQuery pageQuery) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }
}
