package com.capgemini.bank.service;

import java.sql.SQLException;

import com.capgemini.bank.bean.DemandDraft;
import com.capgemini.bank.exceptions.BankingServicesDownException;
import com.capgemini.bank.exceptions.InvalidTransactionIdException;

public interface IDemandDraftService {
	int addDemandDraftDetails(DemandDraft demandDraft) throws SQLException, BankingServicesDownException;
	DemandDraft getDemandDraftDetails(int transactionId) throws SQLException, InvalidTransactionIdException;
}