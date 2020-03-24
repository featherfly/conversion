
package cn.featherfly.conversion.vo;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

import cn.featherfly.conversion.annotation.Assign;
import cn.featherfly.conversion.annotation.Format;
import cn.featherfly.conversion.string.basic.DateConvertor;

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

    @Format(format = "##,##", formats = { "##,##", "#" })
    private int age;

    @Format(format = "###,###", formats = { "###,###", "#" })
    private Integer salary;

    @Format(format = "yyyy-MM-dd", formats = { "yyyy-MM-dd", "yyyy年MM月dd日" })
    private Date[] dates;

    private java.sql.Date sqlDate;

    private Time time;

    private Timestamp timestamp;

    @Format(format = "yyyy年MM月dd日", formats = { "yyyy/MM/dd", "yyyy年MM月dd日" })
    private java.sql.Date sqlDate2;

    @Format(format = "HH时mm分ss秒", formats = { "HH:mm:ss", "HH时mm分ss秒" })
    private Time time2;

    @Format(format = "yyyy年MM月dd日 HH时mm分ss秒", formats = { "yyyy/MM/dd HH:mm:ss", "yyyy年MM月dd日 HH时mm分ss秒" })
    private Timestamp timestamp2;

    private Sex sex;

    private Optional<String> username;

    private Optional<Date> date1;

    private Optional<?> obj;
    private Optional obj2;

    /**
     * 返回sex
     *
     * @return sex
     */
    public Sex getSex() {
        return sex;
    }

    /**
     * 设置sex
     *
     * @param sex sex
     */
    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Format(format = "yyyy年MM月dd日", formats = "yyyy年MM月dd日")
    private Date date;

    /**
     * 返回date
     *
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * 设置date
     *
     * @param date date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 返回name
     *
     * @return name
     */
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
     * 返回age
     *
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置age
     *
     * @param age age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 返回salary
     *
     * @return salary
     */
    public Integer getSalary() {
        return salary;
    }

    /**
     * 设置salary
     *
     * @param salary salary
     */
    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    /**
     * 返回dates
     *
     * @return dates
     */
    public Date[] getDates() {
        return dates;
    }

    /**
     * 设置dates
     *
     * @param dates dates
     */
    public void setDates(Date[] dates) {
        this.dates = dates;
    }

    /**
     * 返回sqlDate
     *
     * @return sqlDate
     */
    public java.sql.Date getSqlDate() {
        return sqlDate;
    }

    /**
     * 设置sqlDate
     *
     * @param sqlDate sqlDate
     */
    public void setSqlDate(java.sql.Date sqlDate) {
        this.sqlDate = sqlDate;
    }

    /**
     * 返回time
     *
     * @return time
     */
    public Time getTime() {
        return time;
    }

    /**
     * 设置time
     *
     * @param time time
     */
    public void setTime(Time time) {
        this.time = time;
    }

    /**
     * 返回timestamp
     *
     * @return timestamp
     */
    public Timestamp getTimestamp() {
        return timestamp;
    }

    /**
     * 设置timestamp
     *
     * @param timestamp timestamp
     */
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * 返回sqlDate2
     *
     * @return sqlDate2
     */
    public java.sql.Date getSqlDate2() {
        return sqlDate2;
    }

    /**
     * 设置sqlDate2
     *
     * @param sqlDate2 sqlDate2
     */
    public void setSqlDate2(java.sql.Date sqlDate2) {
        this.sqlDate2 = sqlDate2;
    }

    /**
     * 返回time2
     *
     * @return time2
     */
    public Time getTime2() {
        return time2;
    }

    /**
     * 设置time2
     *
     * @param time2 time2
     */
    public void setTime2(Time time2) {
        this.time2 = time2;
    }

    /**
     * 返回timestamp2
     *
     * @return timestamp2
     */
    public Timestamp getTimestamp2() {
        return timestamp2;
    }

    /**
     * 设置timestamp2
     *
     * @param timestamp2 timestamp2
     */
    public void setTimestamp2(Timestamp timestamp2) {
        this.timestamp2 = timestamp2;
    }

    /**
     * 返回username
     *
     * @return username
     */
    public Optional<String> getUsername() {
        return username;
    }

    /**
     * 设置username
     *
     * @param username username
     */
    public void setUsername(Optional<String> username) {
        this.username = username;
    }

    /**
     * 返回obj
     *
     * @return obj
     */
    public Optional<?> getObj() {
        return obj;
    }

    /**
     * 设置obj
     *
     * @param obj obj
     */
    public void setObj(Optional<?> obj) {
        this.obj = obj;
    }

    /**
     * 返回obj2
     *
     * @return obj2
     */
    public Optional getObj2() {
        return obj2;
    }

    /**
     * 设置obj2
     *
     * @param obj2 obj2
     */
    public void setObj2(Optional obj2) {
        this.obj2 = obj2;
    }

    /**
     * 返回date1
     * 
     * @return date1
     */
    public Optional<Date> getDate1() {
        return date1;
    }

    /**
     * 设置date1
     * 
     * @param date1 date1
     */
    public void setDate1(Optional<Date> date1) {
        this.date1 = date1;
    }

}
