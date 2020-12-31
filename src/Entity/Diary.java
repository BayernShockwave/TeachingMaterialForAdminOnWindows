package Entity;

import java.util.Date;

public class Diary {
	private String id,ip;
	private Date time;
	
	public Diary() {
        super();
    }

    public Diary(String id,String ip,Date time) {
        super();
        this.id = id;
        this.ip = ip;
        this.time = time;
    }
	
	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
