package edu.sugon.demsbackend.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.Getter;

@Getter
public enum MaleFemaleEnum implements IEnum<String> {
    MALE("MALE","男"),
    FEMALE("FEMALE","女");
    @EnumValue
    private final String value;
    private final String desc;

    MaleFemaleEnum(String value,String desc){
        this.value = value;
        this.desc = desc;
    }


}
