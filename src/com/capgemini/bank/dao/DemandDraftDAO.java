package com.capgemini.bank.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capgemini.bank.bean.DemandDraft;
import com.capgemini.bank.util.ConnectionProvider;

public class DemandDraftDAO implements IDemandDraftDAO{
private Connection conn = new ConnectionProvider().getDBConnection();
	@Override
	public int addDemandDraftDetails(DemandDraft demandDraft) throws SQLException{
		try{
			conn.setAutoCommit(false);
			String sql = "INSERT INTO demand_draft(transaction_id, customer_name, in_favor_of, phone_number, date_of_transaction, dd_amount, dd_commission, dd_description)"
					+ "VALUES(Transaction_Id_Seq.nextval,?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt1 = conn.prepareStatement(sql);
			pstmt1.setString(1, demandDraft.getCustomerName());
			pstmt1.setString(2, demandDraft.getInFavorOf());
			pstmt1.setLong(3, demandDraft.getPhoneNo());
			//pstmt1.setDate(4, demandDraft.getDateOfTransaction());
			//pstmt1.setDate(4, (java.sql.Date) demandDraft.getDateOfTransaction());
			pstmt1.setDate(4, new java.sql.Date(System.currentTimeMillis()));
			pstmt1.setFloat(5, demandDraft.getDdAmount());
			pstmt1.setLong(6, demandDraft.getDdCommission());
			pstmt1.setString(7, demandDraft.getDdDescription());
			pstmt1.executeUpdate();
			conn.commit();
			
			PreparedStatement pstmt2 = conn.prepareStatement("SELECT MAX(transaction_id) FROM demand_draft");
			ResultSet rs = pstmt2.executeQuery();
			rs.next();
			int transactionId = rs.getInt(1);
			return transactionId;
		}catch(SQLException e){
			e.printStackTrace();
			conn.rollback();
			throw e;
		}finally{
			conn.setAutoCommit(true);
		}
	}
	@Override
	public DemandDraft getDemandDraftDetails(int transactionId) throws SQLException {
		try {
			conn.setAutoCommit(false);
			String sql = "SELECT * FROM demand_draft WHERE transaction_id=";
			PreparedStatement pstmt2 = conn.prepareStatement(sql+transactionId);
			ResultSet demandRS = pstmt2.executeQuery();
			if(demandRS.next()){
				String customerName = demandRS.getString("customer_name");
				String inFavorOf = demandRS.getString("in_favor_of");
				long phoneNo = demandRS.getLong("phone_number");
				Date dateOfTransaction = demandRS.getDate("date_of_transaction");
				float ddAmount = demandRS.getFloat("dd_amount");
				long ddCommission = demandRS.getLong("dd_commission");
				String ddDescription = demandRS.getString("dd_description");
				
				DemandDraft demandDraft1 = new DemandDraft(customerName, inFavorOf, ddDescription, dateOfTransaction, ddCommission, phoneNo);
				return demandDraft1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		}finally{
			conn.setAutoCommit(true);
		}
		
		return null;
	}

}
