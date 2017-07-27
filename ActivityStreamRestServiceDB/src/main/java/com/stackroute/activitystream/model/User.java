package com.stackroute.activitystream.model;

public class User {
	private int uid;
	private String uname;
	private String upass;
	private String unum;
	private String emailid;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}

	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUnum() {
		return unum;
	}
	public void setUnum(String unum) {
		this.unum = unum;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;

	        User user = (User) o;

	        if (uid != user.uid) return false;
	        if (uname != null ? !uname.equals(user.uname) : user.uname != null) return false;

	        return true;
	    }

	    @Override
	    public int hashCode() {
	        int result = uid;
	        result = 31 * result + (uname != null ? uname.hashCode() : 0);
	        return result;
	    }

	    @Override
	    public String toString() {
	        return "User{" +
	                "id=" + uid +
	                ", username='" + uname + '\'' +
	                '}';
	    }
	
	
	
	
	
	
	
	
	
	
	
	
}
