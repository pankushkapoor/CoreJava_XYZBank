package com.capgemini.bank.service;

import java.sql.SQLException;

import com.capgemini.bank.bean.DemandDraft;
import com.capgemini.bank.dao.DemandDraftDAO;
import com.capgemini.bank.dao.IDemandDraftDAO;
import com.capgemini.bank.exceptions.BankingServicesDownException;
import com.capgemini.bank.exceptions.InvalidTransactionIdException;

public class DemandDraftService implements IDemandDraftService{
	IDemandDraftDAO demandDao = new DemandDraftDAO();
	@Override
	public int addDemandDraftDetails(DemandDraft demandDraft) throws SQLException, BankingServicesDownException {
		int transId;
		try {
			transId = demandDao.addDemandDraftDetails(demandDraft);
			
			//System.out.println("Your Demand Draft request has been successfully registered along with the " + transId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BankingServicesDownException("Oops! Banking Services are Down..");
		}
		return transId;
	}

	@Override
	public DemandDraft getDemandDraftDetails(int transactionId) throws SQLException, InvalidTransactionIdException {
		try {
			DemandDraft demandDraft = demandDao.getDemandDraftDetails(transactionId);
			if(demandDraft == null) throw new InvalidTransactionIdException("Invalid Transaction Id");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
