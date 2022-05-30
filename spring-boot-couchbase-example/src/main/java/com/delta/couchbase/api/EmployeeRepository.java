package com.delta.couchbase.api;

import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.DynamicProxyable;
import org.springframework.data.couchbase.repository.ScanConsistency;
import org.springframework.data.couchbase.repository.Scope;
import org.springframework.stereotype.Repository;

import com.couchbase.client.java.query.QueryScanConsistency;

@Scope("_default")
@Collection("_default")
@Repository
@ScanConsistency(query = QueryScanConsistency.REQUEST_PLUS)
public interface  EmployeeRepository extends CouchbaseRepository<Employee, Integer>, DynamicProxyable<EmployeeRepository>{

}
