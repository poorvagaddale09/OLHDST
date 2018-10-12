package com.testscripts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.common.BaseTest;
import com.common.CommonFunctions;
import com.common.WebTable;
import com.common.XLUtilities;
import com.pages.ConsignmentDetailsPage;
import com.pages.ConsignmentSummaryPage;
import com.pages.EventDetailsPage;
import com.pages.PreconDetailsPage;
import com.pages.ReceptacleSummary;
import com.pages.SearchConsignmentPage;

public class RESCONFieldValidations extends BaseTest {
	SearchConsignmentPage scp;
	ConsignmentDetailsPage cdp;
	ConsignmentSummaryPage csp;
	CommonFunctions cf;
	XLUtilities ul; 
	WebTable wt;
	EventDetailsPage edp;
	PreconDetailsPage precon;
	ReceptacleSummary rs;
	String errorMessage="errormessage";
	String consignmentsummary="consignmentsummary";
	String TestData="TestData";
	String RESCONFieldValidations="RESCONFieldValidations";
	String ConsignmentNO="ConsignmentNO";
	String resconinformation="resconinformation";
	String RID="RID";
	String NOP="NOP";
	String Receptype="Receptype";
	String RecepID="RecepID";
	String RSC="RSC";
	String DDI="DDI";
	String RDGI="RDGI";
	String RFC="RFC";
	String RHC="RHC";
	String REI="REI";
	String EII="EII";
	String RAW="RAW";
	String RI="RI";
	String DID="DID";
	
	String consignNo;
	String ReceptacleID;

	String nop;
	String rt;
	String rid;
	String rsc;
	String ddi;
	String rdgi;
	String rfc;
	String rhc;
	String rei;
	String eii;
	String raw;
	String ri;
	String did;
	
	
	@BeforeClass
	public void fetchValues() throws Exception {
	openURL();
	scp= new SearchConsignmentPage(driver);
	cf= new CommonFunctions();
	ul=new XLUtilities();
	cdp=new ConsignmentDetailsPage(driver);
	csp = new ConsignmentSummaryPage(driver);
	wt=new WebTable();
	edp=new EventDetailsPage(driver);
	precon=new PreconDetailsPage(driver);
	rs= new ReceptacleSummary(driver);
	consignNo=ul.getvalueFromxcell(EXCEL_PATH, resconinformation, RESCONFieldValidations, ConsignmentNO);
	
	ReceptacleID=ul.getvalueFromxcell(EXCEL_PATH, resconinformation, RESCONFieldValidations, RID);
	
	nop=ul.getvalueFromxcell(EXCEL_PATH, resconinformation, RESCONFieldValidations, NOP);
	rt=ul.getvalueFromxcell(EXCEL_PATH, resconinformation, RESCONFieldValidations, Receptype);
	rid=ul.getvalueFromxcell(EXCEL_PATH, resconinformation, RESCONFieldValidations, RecepID);
	rsc=ul.getvalueFromxcell(EXCEL_PATH, resconinformation, RESCONFieldValidations, RSC);
	ddi=ul.getvalueFromxcell(EXCEL_PATH, resconinformation, RESCONFieldValidations, DDI);
	rdgi=ul.getvalueFromxcell(EXCEL_PATH, resconinformation, RESCONFieldValidations, RDGI);
	rfc=ul.getvalueFromxcell(EXCEL_PATH, resconinformation, RESCONFieldValidations, RFC);
	rhc=ul.getvalueFromxcell(EXCEL_PATH, resconinformation, RESCONFieldValidations, RHC);
	rei=ul.getvalueFromxcell(EXCEL_PATH, resconinformation, RESCONFieldValidations, REI);
	eii=ul.getvalueFromxcell(EXCEL_PATH, resconinformation, RESCONFieldValidations, EII);
	raw=ul.getvalueFromxcell(EXCEL_PATH, resconinformation, RESCONFieldValidations, RAW);
	ri=ul.getvalueFromxcell(EXCEL_PATH, resconinformation, RESCONFieldValidations, RI);
	did=ul.getvalueFromxcell(EXCEL_PATH, resconinformation, RESCONFieldValidations, DID);
	
	
	}
	
	@Test
	public void validateFields() throws Exception {
		cf.click(scp.searchConsignment, "searchConsignment");
		cf.sendKeys(scp.consignmentNumber, consignNo, "consignmentNumber");
		cf.click(scp.findItem, "findItem");
		cf.verifyElement_NOTPresent(scp.errorMsg, errorMessage);
		//toSwitchTab(2);
		driver.get("http://npermg397:8090/CTS/#!/consignments/"+consignNo+"");
		
		cf.click(csp.consignmentDetails, "consignmentDetails");
		Thread.sleep(2000);
		cf.click(cdp.ReceptacleID(ReceptacleID), "ReceptacleID");
		System.out.println(rs.resconNOP+"resconNOP"+nop);
		
		cf.verifyElement_text(rs.resconNOP, nop, "resconNOP");
		
		cf.verifyElement_text(rs.resconRt, rt, "resconRt");
		cf.verifyElement_text(rs.resconRid, rid, "resconRid");
		cf.verifyElement_text(rs.resconRsc, rsc, "resconRsc");
		cf.verifyElement_text(rs.resconDdi, ddi, "resconDdi");
		cf.verifyElement_text(rs.resconRdgi, rdgi, "resconRdgi");
		cf.verifyElement_text(rs.resconRhc, rhc, "resconRhc");
		cf.verifyElement_text(rs.resconRfc, rfc, "resconRfc");
		cf.verifyElement_text(rs.resconRei, rei, "resconRei");
		cf.verifyElement_text(rs.resconEii, eii, "resconEii");
		cf.verifyElement_text(rs.resconRaw, raw, "resconRaw");
		cf.verifyElement_text(rs.resconRi, ri, "resconRi");
		cf.verifyElement_text(rs.resconDid, did, "resconDid");
		
	
	}
	}


