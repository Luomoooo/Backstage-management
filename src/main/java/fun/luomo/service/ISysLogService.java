package fun.luomo.service;

import fun.luomo.domain.SysLog;

import java.util.List;

/**
 * @author Luomo
 * @since 2020/2/18 15:12
 */
public interface ISysLogService {

    void save(SysLog sysLog) throws Exception;

    List<SysLog> findAll()throws Exception;

}
