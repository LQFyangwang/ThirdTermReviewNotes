package top.zywork.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import top.zywork.common.ExceptionUtils;
import top.zywork.dao.PermissionDAO;
import top.zywork.dos.PermissionDO;
import top.zywork.query.PageQuery;
import top.zywork.query.StatusQuery;

import java.util.List;

/**
 * 权限DAO实现类<br />
 * 创建于2017-09-11
 *
 * @author 王振宇
 * @version 1.0
 */
public class PermissionDAOImpl extends HibernateDaoSupport implements PermissionDAO {
    @Override
    public List<PermissionDO> listByModuleId(String moduleId) {
        return null;
    }

    @Override
    public List<PermissionDO> listByRoleId(String roleId) {
        return null;
    }

    @Override
    public List<PermissionDO> listByRoleIds(List<Long> roleIds) {
        List<PermissionDO> permissionDOList = getHibernateTemplate().execute(new HibernateCallback<List<PermissionDO>>() {
            @Override
            public List<PermissionDO> doInHibernate(Session session) throws HibernateException {
                String hql = "select distinct p from PermissionDO p join p.rolePermissionDOSet rp" +
                        " where rp.id in (:roleIds)";
                try {
                    Query<PermissionDO> query = session.createQuery(hql, PermissionDO.class);
                    query.setParameter("roleIds", roleIds);
                    return query.list();
                } catch (RuntimeException e) {
                    throw ExceptionUtils.daoException(e);
                }
            }
        });
        return permissionDOList;
    }

    @Override
    public List<PermissionDO> listByAccount(String account) {
        List<PermissionDO> permissionDOList = getHibernateTemplate().execute(new HibernateCallback<List<PermissionDO>>() {
            @Override
            public List<PermissionDO> doInHibernate(Session session) throws HibernateException {
                String hql = "select distinct p from PermissionDO p join p.rolePermissionDOSet rp"
                        + " join rp.roleDO r join r.userRoleDOSet ur join ur.userDO u"
                        + " where (u.email = :account or u.phone = :account or u.accountName = :account)";
                try {
                    Query<PermissionDO> query = session.createQuery(hql, PermissionDO.class);
                    query.setParameter("account", account);
                    return query.list();
                } catch (RuntimeException e) {
                    throw ExceptionUtils.daoException(e);
                }
            }
        });
        return permissionDOList;
    }

    @Override
    public void save(PermissionDO permissionDO) {

    }

    @Override
    public void remove(PermissionDO permissionDO) {

    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public void update(PermissionDO permissionDO) {

    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {

    }

    @Override
    public PermissionDO getById(Long id) {
        return null;
    }

    @Override
    public List<PermissionDO> listAll() {
        return null;
    }

    @Override
    public List<PermissionDO> listPage(PageQuery pageQuery) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }
}
