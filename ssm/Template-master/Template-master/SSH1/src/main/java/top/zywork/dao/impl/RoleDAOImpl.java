package top.zywork.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import top.zywork.common.ExceptionUtils;
import top.zywork.dao.RoleDAO;
import top.zywork.dos.RoleDO;
import top.zywork.query.PageQuery;
import top.zywork.query.StatusQuery;

import java.util.List;

/**
 * 角色DAO实现类<br />
 * 创建于2017-09-11
 *
 * @author 王振宇
 * @version 1.0
 */
public class RoleDAOImpl extends HibernateDaoSupport implements RoleDAO {
    @Override
    public List<RoleDO> listByAccount(String account) {
        List<RoleDO> roleDOList = getHibernateTemplate().execute(new HibernateCallback<List<RoleDO>>() {
            @Override
            public List<RoleDO> doInHibernate(Session session) throws HibernateException {
                String hql = "select r from RoleDO r join r.userRoleDOSet ur join ur.userDO u"
                        + " where u.email = :account or u.phone = :account or u.accountName = :account";
                try {
                    Query<RoleDO> query = session.createQuery(hql, RoleDO.class);
                    query.setParameter("account", account);
                    return query.list();
                } catch (RuntimeException e) {
                    throw ExceptionUtils.daoException(e);
                }
            }
        });
        return roleDOList;
    }

    @Override
    public void save(RoleDO roleDO) {

    }

    @Override
    public void remove(RoleDO roleDO) {

    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public void update(RoleDO roleDO) {

    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {

    }

    @Override
    public RoleDO getById(Long id) {
        return null;
    }

    @Override
    public List<RoleDO> listAll() {
        return null;
    }

    @Override
    public List<RoleDO> listPage(PageQuery pageQuery) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }
}
