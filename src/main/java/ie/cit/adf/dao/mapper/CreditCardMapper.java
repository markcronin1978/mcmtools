package ie.cit.adf.dao.mapper;



import java.sql.ResultSet;
import java.sql.SQLException;

import ie.cit.adf.domain.CreditCard;

import org.springframework.jdbc.core.RowMapper;

public class CreditCardMapper implements RowMapper<CreditCard> {

	public CreditCard mapRow(ResultSet rs, int rowNum) throws SQLException {
		CreditCard cc = new CreditCard();
		
		cc.setId(rs.getString("id"));
		cc.setName(rs.getString("name"));
		cc.setNumber(rs.getBigDecimal("number"));
		cc.setEmail(rs.getString("email"));
		cc.setExpMonth(rs.getInt("expmonth"));
		cc.setExpYear(rs.getInt("expyear"));
		cc.setSecurityCode(rs.getInt("securityCode"));
		cc.setCardType(rs.getString("cardType"));
				
		return cc;
	}

}
