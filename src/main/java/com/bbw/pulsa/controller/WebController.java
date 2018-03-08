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

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.bbw.pulsa.dao.TransactionDao;
import com.bbw.pulsa.entity.Transaction;

@Controller
public class WebController {

	@Autowired
	private TransactionDao transactionDao;
	
	@GetMapping("/")
	public String login(Map<String, Object> model) {
		return "index";
	}

	@GetMapping("/transaction")
	public String transaction(Map<String, Object> model) {
		return "transaction";
	}

	@GetMapping("/transaction/view")
	public String transactionView(Map<String, Object> model) {
		List<Transaction> transactions = (List<Transaction>)transactionDao.findAll();
		model.put("transactions", transactions);
		return "transaction-view";
	}

}
