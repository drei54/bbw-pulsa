/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bbw.pulsa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbw.pulsa.dao.OperatorDao;
import com.bbw.pulsa.dao.TransactionDao;
import com.bbw.pulsa.dao.UserDao;
import com.bbw.pulsa.dao.VoucherDao;
import com.bbw.pulsa.entity.Operator;
import com.bbw.pulsa.entity.Transaction;
import com.bbw.pulsa.entity.User;
import com.bbw.pulsa.entity.Voucher;
import com.bbw.pulsa.entity.response.OperatorResponse;
import com.bbw.pulsa.entity.response.PResponse;
import com.bbw.pulsa.entity.response.VoucherResponse;
import com.bbw.pulsa.enums.InputType;
import com.bbw.pulsa.enums.ResponseCode;
import com.bbw.pulsa.utils.Validation;

@Controller
public class ApiController {

	private Logger logger = Logger.getLogger(ApiController.class.getName());
	
	@Autowired 
	private Validation validation;
	
	@Autowired 
	private UserDao userDao;

	@Autowired 
	private OperatorDao operatorDao;

	@Autowired 
	private VoucherDao voucherDao;

	@Autowired 
	private TransactionDao transactionDao;

	@RequestMapping(value = "/api", method = RequestMethod.GET)
	@ResponseBody
	public PResponse getReportAssessmentAtPos(			
			@RequestParam(value = "type", required = true , defaultValue="") final String type,
			@RequestParam(value = "username", required = false) final String username,
			@RequestParam(value = "userid", required = false) final Long userid,
			@RequestParam(value = "password", required = false) final String password,
			@RequestParam(value = "operator", required = false) final String operator,
			@RequestParam(value = "harga", required = false) final String harga,
			@RequestParam(value = "phone", required = false) final String phone
			) {
		PResponse pResponse = new PResponse(ResponseCode.GAGAL);
		try {
			switch(InputType.get(type)) {
				case LOGIN:
					if(username == null || password == null || username.isEmpty() || password.isEmpty()) {
						pResponse.setMsg("Username dan Password harus di isi");
					}else if(username.length() < 6 || !validation.isAlpha(username)) {
						pResponse.setMsg("Username harus terdiri dari huruf saja dan minimal 6 huruf");
					}else {
						User user = userDao.findByUsername(username);
						if(user == null) {
							pResponse.setMsg("Username tidak di temukan");						
						}else if(!user.getPassword().equals(password)) {
							pResponse.setMsg("Password salah");
						}else {
							pResponse.setStatus(ResponseCode.SUKSES.getStatus());
							pResponse.setMsg("Sukses");
							pResponse.setUserid(user.getId());
						}
					}
					break;
				case OPERATOR:
					pResponse.setMsg("Data tidak ditemukan");
					pResponse.setStatus(ResponseCode.SUKSES.getStatus());
	
					List<OperatorResponse> oResponses = new ArrayList<OperatorResponse>();
					List<Operator> operators = (List<Operator>) operatorDao.findAll();
					if(operators.size() > 0) {
						for(Operator o : operators) {
							oResponses.add(new OperatorResponse(o));
						}
						pResponse.setMsg("Data ditemukan");
						pResponse.setOperator(oResponses);
					}
					break;
				case VOUCHER:
					if(operator == null) {
						pResponse.setMsg("parameter operator harus diisi");					
					}else {
	
						List<VoucherResponse> vResponses = new ArrayList<VoucherResponse>();
						List<Voucher> vouchers = (List<Voucher>) voucherDao.findByOperatorName(operator);
						if(vouchers.size() > 0) {
							for(Voucher v : vouchers) {
								vResponses.add(new VoucherResponse(v));
							}
							pResponse.setStatus(ResponseCode.SUKSES.getStatus());
							pResponse.setMsg("Data ditemukan");
							pResponse.setVoucher(vResponses);
						}else {
							pResponse.setMsg("Voucher tidak ditemukan");
						}
						
					}
					break;
				case TRANSACTION:
					if(phone == null || phone.isEmpty()) {
						pResponse.setMsg("Phone Number harus di isi");
					}else if(!Validation.isNumeric(phone)) {
						pResponse.setMsg("Phone Number harus angka");					
					}else if(userid == null) {
						pResponse.setMsg("User Id harus di isi");
					}else if(operator == null || operator.isEmpty()) {
						pResponse.setMsg("Operator harus di isi");
					}else if(harga == null || harga.isEmpty()) {
						pResponse.setMsg("Harga harus di isi");
					}else {
//						User user = userDao.findByUsername(userid);
						User user = userDao.findById(userid);
						Operator op = operatorDao.findByName(operator);
						Transaction transaction = new Transaction(user, op, harga, phone);
						Transaction tr = transactionDao.save(transaction);
						if(tr != null) {
							pResponse.setStatus(ResponseCode.SUKSES.getStatus());
							pResponse.setMsg("Transaction Sukses");
						}else {
							pResponse.setMsg("Error Input transaction");
						}
					}
					break;
				case UNKNOWN:
					pResponse.setMsg("Type tidak di temukan.");
					break;
			}
		}catch(Exception e) {
			e.printStackTrace();
			pResponse.setMsg("Internal Server Error");
		}		
		return pResponse;
	}

	
}
