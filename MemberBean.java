package la.bean;

import java.io.Serializable;
import java.sql.Date;

public class MemberBean implements Serializable{
	private static final long serialVersionUID = 1L;//クラス構造が変わってないことを保証するため//
	 private int code;
	 private String name;
	 private String postal;
	 private String address;
	 private String tel;
	 private String email;
	 private Date birthday;
	 private Date joinDate;
	 private Date quitDate;
	public MemberBean(int code, String name, String postal, String address, String tel, String email, Date birthday,
			Date joinDate, Date quitDate) {
		super();
		this.code = code;
		this.name = name;
		this.postal = postal;
		this.address = address;
		this.tel = tel;
		this.email = email;
		this.birthday = birthday;
		this.joinDate = joinDate;
		this.quitDate = quitDate;
	}
	public MemberBean() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPostal() {
		return postal;
	}
	public void setPostal(String postal) {
		this.postal = postal;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public Date getQuitDate() {
		return quitDate;
	}
	public void setQuitDate(Date quitDate) {
		this.quitDate = quitDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "MemberBean [code=" + code + ", name=" + name + ", postal=" + postal + ", address=" + address + ", tel="
				+ tel + ", email=" + email + ", birthday=" + birthday + ", joinDate=" + joinDate + ", quitDate=" + quitDate
				+ "]";
	}





}
