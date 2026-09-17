package cn.featherfly.conversion.codegen.vo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import cn.featherfly.common.lang.Lang;
import cn.featherfly.conversion.codegen.domain.User;

public class UserDto {
    @JsonProperty("id")
    private Long id = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("mobileNo")
    private String mobileNo = null;

    @JsonProperty("gender")
    private Gender gender = null;

    @JsonProperty("available")
    private Boolean available = null;

    @JsonProperty("email")
    private String email = null;

    @JsonProperty("registerTime")
    private String registerTime = null;

    @JsonProperty("alipayUserId")
    private String alipayUserId = null;

    @JsonProperty("wechatUnionId")
    private String wechatUnionId = null;

    @JsonProperty("endTime")
    private LocalDateTime endTime = null;

    @JsonProperty("needModifyPass")
    private Boolean needModifyPass = null;

    @JsonProperty("isBindingDingTalk")
    private Boolean isBindingDingTalk = null;

    @JsonProperty("isBindingEweChat")
    private Boolean isBindingEweChat = null;

    private Integer int2Integer;

    private Long long2Long;

    private Byte byte2Byte;

    private Short short2Short;

    private Double double2Double;

    private Float float2Float;

    private BigDecimal double2BigDecimal;

    private BigDecimal double2BigDecimal2;

    private BigDecimal long2BigDecimal;

    private BigDecimal long2BigDecimal2;

    private BigInteger long2BigInteger;

    private BigInteger long2BigInteger2;

    public UserDto id(Long id) {

        this.id = id;
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public UserDto name(String name) {

        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public UserDto mobileNo(String mobileNo) {

        this.mobileNo = mobileNo;
        return this;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {

        this.mobileNo = mobileNo;
    }

    public UserDto gender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public UserDto available(Boolean available) {

        this.available = available;
        return this;
    }

    public Boolean isAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {

        this.available = available;
    }

    public UserDto email(String email) {

        this.email = email;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public UserDto registerTime(String registerTime) {

        this.registerTime = registerTime;
        return this;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {

        this.registerTime = registerTime;
    }

    public UserDto alipayUserId(String alipayUserId) {

        this.alipayUserId = alipayUserId;
        return this;
    }

    public String getAlipayUserId() {
        return alipayUserId;
    }

    public void setAlipayUserId(String alipayUserId) {

        this.alipayUserId = alipayUserId;
    }

    public UserDto wechatUnionId(String wechatUnionId) {

        this.wechatUnionId = wechatUnionId;
        return this;
    }

    public String getWechatUnionId() {
        return wechatUnionId;
    }

    public void setWechatUnionId(String wechatUnionId) {

        this.wechatUnionId = wechatUnionId;
    }

    public UserDto endTime(LocalDateTime endTime) {

        this.endTime = endTime;
        return this;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {

        this.endTime = endTime;
    }

    public UserDto needModifyPass(Boolean needModifyPass) {

        this.needModifyPass = needModifyPass;
        return this;
    }

    public Boolean isNeedModifyPass() {
        return needModifyPass;
    }

    public void setNeedModifyPass(Boolean needModifyPass) {

        this.needModifyPass = needModifyPass;
    }

    public UserDto isBindingDingTalk(Boolean isBindingDingTalk) {

        this.isBindingDingTalk = isBindingDingTalk;
        return this;
    }

    public Boolean isIsBindingDingTalk() {
        return isBindingDingTalk;
    }

    public void setIsBindingDingTalk(Boolean isBindingDingTalk) {

        this.isBindingDingTalk = isBindingDingTalk;
    }

    public UserDto isBindingEweChat(Boolean isBindingEweChat) {

        this.isBindingEweChat = isBindingEweChat;
        return this;
    }

    public Boolean isIsBindingEweChat() {
        return isBindingEweChat;
    }

    public void setIsBindingEweChat(Boolean isBindingEweChat) {

        this.isBindingEweChat = isBindingEweChat;
    }

    /**
     * get int2Integer value
     *
     * @return int2Integer
     */
    public Integer getInt2Integer() {
        return int2Integer;
    }

    /**
     * set int2Integer value
     *
     * @param int2Integer int2Integer
     */
    public void setInt2Integer(Integer int2Integer) {
        this.int2Integer = int2Integer;
    }

    /**
     * get long2Long value
     *
     * @return long2Long
     */
    public Long getLong2Long() {
        return long2Long;
    }

    /**
     * set long2Long value
     *
     * @param long2Long long2Long
     */
    public void setLong2Long(Long long2Long) {
        this.long2Long = long2Long;
    }

    /**
     * get byte2Byte value
     *
     * @return byte2Byte
     */
    public Byte getByte2Byte() {
        return byte2Byte;
    }

    /**
     * set byte2Byte value
     *
     * @param byte2Byte byte2Byte
     */
    public void setByte2Byte(Byte byte2Byte) {
        this.byte2Byte = byte2Byte;
    }

    /**
     * get short2Short value
     *
     * @return short2Short
     */
    public Short getShort2Short() {
        return short2Short;
    }

    /**
     * set short2Short value
     *
     * @param short2Short short2Short
     */
    public void setShort2Short(Short short2Short) {
        this.short2Short = short2Short;
    }

    /**
     * get double2Double value
     *
     * @return double2Double
     */
    public Double getDouble2Double() {
        return double2Double;
    }

    /**
     * set double2Double value
     *
     * @param double2Double double2Double
     */
    public void setDouble2Double(Double double2Double) {
        this.double2Double = double2Double;
    }

    /**
     * get float2Float value
     *
     * @return float2Float
     */
    public Float getFloat2Float() {
        return float2Float;
    }

    /**
     * set float2Float value
     *
     * @param float2Float float2Float
     */
    public void setFloat2Float(Float float2Float) {
        this.float2Float = float2Float;
    }

    public BigDecimal getDouble2BigDecimal() {
        return double2BigDecimal;
    }

    public void setDouble2BigDecimal(BigDecimal double2BigDecimal) {
        this.double2BigDecimal = double2BigDecimal;
    }

    public BigDecimal getDouble2BigDecimal2() {
        return double2BigDecimal2;
    }

    public void setDouble2BigDecimal2(BigDecimal double2BigDecimal2) {
        this.double2BigDecimal2 = double2BigDecimal2;
    }

    public BigDecimal getLong2BigDecimal() {
        return long2BigDecimal;
    }

    public void setLong2BigDecimal(BigDecimal long2BigDecimal) {
        this.long2BigDecimal = long2BigDecimal;
    }

    public BigDecimal getLong2BigDecimal2() {
        return long2BigDecimal2;
    }

    public void setLong2BigDecimal2(BigDecimal long2BigDecimal2) {
        this.long2BigDecimal2 = long2BigDecimal2;
    }

    public BigInteger getLong2BigInteger() {
        return long2BigInteger;
    }

    public void setLong2BigInteger(BigInteger long2BigInteger) {
        this.long2BigInteger = long2BigInteger;
    }

    public BigInteger getLong2BigInteger2() {
        return long2BigInteger2;
    }

    public void setLong2BigInteger2(BigInteger long2BigInteger2) {
        this.long2BigInteger2 = long2BigInteger2;
    }

    public Boolean getAvailable() {
        return available;
    }

    public Boolean getIsBindingDingTalk() {
        return isBindingDingTalk;
    }

    public Boolean getIsBindingEweChat() {
        return isBindingEweChat;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserDto userDto = (UserDto) o;
        return Objects.equals(id, userDto.id) && Objects.equals(name, userDto.name)
            && Objects.equals(mobileNo, userDto.mobileNo) && Objects.equals(gender, userDto.gender)
            && Objects.equals(available, userDto.available) && Objects.equals(email, userDto.email)
            && Objects.equals(registerTime, userDto.registerTime) && Objects.equals(alipayUserId, userDto.alipayUserId)
            && Objects.equals(wechatUnionId, userDto.wechatUnionId) && Objects.equals(endTime, userDto.endTime)
            && Objects.equals(needModifyPass, userDto.needModifyPass)
            && Objects.equals(isBindingDingTalk, userDto.isBindingDingTalk)
            && Objects.equals(isBindingEweChat, userDto.isBindingEweChat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, mobileNo, gender, available, email, registerTime, alipayUserId, wechatUnionId,
            endTime, needModifyPass, isBindingDingTalk, isBindingEweChat);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UserDto {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    mobileNo: ").append(toIndentedString(mobileNo)).append("\n");
        sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
        sb.append("    available: ").append(toIndentedString(available)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    registerTime: ").append(toIndentedString(registerTime)).append("\n");
        sb.append("    alipayUserId: ").append(toIndentedString(alipayUserId)).append("\n");
        sb.append("    wechatUnionId: ").append(toIndentedString(wechatUnionId)).append("\n");
        sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
        sb.append("    needModifyPass: ").append(toIndentedString(needModifyPass)).append("\n");
        sb.append("    isBindingDingTalk: ").append(toIndentedString(isBindingDingTalk)).append("\n");
        sb.append("    isBindingEweChat: ").append(toIndentedString(isBindingEweChat)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

    public UserDto(User user) {
        setId(user.getId());
        setName(user.getName());
        setGender(Lang.toEnum(Gender.class, user.getGender()));
    }

    public UserDto fromUser(User user) {
        if (user == null) {
            return this;
        }
        setId(user.getId());
        setName(user.getName());
        setGender(Lang.toEnum(Gender.class, user.getGender()));
        return this;
    }

    public User toUser() {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setGender(Lang.toEnum(cn.featherfly.conversion.codegen.domain.User.Gender.class, gender));
        return user;
    }

    public static UserDto from(User user) {
        return new UserDto(user);
    }
}