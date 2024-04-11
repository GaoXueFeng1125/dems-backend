package edu.sugon.demsbackend.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "BasePageVo",title = "基本分页")
public class BasePageVo {
    @Schema(name = "cur",title = "当前页")
    private int cur;
    @Schema(name = "pageSize",title = "每页条数")
    private int pageSize = 20;
}
