package com.crazycode.util;

import tk.mybatis.mapper.genid.GenId;

import java.util.UUID;

/**
 * 使用 UUID 方式时，首先我们需要提供一个能产生 UUID 的实现类
 * 这个实现类就是简单的返回了一个 String 类型的值，并且没有处理 UUID 中的 -。
 *
 * @author Administrator
 */
public class UUIdGenId implements GenId<String> {
    @Override
    public String genId(String s, String s1) {
        return UUID.randomUUID().toString();
    }
}
