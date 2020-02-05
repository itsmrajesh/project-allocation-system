package com.proj.dao;

import java.sql.*;
import java.util.List;

import com.proj.dbutil.DBUtil;
import com.proj.domain.MyProject;
import com.proj.domain.Student;

public class DaoImpl implements Dao {

	private DBUtil db = DBUtil.db;
	private Connection con = db.getConnection();
	private PreparedStatement pst;
	private Statement st;
	private ResultSet rs;

	@Override
	public boolean signUpStudent(Student s) {
		String sql = "INSERT INTO studentinfo values (?,?,?,?,?,?,?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, s.getUsn());
			pst.setString(2, s.getName());
			pst.setString(3, s.getDept());
			pst.setInt(7, s.getSem());
			pst.setString(4, s.getEmail());
			pst.setString(5, s.getMob());
			pst.setString(6, s.getPwd());
			int rows = pst.executeUpdate();
			if (rows == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Student getStudent(String usn) {
		String sql = "SELECT * FROM STUDENTINFO WHERE USN = ?";
		Student student = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, usn);
			rs = pst.executeQuery();
			while (rs.next()) {
				student = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public boolean registerProject(MyProject project) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<MyProject> getStudentProject(String usn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateProject(int pid, String status) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
