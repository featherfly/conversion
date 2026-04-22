
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-04-21 18:13:21
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.conversion.codegen.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.featherfly.common.lang.Lang;
import cn.featherfly.conversion.codegen.domain.Role;
import cn.featherfly.conversion.codegen.domain.User;

/**
 * RoleDto.
 *
 * @author zhongj
 */
public class RoleDto {

    private Long id;

    private String name = null;

    private String descp;

    private Collection<UserDto> userColl = new ArrayList<>();

    private List<UserDto> userList = new ArrayList<>();

    private Set<UserDto> userSet = new HashSet<>();

    private UserDto[] userArray = new UserDto[0];

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

    public Collection<UserDto> getUserColl() {
        return userColl;
    }

    public void setUserColl(Collection<UserDto> userColl) {
        this.userColl = userColl;
    }

    public List<UserDto> getUserList() {
        return userList;
    }

    public void setUserList(List<UserDto> userList) {
        this.userList = userList;
    }

    public Set<UserDto> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<UserDto> userSet) {
        this.userSet = userSet;
    }

    public UserDto[] getUserArray() {
        return userArray;
    }

    public void setUserArray(UserDto[] userArray) {
        this.userArray = userArray;
    }

    public Role toRole() {
        Role role = new Role();
        if (Lang.isNotEmpty(getId())) {
            role.setId(getId());
        }
        if (Lang.isNotEmpty(getName())) {
            role.setName(getName());
        }
        if (Lang.isNotEmpty(getDescp())) {
            role.setDescp(getDescp());
        }
        if (Lang.isNotEmpty(getUserArray())) {
            role.setUserArray(new User[getUserArray().length]);
            for (int i = 0; i < getUserArray().length; i++) {
                UserDto source = getUserArray()[i];
                if (Lang.isNotEmpty(source)) {
                    role.getUserArray()[i] = source.toUser();
                }
            }
        }
        if (Lang.isNotEmpty(getUserColl())) {
            if (role.getUserColl() == null) {
                role.setUserColl(new ArrayList<>());
            } else {
                role.getUserColl().clear();
            }
            for (UserDto userDto : getUserArray()) {
                if (Lang.isNotEmpty(userDto)) {
                    role.getUserColl().add(userDto.toUser());
                }
            }
        }
        if (Lang.isNotEmpty(getUserList())) {
            if (role.getUserList() == null) {
                role.setUserList(new ArrayList<>());
            } else {
                role.getUserList().clear();
            }
            for (UserDto userDto : getUserArray()) {
                if (Lang.isNotEmpty(userDto)) {
                    role.getUserList().add(userDto.toUser());
                }
            }
        }
        if (Lang.isNotEmpty(getUserSet())) {
            if (role.getUserSet() == null) {
                role.setUserSet(new HashSet<>());
            } else {
                role.getUserSet().clear();
            }
            for (UserDto userDto : getUserArray()) {
                if (Lang.isNotEmpty(userDto)) {
                    role.getUserSet().add(userDto.toUser());
                }
            }
        }
        return role;
    }

    public RoleDto(Role role) {
        if (role == null) {
            return;
        }
        if (Lang.isNotEmpty(role.getId())) {
            setId(role.getId());
        }
        if (Lang.isNotEmpty(role.getName())) {
            setName(role.getName());
        }
        if (Lang.isNotEmpty(role.getDescp())) {
            setDescp(role.getDescp());
        }

        if (Lang.isNotEmpty(role.getUserArray())) {
            setUserArray(new UserDto[getUserArray().length]);
            for (int i = 0; i < role.getUserArray().length; i++) {
                User user = role.getUserArray()[i];
                if (Lang.isNotEmpty(user)) {
                    getUserArray()[i] = new UserDto(user);
                }
            }
        }

        if (role.getUserList() != null) {
            if (getUserList() == null) {
                setUserList(new ArrayList<>());
            } else {
                getUserList().clear();
            }
            for (User user : role.getUserArray()) {
                if (Lang.isNotEmpty(user)) {
                    getUserList().add(new UserDto(user));
                }
            }
        }
    }

    public Role toRole2() {
        Role role = new Role();
        if (Lang.isNotEmpty(getId())) {
            role.setId(getId());
        }
        if (Lang.isNotEmpty(getName())) {
            role.setName(getName());
        }
        if (Lang.isNotEmpty(getDescp())) {
            role.setDescp(getDescp());
        }
        if (Lang.isNotEmpty(getUserArray())) {
            role.setUserArray(new User[getUserArray().length]);
            for (int i = 0; i < getUserArray().length; i++) {
                UserDto userDto = getUserArray()[i];
                if (Lang.isNotEmpty(userDto)) {
                    User user = new User();
                    user.setId(userDto.getId());
                    user.setName(userDto.getName());
                    role.getUserArray()[i] = user;
                }
            }
        }
        if (Lang.isNotEmpty(getUserColl())) {
            if (role.getUserColl() == null) {
                role.setUserColl(new ArrayList<>());
            } else {
                role.getUserColl().clear();
            }
            for (UserDto userDto : getUserArray()) {
                if (Lang.isNotEmpty(userDto)) {
                    User user = new User();
                    user.setId(userDto.getId());
                    user.setName(userDto.getName());
                    role.getUserColl().add(user);
                }
            }
        }
        if (Lang.isNotEmpty(getUserList())) {
            if (role.getUserList() == null) {
                role.setUserList(new ArrayList<>());
            } else {
                role.getUserList().clear();
            }
            for (UserDto userDto : getUserArray()) {
                if (Lang.isNotEmpty(userDto)) {
                    User user = new User();
                    user.setId(userDto.getId());
                    user.setName(userDto.getName());
                    role.getUserList().add(user);
                }
            }
        }
        if (Lang.isNotEmpty(getUserSet())) {
            if (role.getUserSet() == null) {
                role.setUserSet(new HashSet<>());
            } else {
                role.getUserSet().clear();
            }
            for (UserDto userDto : getUserArray()) {
                if (Lang.isNotEmpty(userDto)) {
                    User user = new User();
                    user.setId(userDto.getId());
                    user.setName(userDto.getName());
                    role.getUserSet().add(user);
                }
            }
        }
        return role;
    }
}
