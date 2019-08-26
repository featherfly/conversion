
package org.yufei;

/**
 * <p>
 * 类的说明放这里
 * </p>
 * <p>
 * copyright featherfly 2010-2020, all rights reserved.
 * </p>
 *
 * @author 钟冀
 */
public class User {

    public User() {
    }

    private String name = "default_user2_name";

    private Integer age = 15;

    public String getName() {
        return name;
    }

    /**
     * 设置name
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 设置age
     *
     * @param age age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 返回age
     *
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "User [name=" + name + ", age=" + age + "]";
    }

}
