package edu.sugon.demsbackend.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
public enum DirMenuEnum implements IEnum<String>{
    DIR("DIR","目录"),
    MENU("MENU","菜单");
    @EnumValue
    private final String value;
    private final String desc;
    DirMenuEnum(String value,String desc){
        this.value = value;
        this.desc = desc;
    }

}
