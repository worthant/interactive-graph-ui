package com.example.eclipselinkormjsfdemo.worthant.jsfgraph.utils;

import com.example.eclipselinkormjsfdemo.worthant.jsfgraph.db.DAOFactory;
import com.example.eclipselinkormjsfdemo.worthant.jsfgraph.entity.ResultEntity;

public class ResultUtils {

    public static void addResult(final double x) {
        ResultEntity point = new ResultEntity();
        point.setX(x);

        DAOFactory.getInstance().getResultDAO().addNewResult(point);
    }
}
