package edu.sugon.demsbackend.common;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BaseEntity {
    private String id;
    private String createdBy;
    private Date createdTime;
    private String updatedBy;
    private Date updatedTime;
    private String deleteFlag;
}
