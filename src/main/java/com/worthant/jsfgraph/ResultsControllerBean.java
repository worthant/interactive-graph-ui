package com.worthant.jsfgraph;

import com.worthant.jsfgraph.db.DAOFactory;
import com.worthant.jsfgraph.entity.ResultEntity;
import com.worthant.jsfgraph.utils.ResultUtils;
import jakarta.annotation.PostConstruct;

import java.io.Serializable;
import java.util.ArrayList;

public class ResultsControllerBean implements Serializable {
    private XBean xBean;

    @PostConstruct
    public void init() {
        var resultsEntities = DAOFactory.getInstance().getResultDAO().getAllResults();
        results = new ArrayList<>(resultsEntities.stream().map(ResultEntity::getX).toList());
    }

    private ArrayList<Double> results = new ArrayList<>();

    public void addResult(Double x) {
        results.add(x);
        // add to db
        ResultUtils.addResult(x);
    }

    public XBean getXBean() {
        return xBean;
    }

    public void setxBean(XBean xBean) {
        this.xBean = xBean;
    }

    public void setXBean(XBean xBean) {
        this.xBean = xBean;
    }

    public ArrayList<Double> getResults() {
        return results;
    }

    public void setResults(ArrayList<Double> results) {
        this.results = results;
    }
}

