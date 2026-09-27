
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-04-21 18:15:21
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.codegen.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Role.
 *
 * @author zhongj
 */
public class Role {
    private Long id;

    private String name = null;

    private String descp;

    private Collection<User> userColl = new ArrayList<>();

    private List<User> userList = new ArrayList<>();

    private Set<User> userSet = new HashSet<>();

    private User[] userArray = new User[0];

    private List<User.Gender> genderList = new ArrayList<>();

    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }

    public Collection<User> getUserColl() {
        return userColl;
    }

    public void setUserColl(Collection<User> userColl) {
        this.userColl = userColl;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    public User[] getUserArray() {
        return userArray;
    }

    public void setUserArray(User[] userArray) {
        this.userArray = userArray;
    }

    /**
     * get genderList value
     *
     * @return genderList
     */
    public List<User.Gender> getGenderList() {
        return genderList;
    }

    /**
     * set genderList value
     *
     * @param genderList genderList
     */
    public void setGenderList(List<User.Gender> genderList) {
        this.genderList = genderList;
    }

    /**
     * get user value
     *
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * set user value
     *
     * @param user user
     */
    public void setUser(User user) {
        this.user = user;
    }
}
