
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-04-21 18:13:21
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.codegen.vo;

/**
 * RoleDto.
 *
 * @author zhongj
 */
public class RoleDto2 {

    private UserDto user;

    private UserDto[] userArray = new UserDto[0];

    /**
     * Instantiates a new role dto.
     */
    public RoleDto2() {
        super();
    }

    /**
     * get user value
     *
     * @return user
     */
    public UserDto getUser() {
        return user;
    }

    /**
     * set user value
     *
     * @param user user
     */
    public void setUser(UserDto user) {
        this.user = user;
    }

    /**
     * get userArray value
     *
     * @return userArray
     */
    public UserDto[] getUserArray() {
        return userArray;
    }

    /**
     * set userArray value
     *
     * @param userArray userArray
     */
    public void setUserArray(UserDto[] userArray) {
        this.userArray = userArray;
    }
}
