package com.crazycode.mapper;

import com.crazycode.pojo.Member;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author Administrator
 */
@Component
public interface MemberMapper extends Mapper<Member> {
}
