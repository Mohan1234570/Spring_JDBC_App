package in.gmk.Impl;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jndi.JndiTemplate;

import in.gmk.Beans.UserDAO;

public class UserDAOImpl implements UserDAO{

	private DataSource datasource;
	private JndiTemplate jdbcTemplateObject;
	SimpleJdbcInsert jdbcInsert;
	
	public boolean save(DataSource dataSource) {
       this.datasource=dataSource;
       this.jdbcTemplateObject=jdbcTemplateObject;
       this.jdbcInsert= new SimpleJdbcInsert(dataSource).withTableName("Student");
	}

	public boolean save(String name, Integer age) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("name", name);
		parameters.put("age", age);
		
		jdbcInsert.execute(parameters);

		System.out.println("Created Record Name = " + name + " Age = " + age);
		return false;
	}
}
