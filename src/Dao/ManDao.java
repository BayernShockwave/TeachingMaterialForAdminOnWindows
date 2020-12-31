package Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import dButil.SqlHelper;
import Entity.*;

public class ManDao {
	public static List<Man> allMans() {
		List<Man> manList = new ArrayList<Man>();
		String sql = "select * from Man";
        ResultSet rs = SqlHelper.executeQuery(sql);
        try {
        	while(rs.next()) {
        		Man man = new Man();
        		man.setId(rs.getString(1));
        		man.setPwd(rs.getString(2));
        		man.setName(rs.getString(3));
        		manList.add(man);
        	}
        }
        catch (Exception e) {
            e.printStackTrace();
        }
		return manList;
	}
	
	public static List<Man> selectManById(String id) {
		List<Man> manList = new ArrayList<Man>();
		String sql = "select * from Man where Mid = '" + id + "' ";
        ResultSet rs = SqlHelper.executeQuery(sql);
        try {
        	while(rs.next()) {
        		Man man = new Man();
        		man.setId(rs.getString(1));
        		man.setPwd(rs.getString(2));
        		man.setName(rs.getString(3));
        		manList.add(man);
        	}
        }
        catch (Exception e) {
            e.printStackTrace();
        }
		return manList;
	}
	
	public static int changePwd(String password,String userid) {
		String sql="update Man set Mpwd='"+password+"' where Mid='"+userid+"'";
		return SqlHelper.executeUpdate(sql);
	}
	
	public static List<Diary> allDiaries() {
		List<Diary> diaryList = new ArrayList<Diary>();
		String sql = "select * from Diary";
        ResultSet resultSet = SqlHelper.executeQuery(sql);
        try {
        	while (resultSet.next()) {
        		Diary diary = new Diary();
        		diary.setId(resultSet.getString(1));
        		diary.setIp(resultSet.getString(2));
        		diary.setTime(resultSet.getDate(3));
        		diaryList.add(diary);
        	}
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return diaryList;
	}
	
	public static List<User> allUsers() {
        List<User> userList = new ArrayList<User>();
        String sql = "select * from User";
        ResultSet resultSet = SqlHelper.executeQuery(sql);
        try {
            while (resultSet.next()) {
                User user = new User();
                user.setUserid(resultSet.getString(1));
                user.setPassword(resultSet.getString(2));
                user.setName(resultSet.getString(3));
                user.setUni(resultSet.getString(4));
                userList.add(user);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }
	
	public static List<Book> allBooks() {
        List<Book> bookList = new ArrayList<Book>();
        String sql = "select * from Book";
        ResultSet resultSet = SqlHelper.executeQuery(sql);
        try {
            while (resultSet.next()) {
                Book book = new Book();
                book.setBid(resultSet.getString(1));
                book.setBname(resultSet.getString(2));
                book.setBtype(resultSet.getString(3));
                book.setBarea(resultSet.getString(4));
                book.setBcount(resultSet.getInt(5));
                book.setBpublish(resultSet.getString(6));
                book.setBuseuni(resultSet.getString(7));
                book.setBusediscipline(resultSet.getString(8));
                book.setBusegrade(resultSet.getInt(9));
                bookList.add(book);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return bookList;
    }
	
	public static List<Discipline> allDisciplines() {
        List<Discipline> disciplineList = new ArrayList<Discipline>();
        String sql = "select * from Discipline";
        ResultSet resultSet = SqlHelper.executeQuery(sql);
        try {
            while (resultSet.next()) {
                Discipline discipline = new Discipline();
                discipline.setId(resultSet.getString(1));
                discipline.setName(resultSet.getString(2));
                discipline.setG1(resultSet.getInt(3));
                discipline.setG2(resultSet.getInt(4));
                discipline.setG3(resultSet.getInt(5));
                discipline.setG4(resultSet.getInt(6));
                discipline.setUni(resultSet.getString(7));
                disciplineList.add(discipline);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return disciplineList;
    }
	
	public static List<Inbuy> allInbuys() {
        List<Inbuy> inbuyList = new ArrayList<Inbuy>();
        String sql = "select * from Inb";
        ResultSet resultSet = SqlHelper.executeQuery(sql);
        try {
            while (resultSet.next()) {
                Inbuy inbuy = new Inbuy();
                inbuy.setId(resultSet.getString(1));
                inbuy.setName(resultSet.getString(2));
                inbuy.setPrice(resultSet.getInt(3));
                inbuy.setIntime(resultSet.getDate(4));
                inbuy.setCount(resultSet.getInt(5));
                inbuy.setUni(resultSet.getString(6));
                inbuyList.add(inbuy);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return inbuyList;
    }
	
	public static List<Email> allEmails() {
		List<Email> emailList = new ArrayList<Email>();
		String sql = "select * from Em";
        ResultSet rs = SqlHelper.executeQuery(sql);
        try {
        	while(rs.next()) {
        		Email email = new Email();
        		email.setUserid(rs.getString(1));
        		email.setUseremail(rs.getString(2));
        		email.setUserrequest(rs.getString(3));
        		emailList.add(email);
        	}
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return emailList;
	}
}