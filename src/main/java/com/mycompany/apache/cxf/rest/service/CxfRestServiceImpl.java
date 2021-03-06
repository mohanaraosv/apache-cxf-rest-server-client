
package com.mycompany.apache.cxf.rest.service;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.apache.cxf.rest.dao.CustomerDao;
import com.mycompany.apache.cxf.rest.model.Customer;
import com.mycompany.apache.cxf.rest.ws.CxfRestService;

@Service("customerServiceImpl")
public class CxfRestServiceImpl implements CxfRestService {

    private final CustomerDao customerDao;

    @Autowired
    public CxfRestServiceImpl(final CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public Response getCustomerDetail(final String customerId) {
        if (customerId == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok(customerDao.getCustomerDetails(customerId)).build();
    }

    @Override
    public Response createCustomer(final Customer customer) {
        if (customer == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok(customerDao.createCustomer(customer)).build();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.mycompany.apache.cxf.rest.ws.CxfRestService#testCustomObject(java.lang.String)
     */
    @Override
    public Customer testCustomObject(final String customerId) {
        return customerDao.getCustomerDetails(customerId);
    }
}