package edu.sugon.demsbackend.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import edu.sugon.demsbackend.common.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "BuildInfo",title = "楼栋信息")
@TableName("BUILD_INFO")
public class BuildInfo extends BaseEntity {
    @Schema(name = "buildingsNo",title = "楼栋号")
    private String buildingsNo;
    @Schema(name = "buildingsName",title = "楼栋名称")
    private String buildingsName;
    @Schema(name = "remark",title = "备注")
    private String remark;


}
