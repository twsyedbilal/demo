package com.techweaversys.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.techweaversys.generics.Code;
import com.techweaversys.generics.Messages;
import com.techweaversys.generics.Response;

@ControllerAdvice
public class ApplicationExceptionHandler extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7933456484465085802L;

	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<?> handleSQLException(HttpServletRequest request, UserAlreadyExistsException ex){
		
		return Response.build(Code.CONFLICT,Messages.CONTACT_AlREADY);
	}
	/*
	 * @ExceptionHandler(UserAlreadyExistsException.class) public ResponseEntity<?>
	 * handleSQLException(HttpServletRequest request, UserAlreadyExistsException
	 * ex){
	 * 
	 * return Response.build(Code.CONFLICT,Messages.USER_EXISTS_MSG); }
	 * 
	 * @ExceptionHandler(CompanyAlreadyExistsException.class) public
	 * ResponseEntity<?> handleSQLException(HttpServletRequest request,
	 * CompanyAlreadyExistsException ex){
	 * 
	 * return Response.build(Code.CONFLICT,Messages.COMPANY_AlREADY); }
	 * 
	 * @ExceptionHandler(ItemAlreadyExistsException.class) public ResponseEntity<?>
	 * handleSQLException(HttpServletRequest request, ItemAlreadyExistsException
	 * ex){
	 * 
	 * return Response.build(Code.CONFLICT,Messages.ITEM_AlREADY); }
	 * 
	 * @ExceptionHandler(ProductCodeAlreadyExistsException.class) public
	 * ResponseEntity<?> handleSQLException(HttpServletRequest request,
	 * ProductCodeAlreadyExistsException ex){
	 * 
	 * return Response.build(Code.CONFLICT,Messages.PRODUCT_CODE_AlREADY); }
	 * 
	 * @ExceptionHandler(BankAlready.class) public ResponseEntity<?>
	 * handleSQLException(HttpServletRequest request, BankAlready ex){
	 * 
	 * return Response.build(Code.CONFLICT,Messages.BANK_ALREADY); }
	 */

	@ExceptionHandler(AdmissionAlreadyExiststException.class)
	public ResponseEntity<?> handleSQLExceptionAd(HttpServletRequest request, AdmissionAlreadyExiststException ex){
		
		return Response.build(Code.CONFLICT,Messages.ADMISSION_AlREADY);
	}

}
