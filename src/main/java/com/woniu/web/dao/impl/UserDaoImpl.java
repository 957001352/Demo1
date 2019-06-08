package com.woniu.web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woniu.web.bean.User;
import com.woniu.web.dao.IUserDao;
import com.woniu.web.util.JdbcUtil;

public class UserDaoImpl implements IUserDao{
	public void save(User user) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = JdbcUtil.getConnection();
			String sql = "insert into user values(null,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setDate(2, new java.sql.Date(user.getBrithday().getTime()));
			ps.setDouble(3, user.getMoney());
			ps.setString(4, user.getPhoto());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.closeConn(null, ps, conn);
		}
	}
	public void delete(Integer id) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = JdbcUtil.getConnection();
			String sql = "delete from user where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.closeConn(null, ps, conn);
		}
	}
	public void update(User user) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = JdbcUtil.getConnection();
			String sql = "update user set name=?,brithday=?,money=?,photo=? where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setDate(2, new java.sql.Date(user.getBrithday().getTime()));
			ps.setDouble(3, user.getMoney());
			ps.setString(4, user.getPhoto());
			ps.setInt(5, user.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.closeConn(null, ps, conn);
		}
	}
	public User find(Integer id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from user where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setBrithday(rs.getDate("brithday"));
				user.setMoney(rs.getDouble("money"));
				user.setPhoto(rs.getString("photo"));
				return user;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.closeConn(rs, ps, conn);
		}
		return null;
	}
	public List<User> find() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from user";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			List<User> list = new ArrayList<>();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setBrithday(rs.getDate("brithday"));
				user.setMoney(rs.getDouble("money"));
				user.setPhoto(rs.getString("photo"));
				list.add(user);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.closeConn(rs, ps, conn);
		}
	}
	@Override
	public int getRowCount() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select count(*) from user";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			int rowCount = 0;
			if(rs.next()) {
				rowCount = rs.getInt(1);
			}
			return rowCount;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.closeConn(rs, ps, conn);
		}
	}
	@Override
	public List<User> find(int startLine, int size) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from user limit ?,?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, startLine);
			ps.setInt(2, size);
			rs = ps.executeQuery();
			List<User> list = new ArrayList<>();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setBrithday(rs.getDate("brithday"));
				user.setMoney(rs.getDouble("money"));
				user.setPhoto(rs.getString("photo"));
				list.add(user);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.closeConn(rs, ps, conn);
		}
	}
	
}
