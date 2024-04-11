package edu.sugon.demsbackend.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Schema(name = "PageResult",title = "分页返回")
public class PageResult<T> implements Serializable {
    @Schema(name = "total",title = "总条数")
    private long total;
    @Schema(name = "items",title = "数据列表")
    private List<T> items;
}
