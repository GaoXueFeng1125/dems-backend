package edu.sugon.demsbackend.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.sugon.demsbackend.enums.YesNoEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class BaseEntity {
    @Schema(name = "id",title = "主键")
    private String id;
    @Schema(name = "createdBy",title = "创建人")
    private String createdBy;
    @Schema(name = "createdTime",title = "创建时间")
    @JsonFormat(pattern = "yyyy年MM月dd日 HH:mm",timezone = "GMT+8")
    private Date createdTime;
    @Schema(name = "updatedBy",title = "修改人")
    private String updatedBy;
    @Schema(name = "updatedTime",title = "修改时间")
    @JsonFormat(pattern = "yyyy年MM月dd日 HH:mm",timezone = "GMT+8")
    private Date updatedTime;
    @Schema(name = "deleteFlag",title = "删除标记")
    private YesNoEnum deleteFlag;

    public void preSave(String userId){
        this.id = UUID.randomUUID().toString().replaceAll("-","");
        this.createdBy = userId;
        this.createdTime = new Date();
        this.updatedBy = userId;
        this.updatedTime = new Date();
        this.deleteFlag = YesNoEnum.NO;
    }

    public void preUpdate(String userId){
        this.updatedBy = userId;
        this.updatedTime = new Date();
    }

    public void preDelete(String userId){
        this.updatedBy = userId;
        this.updatedTime = new Date();
        this.deleteFlag = YesNoEnum.YES;
    }
}


