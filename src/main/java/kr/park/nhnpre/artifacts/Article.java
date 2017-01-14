package kr.park.nhnpre.artifacts;

import java.util.Date;

/**
 * Created by Administrator on 2016-12-19.
 */
 
public class Article {
	String id;
    String email;
    String password;
    String text;
    String add_time;
    String modify_time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
    	this.add_time = add_time.substring(5, 9);
    	this.add_time += add_time.substring(10, 16);
    }

    public String getModify_time() {
        return modify_time;
    }

    public void setModify_time(String modify_time) {
    	this.modify_time = modify_time.substring(5, 9);
    	this.modify_time += modify_time.substring(10, 16);
    }
}
