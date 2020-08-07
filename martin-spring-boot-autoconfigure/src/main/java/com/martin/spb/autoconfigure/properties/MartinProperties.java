package com.martin.spb.autoconfigure.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * 类MartinProperties的实现描述：
 *
 * @author panyinghua 2020-8-7 15:02
 */
@ConfigurationProperties(prefix = "martin.test")
public class MartinProperties {
    /**
     * 配置开关
     */
    private boolean enable = false;

    /**
     * 名字列表
     */
    private List<String> names = new ArrayList<>();


    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }


}
