package top.zywork.dao.impl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import top.zywork.dao.ModuleDAO;
import top.zywork.dos.ModuleDO;
import top.zywork.query.PageQuery;
import top.zywork.query.StatusQuery;

import java.util.List;

/**
 * 模块DAO实现类<br />
 * 创建于2017-09-11
 *
 * @author 王振宇
 * @version 1.0
 */
public class ModuleDAOImpl extends HibernateDaoSupport implements ModuleDAO {
    @Override
    public void save(ModuleDO moduleDO) {

    }

    @Override
    public void remove(ModuleDO moduleDO) {

    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public void update(ModuleDO moduleDO) {

    }

    @Override
    public void updateStatus(StatusQuery statusQuery) {

    }

    @Override
    public ModuleDO getById(Long id) {
        return null;
    }

    @Override
    public List<ModuleDO> listAll() {
        return null;
    }

    @Override
    public List<ModuleDO> listPage(PageQuery pageQuery) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }
}
