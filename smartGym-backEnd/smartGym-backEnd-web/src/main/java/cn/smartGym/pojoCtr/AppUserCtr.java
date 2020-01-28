package cn.smartGym.pojoCtr;

import java.io.Serializable;

import java.util.Date;
import java.util.ResourceBundle;
import org.apache.commons.lang3.StringUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import common.enums.ErrorCode;
import common.utils.AesCbcUtil;
import common.utils.HttpRequest;
import common.utils.SGResult;
import net.sf.json.JSONObject;

public class AppUserCtr implements Serializable{
	

	private static final long serialVersionUID = 3235667604918098848L;

	private Long user_id;

    private String user_name;

    private String user_wxid;
    
    private String encrypted_data;

	private String iv;

	private String code;

    private String student_no;

    private String gender;

    private String campus;

    private String college;
    
    private String association;

    private String phone;

    private Integer status;

    private String type;

    private Integer user_type;

    private String email;

    private Integer admin_level;

    private Integer judge_level;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date created;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updated;

    private Integer user_admin_type;
    
    private Integer user_admin_level;
    
    
	


	public String getAssociation() {
		return association;
	}

	public void setAssociation(String association) {
		this.association = association;
	}

	public String getIv() {
		return iv;
	}

	public void setIv(String iv) {
		this.iv = iv;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}
    
    public AppUserCtr() {
    	super();
    }
    
    public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_wxid() {
		return user_wxid;
	}

	public void setUser_wxid(String user_wxid) {
		this.user_wxid = user_wxid;
	}

	public String getEncrypted_data() {
		return encrypted_data;
	}

	public void setEncrypted_data(String encrypted_data) {
		this.encrypted_data = encrypted_data;
	}

	public String getStudent_no() {
		return student_no;
	}

	public void setStudent_no(String student_no) {
		this.student_no = student_no;
	}

	public Integer getUser_type() {
		return user_type;
	}

	public void setUser_type(Integer user_type) {
		this.user_type = user_type;
	}

	public Integer getAdmin_level() {
		return admin_level;
	}

	public void setAdmin_level(Integer admin_level) {
		this.admin_level = admin_level;
	}

	public Integer getJudge_level() {
		return judge_level;
	}

	public void setJudge_level(Integer judge_level) {
		this.judge_level = judge_level;
	}

	public Integer getUser_admin_type() {
		return user_admin_type;
	}

	public void setUser_admin_type(Integer user_admin_type) {
		this.user_admin_type = user_admin_type;
	}

	public Integer getUser_admin_level() {
		return user_admin_level;
	}

	public void setUser_admin_level(Integer user_admin_level) {
		this.user_admin_level = user_admin_level;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 解密用户敏感数据
	 *
	 * @param encryptedData 明文,加密数据
	 * @param iv            加密算法的初始向量
	 * @param code          用户允许登录后，回调内容会带上 code（有效期五分钟），开发者需要将 code
	 *                      发送到开发者服务器后台，使用code 换取 session_key api，将 code 换成 openid 和
	 *                      session_key
	 * @return
	 * @throws Exception
	 */
	public SGResult decodeWxId() throws Exception {
		String encryptedData = this.getEncrypted_data();
		String code = this.getCode();
		String iv = this.getIv();
		// 登录凭证不能为空
		if (code == null || code.length() == 0) {
			return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "code不能为空！");
		}

		// 从配置文件中读取小程序唯一标识
		ResourceBundle rs = ResourceBundle.getBundle("conf/resource");
		String wxspAppid = rs.getString("wxspAppid");
		String wxspSecret = rs.getString("wxspSecret");
		String grant_type = rs.getString("grant_type");

		/*
		 * 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid
		 * 
		 */
		// 请求参数
		String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type="
				+ grant_type;
		// 发送请求
		String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);

		// 解析相应内容（转换成json对象）
		JSONObject json = JSONObject.fromObject(sr);
		
		System.out.println("===================================================++++=====");
		System.out.println(json.toString());
		System.out.println("===================================================++++=====");
		
		if (json == null || !json.containsKey("session_key"))
			return SGResult.build(ErrorCode.BUSINESS_EXCEPTION.getErrorCode(), "微信账号存在异常！");

		// 获取会话密钥（session_key）
		String session_key = json.get("session_key").toString();

		/*
		 * 2、对encryptedData加密数据进行AES解密
		 * 
		 */
		String result = AesCbcUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
		if (StringUtils.isNotBlank(result)) {
			// 解密成功
			JSONObject userInfoJSON = JSONObject.fromObject(result);

			/*
			 * Map userInfo = new HashMap(); userInfo.put("openId",
			 * userInfoJSON.get("openId")); userInfo.put("nickName",
			 * userInfoJSON.get("nickName")); userInfo.put("gender",
			 * userInfoJSON.get("gender")); userInfo.put("city", userInfoJSON.get("city"));
			 * userInfo.put("province", userInfoJSON.get("province"));
			 * userInfo.put("country", userInfoJSON.get("country"));
			 * userInfo.put("avatarUrl", userInfoJSON.get("avatarUrl"));
			 * userInfo.put("unionId", userInfoJSON.get("unionId"));
			 */

			if (userInfoJSON.containsKey("unionId"))
				return SGResult.ok(userInfoJSON.get("unionId"));
			else
				return SGResult.build(ErrorCode.BUSINESS_EXCEPTION.getErrorCode(), "微信账号存在异常！！！");
		} else
			return SGResult.build(ErrorCode.BUSINESS_EXCEPTION.getErrorCode(), "微信账号存在异常！！");
	}

}
