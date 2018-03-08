package com.ocr.test.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("offersDAO")
public class OffersDAO {

	// Using named parameters is good :
	private NamedParameterJdbcTemplate jdbc;
	
	public OffersDAO() {
		
		System.out.println("Successfully loaded offers DAO");
	}

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	public List<Offer> getOffers() {
		
		//MapSqlParameterSource params = new MapSqlParameterSource("name", "Bob%");
		//params.addValue(paramName, value);
		
		return jdbc.query("SELECT * FROM offers ",new RowMapper<Offer>() {

			public Offer mapRow(ResultSet arg0, int arg1) throws SQLException {


				Offer offer = new Offer();
				
				offer.setId(arg0.getInt("id"));
				offer.setName(arg0.getString("name"));
				offer.setText(arg0.getString("text"));
				offer.setEmail(arg0.getString("email"));
				
				return offer;
				
			}
			
			
		});
		
	}
	
	
	public Offer getOffer(int id) {
		
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		//params.addValue(paramName, value);
		
		return jdbc.queryForObject("SELECT * FROM offers WHERE id = :id", params, new RowMapper<Offer>() {

			public Offer mapRow(ResultSet arg0, int arg1) throws SQLException {


				Offer offer = new Offer();
				
				offer.setId(arg0.getInt("id"));
				offer.setName(arg0.getString("name"));
				offer.setText(arg0.getString("text"));
				offer.setEmail(arg0.getString("email"));
				
				return offer;
				
			}
			
			
		});
		
	}
	
	
	/**
	 * Batch update which can be supplied in another dedicated maven module
	 * implementing transactional within the queries
	 */
	@Transactional
	public int[] create(List<Offer> offers) {
		
		// Very useful method :
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offers.toArray());
		
		return jdbc.batchUpdate("INSERT INTO offers (name,text, email) value (:name, :text, :email)", params);
		
		
	}
	
	@Transactional
	public int create(Offer offer) {
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		
		return jdbc.update("INSERT INTO offers (name,text, email) value (:name, :text, :email)", params);
				
	}
	
	
	public boolean delete(int id) {
		
		MapSqlParameterSource params = new MapSqlParameterSource("id",id);
		
		//jdbc.getJdbcOperations();
		return jdbc.update("DELETE FROM offers WHERE id=:id", params) == 1;
	}
	

}
