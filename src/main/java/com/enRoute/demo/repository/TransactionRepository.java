package com.enRoute.demo.repository;

import com.enRoute.demo.model.Transaction;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author JODY
 */
public interface TransactionRepository extends CrudRepository<Transaction, Long>{
    List<Transaction> findByUserId(long userId);
}
