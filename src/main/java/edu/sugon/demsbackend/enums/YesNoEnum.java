package edu.sugon.demsbackend.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.Getter;

@Getter
public enum YesNoEnum implements IEnum<String> {
    YES("YES", "是"),
    NO("NO", "否");

    @EnumValue
    private final String value;
    private final String desc;

    YesNoEnum(String value,String desc){
        this.value = value;
        this.desc = desc;
    }

}
