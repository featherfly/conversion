
package cn.featherfly.conversion;

import java.util.Date;

import cn.featherfly.conversion.annotation.Assign;
import cn.featherfly.conversion.annotation.Format;
import cn.featherfly.conversion.basic.DateConvertor;

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

    @Assign(conversion = DateConvertor.class)
    private String name;

    @Format(format = "##,##", formats = {"##,##", "#"})
    private int age;
    
    @Format(format = "###,###", formats = {"###,###", "#"})
    private Integer salary;
    
    @Format(format = "yyyy-MM-dd", formats = {"yyyy-MM-dd", "yyyy年MM月dd日"})
    private Date[] dates;

    private Sex sex;

    /**
     * 返回sex
     * @return sex
     */
    public Sex getSex() {
        return sex;
    }

    /**
     * 设置sex
     * @param sex sex
     */
    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Format(format = "yyyy年MM月dd日", formats = "yyyy年MM月dd日")
    private Date date;

    /**
     * 返回date
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * 设置date
     * @param date date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 返回name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置name
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 返回age
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置age
     * @param age age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 返回salary
     * @return salary
     */
    public Integer getSalary() {
        return salary;
    }

    /**
     * 设置salary
     * @param salary salary
     */
    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    /**
     * 返回dates
     * @return dates
     */
    public Date[] getDates() {
        return dates;
    }

    /**
     * 设置dates
     * @param dates dates
     */
    public void setDates(Date[] dates) {
        this.dates = dates;
    }    
}
