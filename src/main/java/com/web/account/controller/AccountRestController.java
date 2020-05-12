package com.web.account.controller;

import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.account.entity.Account;
import com.web.account.service.AccountService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Account", description = "the Account API")
@RequestMapping(path = "/account", produces ="application/json")
public class AccountRestController {

	@Autowired
	private AccountService service;
	
	
    @Operation(summary = "Save Account", description = "save account data to table", tags = { "Account" })
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "successful operation", 
    content = @Content(schema = @Schema(implementation = Account.class))) })	
	@PostMapping(path = "/save")
	    public Account addAccount(@RequestBody Account acct) {
			return service.save(acct) ;
	    }
    
    @Operation(summary = "Save All Account", description = "save multiple account data to table", tags = { "Account" })
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "successful operation", 
    		 content = @Content(array = @ArraySchema(schema = @Schema(implementation = Account.class))))})	
	 @PostMapping(path = "/saveall")
	    public List<Account> addAccountAll(@RequestBody List<Account> acctList) {
			return service.saveAll(acctList) ;
	    }
    
    @Operation(summary = "Get Account", description = "get account data from table", tags = { "Account" })
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "successful operation", 
    		content = @Content(schema = @Schema(implementation = Account.class))) })	
	 @GetMapping(path = "/get")
	 public Account getAccount(@QueryParam("accountnumber")Integer accountNumber ) {
			return service.getAccount(accountNumber);
	    }
	 
    @Operation(summary = "Get All Account", description = "get all account data from table", tags = { "Account" })
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "successful operation", 
    		 content = @Content(array = @ArraySchema(schema = @Schema(implementation = Account.class))))})
	 @GetMapping(path = "/getall")
	 public List<Account> getAllAccount() {
			return service.getAllAccount();
	    }
	
    @Operation(summary = "update Account", description = "update account data to table", tags = { "Account" })
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "successful operation", 
    		 content = @Content(array = @ArraySchema(schema = @Schema(implementation = Account.class))))})
	 @PutMapping(path = "/update")
	 public Account updateAccount(@RequestBody Account acct)
	 
	 {
		 return service.updateAccount(acct);
	 }
    
	 @Operation(summary = "Delete Account", description = "Delete account data to table", tags = { "Account" })
	    @ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "successful operation", 
	    		 content = @Content(array = @ArraySchema(schema = @Schema(implementation = Account.class))))})
	 @DeleteMapping(path = "/delete")
	 public String deleteAccount(Integer acctNo) {
		 return service.deleteAccount(acctNo);
	 }
	 
	 @Operation(summary = "Delete All Account", description = "Delete multiple account data to table", tags = { "Account" })
	    @ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "successful operation", 
	    		 content = @Content(array = @ArraySchema(schema = @Schema(implementation = Account.class))))})
	 @DeleteMapping(path = "/deleteall")
		public String deleteAllAccount(List<Integer> acctNoList) {
		 return service.deleteAllAccount(acctNoList);
	 }
	 
	 @Operation(summary = "Get By Condition", description = "Get details using condition ", tags = { "Account" })
	    @ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "successful operation", 
	    		 content = @Content(schema = @Schema(implementation = Account.class)))})
	 @GetMapping(path = "/getbycondition/{name}")
		public Account deleteByCondition(@PathParam("name")String acctName) {
		 return service.getByCondition(acctName);		 
	 }
	 
	 
	 
	 
	 

	
}
