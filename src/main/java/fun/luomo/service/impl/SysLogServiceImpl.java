package fun.luomo.service.impl;

import fun.luomo.dao.ISysLogDao;
import fun.luomo.domain.SysLog;
import fun.luomo.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Luomo
 * @since 2020/2/18 15:12
 */
@Service
@Transactional
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    ISysLogDao sysLogDao;

    @Override
    public void save(SysLog sysLog) throws Exception {
        sysLogDao.save(sysLog);

    }

    @Override
    public List<SysLog> findAll() throws Exception {
        return sysLogDao.findAll();
    }
}
