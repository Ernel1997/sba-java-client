package com.sba.ppp.loanforgiveness.domain;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EtranLoan {
	
	private UUID slug;
	
	private String etran_notional_amount;
	
	private String bank_notional_amount;
	
	private String sba_number;
	
	private String loan_number;
	
	private String entity_name;
	
	private String application_id;
	
	private String ein;
	
	// format - yyyy-MM-dd
	private String funding_date;
	
	private String forgive_eidl_amount;
	
	private Integer forgive_eidl_application_number;
	
	private String forgive_payroll;
	
	private String forgive_rent;
	
	private String forgive_utilities;
	
	private String forgive_mortgage;
	
	private String address1;
	
	private String address2;
	
	private String dba_name;
	
	private String phone_number;

	private Integer forgive_fte_at_loan_application;
	
	private List<Demographics> demographics;
	
	private List<LoanDocument> documents;
	
	private BankStatus bank_status;

	private String forgive_line_6_3508_or_line_5_3508ez;
	
	private String forgive_modified_total;
	
	private String forgive_payroll_cost_60_percent_requirement;
	
	private String forgive_amount;
	
	private Integer forgive_fte_at_forgiveness_application;
	
	private String forgive_schedule_a_line_1;

	private String forgive_schedule_a_line_2;
	
	private boolean forgive_schedule_a_line_3_checkbox;
	
	private String forgive_schedule_a_line_3;
	
	private String forgive_schedule_a_line_4;
	
	private String forgive_schedule_a_line_5;
	
	private String forgive_schedule_a_line_6;
	
	private String forgive_schedule_a_line_7;
	
	private String forgive_schedule_a_line_8;
	
	private String forgive_schedule_a_line_9;
	
	private String forgive_schedule_a_line_10;
	
	private boolean forgive_schedule_a_line_10_checkbox;
	
	private String forgive_schedule_a_line_11;
	
	private String forgive_schedule_a_line_12;
	
	private String forgive_schedule_a_line_13;
	
	private String forgive_covered_period_from;
	
	private String forgive_covered_period_to;
	
	private String forgive_alternate_covered_period_from;
	
	private String forgive_alternate_covered_period_to;
	
	private boolean forgive_2_million;
	
	private String forgive_payroll_schedule;

}
