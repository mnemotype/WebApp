package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.Customer;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;
    
        
    @Override
    @Transactional
    public List<Customer> getCustomers() {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        //create a query
        Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
        // exeture query and get result list
        List<Customer> customers = theQuery.getResultList();
        // return result        
        return customers;        
    }

    
}
