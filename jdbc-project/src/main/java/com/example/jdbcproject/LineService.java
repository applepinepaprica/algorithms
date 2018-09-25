package com.example.jdbcproject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.LinkedList;

@Service
public class LineService {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public LinkedList<Line> getLines(Integer id, String value) {
		LinkedList<Line> lines = new LinkedList<Line>();
		String que1 = "SELECT * FROM line";
		String que2 = " ORDER BY id DESC";

		RowMapper RM = new RowMapper<Line>(){  
		    @Override  
		    public Line mapRow(ResultSet rs, int rownumber) throws SQLException {  
		        Line l = new Line();
		        l.setId(rs.getInt(1));
		        l.setValue(rs.getString(2)); 
		        lines.add(l);
		        return l;
		    }
    	};  

    	/*Фильтр устроен примерно так, как в ЭК, т е если в запросе есть id,
    	то программа ищет строку с этим id, не обращая внимания на другие условия.*/
    	if (id != null) {
			jdbcTemplate.query(que1 + " WHERE id = (?)" + que2, new Object[] { id }, RM);
		} else if (value != null && !value.isEmpty()) {
			jdbcTemplate.query(que1 + " WHERE INSTR(value, ?) > 0" + que2, new Object[] { value }, RM);
		} else {
			jdbcTemplate.query(que1 + que2, RM);
		}

		return lines;
	}

	public void insertLine(Line line) {
		jdbcTemplate.update("INSERT INTO line(value) VALUES (?)", line.getValue());
	}
}