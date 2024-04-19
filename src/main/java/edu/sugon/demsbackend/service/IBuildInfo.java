package edu.sugon.demsbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.sugon.demsbackend.common.PageResult;
import edu.sugon.demsbackend.entity.BuildInfo;
import edu.sugon.demsbackend.vo.BuildInfoPageVo;
import edu.sugon.demsbackend.vo.BuildInfoVo;
import java.util.List;

public interface IBuildInfo extends IService<BuildInfo> {
    //新增楼栋
    boolean save(BuildInfoVo vo) throws Exception;
    //修改楼栋
    boolean update(BuildInfoVo vo) throws Exception;
    //分页查询
    PageResult<BuildInfo> page(BuildInfoPageVo vo);
    //批量删除
    void delete(List<String> ids);

}
