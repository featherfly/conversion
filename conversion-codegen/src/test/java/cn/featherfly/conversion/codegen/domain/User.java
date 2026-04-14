
package cn.featherfly.conversion.codegen.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import cn.featherfly.common.lang.Dates;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.Num;
import cn.featherfly.common.lang.Str;

/**
 * User
 *
 * @author zhongj
 */
public class User {

    private Long id;

    private String username;

    private String name;

    private Date lastChpwTime;

    private String password;

    private String mobileNo;

    private Date registerTime;

    private User recommender;

    private Gender gender;

    private String token;

    private Date tokenUpdateTime;

    private String alipayUserId;

    private String wechatUnionId;

    private String wechatToken;

    private String dingTalkUnionId;

    private String eweChatUserId;

    private Integer smokingAge;

    private Date wechatTokenUpdateTime;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;

    private Integer constellation;

    private Integer salary;

    private String alwaysAt;

    private String head;

    private String email;

    private Boolean emailBinding;

    private Integer level;

    private Integer score;

    private Integer donation;

    private Integer goldCoin;

    private Long interests;

    public String getEweChatUserId() {
        return eweChatUserId;
    }

    public void setEweChatUserId(String eweChatUserId) {
        this.eweChatUserId = eweChatUserId;
    }

    //	@JsonIgnore
    private Boolean available;

    //	@JsonIgnore
    private Date createTime;

    //	@JsonIgnore
    private Date lastModifyTime;

    private String mobileProvice;

    private Long realAuthenticationId;

    private String requestIp;

    private Double latitude;

    private Double longitude;

    private String ipAddress;

    private String coordinatesAddress;

    private String mobileAddress;

    private Date firstLoginTime;

    private Date endTime;

    /**
     * Gets end time.
     *
     * @return the end time
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * Sets end time.
     *
     * @param endTime the end time
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param id id
     */
    public User(Long id) {
        this.id = id;
    }

    /**
     * 为空值设置默认值
     */
    public void setDefaultValueForNull() {
        //		super.setDefaultValueForNull();

        level = Lang.ifNull(level, 1);
        score = Lang.ifNull(score, 0);
        donation = Lang.ifNull(donation, 0);
        goldCoin = Lang.ifNull(goldCoin, 0);

        available = Lang.ifNull(available, true);

        username = Str.pickNotBlank(username, null);
        mobileNo = Str.pickNotBlank(mobileNo, null);
        email = Str.pickNotBlank(email, null);
    }

    /**
     * 返回id
     *
     * @return id id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回username
     *
     * @return username username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置username
     *
     * @param username username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 返回mobileNo
     *
     * @return mobileNo mobile no
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * 设置mobileNo
     *
     * @param mobileNo mobileNo
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    /**
     * 返回password
     *
     * @return password password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置password
     *
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets gender.
     *
     * @return the gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Sets gender.
     *
     * @param gender the gender
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * 返回recommender
     *
     * @return recommender recommender
     */
    public User getRecommender() {
        return recommender;
    }

    /**
     * 设置recommender
     *
     * @param recommender recommender
     */
    public void setRecommender(User recommender) {
        this.recommender = recommender;
    }

    /**
     * 返回registerTime
     *
     * @return registerTime register time
     */
    public Date getRegisterTime() {
        return registerTime;
    }

    /**
     * 设置registerTime
     *
     * @param registerTime registerTime
     */
    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    /**
     * 返回token
     *
     * @return token token
     */
    public String getToken() {
        return token;
    }

    /**
     * 设置token
     *
     * @param token token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 返回head
     *
     * @return head head
     */
    public String getHead() {
        return head;
    }

    /**
     * 设置head
     *
     * @param head head
     */
    public void setHead(String head) {
        this.head = head;
    }

    /**
     * 返回age
     *
     * @return age age
     */
    public Integer getAge() {
        Integer age = null;
        if (birthday != null) {
            age = Dates.getAge(birthday);
        }
        return age;
    }

    /**
     * 返回constellation
     *
     * @return constellation constellation
     */
    public Integer getConstellation() {
        return constellation;
    }

    /**
     * 设置constellation
     *
     * @param constellation constellation
     */
    public void setConstellation(Integer constellation) {
        this.constellation = constellation;
    }

    /**
     * 返回salary
     *
     * @return salary salary
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
     * 返回alwaysAt
     *
     * @return alwaysAt always at
     */
    public String getAlwaysAt() {
        return alwaysAt;
    }

    /**
     * 设置alwaysAt
     *
     * @param alwaysAt alwaysAt
     */
    public void setAlwaysAt(String alwaysAt) {
        this.alwaysAt = alwaysAt;
    }

    /**
     * 返回interests
     *
     * @return interests interests
     */
    public Long getInterests() {
        return interests;
    }

    /**
     * 设置interests
     *
     * @param interests interests
     */
    public void setInterests(Long interests) {
        this.interests = interests;
    }

    /**
     * 返回email
     *
     * @return email email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置email
     *
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 返回birthday
     *
     * @return birthday birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置birthday
     *
     * @param birthday birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 设置emailBinding
     *
     * @param emailBinding emailBinding
     */
    public void setEmailBinding(Boolean emailBinding) {
        this.emailBinding = emailBinding;
    }

    /**
     * 返回emailBinding
     *
     * @return emailBinding email binding
     */
    public Boolean getEmailBinding() {
        return emailBinding;
    }

    /**
     * Gets score.
     *
     * @return the score
     */
    public Integer getScore() {
        return score;
    }

    /**
     * Sets score.
     *
     * @param score the score
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * Gets available.
     *
     * @return the available
     */
    public Boolean getAvailable() {
        return available;
    }

    /**
     * Sets available.
     *
     * @param available the available
     */
    public void setAvailable(Boolean available) {
        this.available = available;
    }

    /**
     * Gets last chpw time.
     *
     * @return the last chpw time
     */
    public Date getLastChpwTime() {
        return lastChpwTime;
    }

    /**
     * Sets last chpw time.
     *
     * @param lastChpwTime the last chpw time
     */
    public void setLastChpwTime(Date lastChpwTime) {
        this.lastChpwTime = lastChpwTime;
    }

    /**
     * Gets level.
     *
     * @return the level
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * Sets level.
     *
     * @param level the level
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 返回createTime
     *
     * @return createTime create time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置createTime
     *
     * @param createTime createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * Gets last modify time.
     *
     * @return the last modify time
     */
    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    /**
     * Sets last modify time.
     *
     * @param lastModifyTime the last modify time
     */
    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    /**
     * Gets donation.
     *
     * @return the donation
     */
    public Integer getDonation() {
        return donation;
    }

    /**
     * Sets donation.
     *
     * @param donation the donation
     */
    public void setDonation(Integer donation) {
        this.donation = donation;
    }

    /**
     * Gets gold coin.
     *
     * @return the gold coin
     */
    public Integer getGoldCoin() {
        return goldCoin;
    }

    /**
     * Sets gold coin.
     *
     * @param goldCoin the gold coin
     */
    public void setGoldCoin(Integer goldCoin) {
        this.goldCoin = goldCoin;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets mobile provice.
     *
     * @return the mobile provice
     */
    public String getMobileProvice() {
        return mobileProvice;
    }

    /**
     * Sets mobile provice.
     *
     * @param mobileProvice the mobile provice
     */
    public void setMobileProvice(String mobileProvice) {
        this.mobileProvice = mobileProvice;
    }

    /**
     * Gets recommende code.
     *
     * @return the recommende code
     */
    @JsonIgnore
    public String getRecommendeCode() {
        if (Lang.isNotEmpty(mobileNo)) {
            return mobileNo;
        } else if (id != null) {
            return "#" + Num.fillingAtStart(id, 6, '0');
        }
        return null;
    }

    /**
     * Gets real authentication id.
     *
     * @return the real authentication id
     */
    public Long getRealAuthenticationId() {
        return realAuthenticationId;
    }

    /**
     * Sets real authentication id.
     *
     * @param realAuthenticationId the real authentication id
     */
    public void setRealAuthenticationId(Long realAuthenticationId) {
        this.realAuthenticationId = realAuthenticationId;
    }

    /**
     * Gets request ip.
     *
     * @return the request ip
     */
    public String getRequestIp() {
        return requestIp;
    }

    /**
     * Sets request ip.
     *
     * @param requestIp the request ip
     */
    public void setRequestIp(String requestIp) {
        this.requestIp = requestIp;
    }

    /**
     * Gets latitude.
     *
     * @return the latitude
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * Sets latitude.
     *
     * @param latitude the latitude
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     * Gets longitude.
     *
     * @return the longitude
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * Sets longitude.
     *
     * @param longitude the longitude
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     * Gets ip address.
     *
     * @return the ip address
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * Sets ip address.
     *
     * @param ipAddress the ip address
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * Gets coordinates address.
     *
     * @return the coordinates address
     */
    public String getCoordinatesAddress() {
        return coordinatesAddress;
    }

    /**
     * Sets coordinates address.
     *
     * @param coordinatesAddress the coordinates address
     */
    public void setCoordinatesAddress(String coordinatesAddress) {
        this.coordinatesAddress = coordinatesAddress;
    }

    /**
     * Gets mobile address.
     *
     * @return the mobile address
     */
    public String getMobileAddress() {
        return mobileAddress;
    }

    /**
     * Sets mobile address.
     *
     * @param mobileAddress the mobile address
     */
    public void setMobileAddress(String mobileAddress) {
        this.mobileAddress = mobileAddress;
    }

    /**
     * Gets first login time.
     *
     * @return the first login time
     */
    public Date getFirstLoginTime() {
        return firstLoginTime;
    }

    /**
     * Sets first login time.
     *
     * @param firstLoginTime the first login time
     */
    public void setFirstLoginTime(Date firstLoginTime) {
        this.firstLoginTime = firstLoginTime;
    }

    /**
     * Gets token update time.
     *
     * @return the token update time
     */
    public Date getTokenUpdateTime() {
        return tokenUpdateTime;
    }

    /**
     * Sets token update time.
     *
     * @param tokenUpdateTime the token update time
     */
    public void setTokenUpdateTime(Date tokenUpdateTime) {
        this.tokenUpdateTime = tokenUpdateTime;
    }

    /**
     * Getter for property 'wechatUnionId'.
     *
     * @return Value for property 'wechatUnionId'.
     */
    public String getWechatUnionId() {
        return wechatUnionId;
    }

    public String getDingTalkUnionId() {
        return dingTalkUnionId;
    }

    public void setDingTalkUnionId(String dingTalkUnionId) {
        this.dingTalkUnionId = dingTalkUnionId;
    }

    /**
     * Setter for property 'wechatUnionId'.
     *
     * @param wechatUnionId Value to set for property 'wechatUnionId'.
     */
    public void setWechatUnionId(String wechatUnionId) {
        this.wechatUnionId = wechatUnionId;
    }

    /**
     * Getter for property 'alipayUserId'.
     *
     * @return Value for property 'alipayUserId'.
     */
    public String getAlipayUserId() {
        return alipayUserId;
    }

    /**
     * Setter for property 'alipayUserId'.
     *
     * @param alipayUserId Value to set for property 'alipayUserId'.
     */
    public void setAlipayUserId(String alipayUserId) {
        this.alipayUserId = alipayUserId;
    }

    /**
     * Gets wechat token.
     *
     * @return the wechat token
     */
    public String getWechatToken() {
        return wechatToken;
    }

    /**
     * Sets wechat token.
     *
     * @param wechatToken the wechat token
     */
    public void setWechatToken(String wechatToken) {
        this.wechatToken = wechatToken;
    }

    /**
     * Getter for property 'wechatTokenUpdateTime'.
     *
     * @return Value for property 'wechatTokenUpdateTime'.
     */
    public Date getWechatTokenUpdateTime() {
        return wechatTokenUpdateTime;
    }

    /**
     * Setter for property 'wechatTokenUpdateTime'.
     *
     * @param wechatTokenUpdateTime Value to set for property 'wechatTokenUpdateTime'.
     */
    public void setWechatTokenUpdateTime(Date wechatTokenUpdateTime) {
        this.wechatTokenUpdateTime = wechatTokenUpdateTime;
    }

    /**
     * Getter for property 'smokingAge'.
     *
     * @return Value for property 'smokingAge'.
     */
    public Integer getSmokingAge() {
        return smokingAge;
    }

    /**
     * Setter for property 'smokingAge'.
     *
     * @param smokingAge Value to set for property 'smokingAge'.
     */
    public void setSmokingAge(Integer smokingAge) {
        this.smokingAge = smokingAge;
    }

    public enum Gender {
        /**
         * 男
         */
        MALE,
        /**
         * 女
         */
        FEMALE
    }
}
