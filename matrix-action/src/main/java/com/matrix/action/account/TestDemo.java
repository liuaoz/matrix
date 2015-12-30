package com.matrix.action.account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Service;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Service
public class TestDemo {
	private String driverClass;
	private String jdbcUrl;
	private String username;
	private String password;
	private ComboPooledDataSource combo;

	public TestDemo(String driverClass, String jdbcUrl, String username, String password, ComboPooledDataSource combo) {
		super();
		this.driverClass = driverClass;
		this.jdbcUrl = jdbcUrl;
		this.username = username;
		this.password = password;
		this.combo = combo;
		System.out.println("********driverClass*********:" + driverClass);
		System.out.println("********jdbcUrl*********:" + jdbcUrl);
		System.out.println("********username*********:" + username);
		System.out.println("********password*********:" + password);
		System.out.println("********combo*********:" + combo.getDriverClass());

		try {
			Class.forName(driverClass);
			Connection con = DriverManager.getConnection(jdbcUrl, username, password);
			Statement stmt = con.createStatement();

			String query = "select * from kettle_db.tao";
			ResultSet rs = stmt.executeQuery(query);
			System.out.println(rs);
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public TestDemo() {
	}

	public String getDriverClass() {
		return driverClass;
	}

	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}

	public String getJdbcUrl() {
		return jdbcUrl;
	}

	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ComboPooledDataSource getCombo() {
		return combo;
	}

	public void setCombo(ComboPooledDataSource combo) {
		this.combo = combo;
	}

}
