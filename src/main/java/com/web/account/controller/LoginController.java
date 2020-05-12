package com.web.account.controller;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.account.entity.Login;
import com.web.account.service.LoginService;
import com.web.account.utils.AES;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Login", description = "the Login API")
@RequestMapping(path = "/login", produces = "application/json")
public class LoginController {

	@Value("${SECRET}")
	private String secret;
	@Autowired
	private LoginService service;
    @Autowired
    private AES aes;
	
	@Operation(summary = "Save login", description = "save login data to table", tags = { "Login" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = Login.class))) })
	@PostMapping(path = "/save")
	public Login addLogin(@RequestBody Login login) {
		prepareLogin(login);
		return service.save(login);
	}

	private void prepareLogin(Login login) {
		login.setPassword(aes.encrypt(login.getPassword(), secret));
	}
	
    @Operation(summary = "Save All Login", description = "save multiple Login data to table", tags = { "Login" })
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "successful operation", 
    		 content = @Content(array = @ArraySchema(schema = @Schema(implementation = Login.class))))})	
	 @PostMapping(path = "/saveall")
	    public List<Login> addLoginAll(@RequestBody List<Login> acctList) {
			return service.saveAll(acctList) ;
	    }
    
    @Operation(summary = "Get Login", description = "get Login data from table", tags = { "Login" })
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "successful operation", 
    		content = @Content(schema = @Schema(implementation = Login.class))) })	
	 @GetMapping(path = "/get")
	 public Login getLogin(@QueryParam("Loginname")String LoginName ) {
			return service.getLogin(LoginName);
	    }
	 
    @Operation(summary = "Get All Login", description = "get all Login data from table", tags = { "Login" })
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "successful operation", 
    		 content = @Content(array = @ArraySchema(schema = @Schema(implementation = Login.class))))})
	 @GetMapping(path = "/getall")
	 public List<Login> getAllLogin() {
			return service.getAllLogin();
	    }
	
    @Operation(summary = "update Login", description = "update Login data to table", tags = { "Login" })
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "successful operation", 
    		 content = @Content(array = @ArraySchema(schema = @Schema(implementation = Login.class))))})
	 @PutMapping(path = "/update")
	 public Login updateLogin(@RequestBody Login acct)
	 
	 {
		 return service.updateLogin(acct);
	 }
    
	 @Operation(summary = "Delete Login", description = "Delete Login data to table", tags = { "Login" })
	    @ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "successful operation", 
	    		 content = @Content(array = @ArraySchema(schema = @Schema(implementation = Login.class))))})
	 @DeleteMapping(path = "/delete")
	 public String deleteLogin(@QueryParam("Loginname")String loginName) {
		 return service.deleteLogin(loginName);
	 }
	
}
