package Entity;

public class Man {
	private String id,pwd,name;
	
	public Man() {
		super();
	}
	
	public Man(String id,String pwd,String name) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
	}
	
	public void setId(String id) {
        this.id = id;
    }
	
    public String getId() {
        return id;
    }
    
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    public String getPwd() {
        return pwd;
    }
    
    public void setName(String name) {
        this.name=name;
    }
    
    public String getName() {
        return name;
    }
}