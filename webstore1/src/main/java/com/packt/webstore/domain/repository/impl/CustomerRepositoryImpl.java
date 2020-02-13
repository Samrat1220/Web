package com.packt.webstore.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerInterface;

@Repository
public class CustomerRepositoryImpl implements CustomerInterface {

	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(javax.sql.DataSource dataSource) {
		this.jdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public List<Customer> getAllCustomers() {
		
		Map<String, Object> params=new HashMap<String, Object>();
		List<Customer> result=jdbcTemplate.query("SELECT * from Customers",params, new Customermapper());
		return result;
	}
	
	private static final class Customermapper implements RowMapper<Customer>{
		public Customer mapRow(ResultSet rs,int rowNum) throws SQLException{
		
			Customer customer=new Customer();
			customer.setCustomerId(rs.getString("ID"));
			customer.setName(rs.getString("NAME"));
			customer.setAddress(rs.getString("ADDRESS"));
			customer.setNoOfOrdersMade(rs.getInt("NOOFORDERSMADE"));
			return customer;
		}
	}

}
