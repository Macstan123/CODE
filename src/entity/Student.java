package entity;

public class Student {
    private int user_id;
    private String user_name;
    private String user_dept;
    private int is_break;
    private String user_pwd;

    public Student() {

    }

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_dept() {
		return user_dept;
	}

	public void setUser_dept(String user_dept) {
		this.user_dept = user_dept;
	}

	public int getIs_break() {
		return is_break;
	}

	public void setIs_break(int is_break) {
		this.is_break = is_break;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public Student(int user_id, String user_name, String user_dept, int is_break, String user_pwd) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_dept = user_dept;
		this.is_break = is_break;
		this.user_pwd = user_pwd;
	}

    

}
