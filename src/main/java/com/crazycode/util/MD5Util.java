package com.crazycode.util;

import com.crazycode.pojo.Users;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @author Administrator
 */
public class MD5Util {
    public static String md5Hash(Users user) {
        ByteSource salt = ByteSource.Util.bytes(user.getUsername());
        return new SimpleHash(Md5Hash.ALGORITHM_NAME, user.getPassword(), salt, 1024).toHex();
    }
}
