package com.macoli.scbremotetest.repository;

import java.util.ArrayList;
import java.util.List;

public class ResultRepository {
    private ResultRepository() {}
    public static ResultRepository getInstance() {
        return HOLDER.instance ;
    }

    private List<String> resultList = new ArrayList<>() ;

    public List<String> getResultList() {
        return resultList ;
    }

    public void addResult(String result) {
        resultList.add(result) ;
    }

    private static class HOLDER {
        public static final ResultRepository instance = new ResultRepository() ;
    }
}
