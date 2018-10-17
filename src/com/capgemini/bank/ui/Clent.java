package com.capgemini.bank.ui;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.Date;
import com.capgemini.bank.bean.DemandDraft;
import com.capgemini.bank.exceptions.BankingServicesDownException;
import com.capgemini.bank.service.DemandDraftService;
import com.capgemini.bank.service.IDemandDraftService;

public class Clent {
	public static void main(String[] args) throws SQLException {
		String customerName, inFavorOf, ddDescription;
		long phoneNo;
		float ddAmount;
		int choice;
		Scanner ref = new Scanner(System.in);
		System.out.println("Enter your choice: \n 1.)Enter Demand Draft Details \n 2.)Exit");
		choice = ref.nextInt();
		switch(choice){
		case 1:
			System.out.println("Enter the name of the customer: ");
			customerName = ref.next();
			System.out.println("Enter Customer Phone Number: ");
			phoneNo = ref.nextLong();
			System.out.println("In Favor of: ");
			inFavorOf = ref.next();
			System.out.println("Enter Demand Draft amount (in Rs): ");
			ddAmount = ref.nextFloat();
			System.out.println("Enter Remarks: ");
			ddDescription = ref.next();
			ref.close();
			Date date = new Date();
			System.out.println(date);
			DemandDraft demandDraft1 = new DemandDraft(customerName, inFavorOf, ddDescription, date, phoneNo, ddAmount);
			//DemandDraft demandDraft1 = new DemandDraft(customerName, inFavorOf, ddDescription, new Date(), phoneNo, ddAmount);
			IDemandDraftService demandServices = new DemandDraftService();
			try{
				
				int transId = demandServices.addDemandDraftDetails(demandDraft1);
				System.out.println("Your Demand Draft request has been successfully registered along with the " + transId);
			}catch(BankingServicesDownException e){
				e.printStackTrace();
			}
		case 2:
			ref.close();
			break;
		default:
			break;
		}
	}
}