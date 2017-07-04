package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.beans.Person;

public class SpringJdbcDaoImpl implements SpringJdbcDao {
	 
	private JdbcTemplate jdbcTemplate;
 
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
 
	@Override
	public void insertMemDts(Person contact) {
 
		String query = "insert into vng_mem (NAME,DOB,EMAIL,PHONE,ADDRESS,PINCODE,COUNTRY)"
				+ " VALUES (?,?,?,?,?,?,?)";
 
		jdbcTemplate.update(
				query,
				new Object[] { contact.getName(), contact.getDob(),
						contact.getEmail(), contact.getPhone(),
						contact.getAddress(), contact.getPincode(),
						contact.getCountry() });
 
	}
 
	@Override
	public Person searchMemDts(Person vngmem) {
 
		String queryinitial = "select * from vng_mem where NAME ='"
				+ vngmem.getName() + "'";
 
		System.out.println("query formed with all the argument - "
				+ queryinitial);
 
		RowMapper rm = null;// = new RowMapper() ;
		List<Person> listcontacct = jdbcTemplate.query(queryinitial,
				new RowMapper() {
					public Person mapRow(ResultSet resultSet, int rowNum)
							throws SQLException {
						return new Person(resultSet.getString("name"),
								resultSet.getString("dob"), resultSet
										.getString("email"), resultSet
										.getString("phone"), resultSet
										.getString("address"), resultSet
										.getLong("PINCODE"), resultSet
										.getString("country"));
					}
				});
 
		if (listcontacct.size() > 0)
			return listcontacct.get(0);
 
		return new Person();
	}
 
}