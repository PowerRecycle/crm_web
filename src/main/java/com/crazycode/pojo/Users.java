package com.crazycode.pojo;

import com.crazycode.util.UUIdGenId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Id;
import java.util.List;

/**
 * Users
 *
 * @author Administrator
 */
@Data
@NameStyle(Style.normal)
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @KeySql(genId = UUIdGenId.class)
    private String id;
    private String email;
    private String username;
    private String password;
    // @Column(name = "phoneNum")
    private String phoneNum;
    private Long status;
    private List<Role> roleList = null;
    public Users(String username) {
        this.username = username;
    }
}
