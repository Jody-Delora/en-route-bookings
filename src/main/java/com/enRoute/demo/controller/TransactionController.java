package com.enRoute.demo.controller;

import com.enRoute.demo.model.Transaction;
import com.enRoute.demo.service.TransactionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JODY
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
public class TransactionController {
   /* @Value("${gmail.username}")
    private String username;
    @Value("${gmail.password}")
    private String password;*/
 /*private BraintreeGateway gateway = SampleApplication.gateway;

     private com.braintreegateway.Transaction.Status[] TRANSACTION_SUCCESS_STATUSES = new com.braintreegateway.Transaction.Status[] {
        com.braintreegateway.Transaction.Status.AUTHORIZED,
        com.braintreegateway.Transaction.Status.AUTHORIZING,
        com.braintreegateway.Transaction.Status.SETTLED,
        com.braintreegateway.Transaction.Status.SETTLEMENT_CONFIRMED,
        com.braintreegateway.Transaction.Status.SETTLEMENT_PENDING,
        com.braintreegateway.Transaction.Status.SETTLING,
        com.braintreegateway.Transaction.Status.SUBMITTED_FOR_SETTLEMENT
     };*/
    @Autowired
    private TransactionService transactionService;
    
    @RequestMapping("/transactions")
    public List<Transaction> getAllTransactions(){
        return transactionService.getAllTransactions();
    }
    
    @RequestMapping("/userTransaction/{userId}")
    public List<Transaction> getUserTransactions(@PathVariable Long userId){
        return transactionService.getUserTransactions(userId);
    }
   /* @RequestMapping("/token")
    public String getToken(){
    String clientToken = gateway.clientToken().generate();
    return clientToken;
 
    }*/
    
    /*@RequestMapping("/transaction/{id}")
    public Transaction getTransaction(@PathVariable Long id){
        return transactionService.getTransaction(id);
    }*/
   
   @RequestMapping(method=RequestMethod.POST,value="/transaction")
    public void addTransaction(@RequestBody Transaction transaction/*,@RequestParam("payment_method_nonce")String nonce*/) /*throws MessagingException, AddressException, IOException*/{
	
        /*TransactionRequest request = new TransactionRequest()
            .amount(new BigDecimal("10.00"))
            .orderId("order id")
            .merchantAccountId("a_merchant_account_id")
            .paymentMethodNonce(nonce)
            .customer()
            .firstName(traveller.getFirstName())
            .lastName(traveller.getLastName())
            .company("Braintree")
            .phone(traveller.getMobile1())
            .fax("312-555-1235")
            .website()
            .email(traveller.getEmail1())
            .done()
            .billingAddress()
            .firstName()
            .lastName("Smith")
            .company("Braintree")
            .streetAddress(transactions.getBillingAddress1())
            .extendedAddress(transactions.getBillingAddress2())
            .locality(transactions.getBillingCity())
            .region()
            .postalCode(transactions.getBillingPostalCode())
            .countryCodeAlpha2(transactions.getBillingCountry())
            .done()
            .shippingAddress()
            .firstName("Jen")
            .lastName("Smith")
            .company("Braintree")
            .streetAddress("1 E 1st St")
            .extendedAddress("Suite 403")
            .locality("Bartlett")
            .region("IL")
            .postalCode("60103")
            .countryCodeAlpha2("US")
            .done()
            .options()
            .submitForSettlement(true)
            .done();

        Result<Transaction> result = gateway.transaction().sale(request);*/
         
        transactionService.makeTransaction(transaction);
  
    }
   
    @RequestMapping(method=RequestMethod.PUT,value="/updateTransaction")
    public void updateTransction(@RequestBody Transaction transaction){
        transactionService.updateTransaction(transaction);
    }
      
}
