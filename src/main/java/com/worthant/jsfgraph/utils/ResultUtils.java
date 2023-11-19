package com.worthant.jsfgraph.utils;

import com.worthant.jsfgraph.db.DAOFactory;
import com.worthant.jsfgraph.entity.ResultEntity;

public class ResultUtils {

    public static void addResult(final double x) {
        ResultEntity point = new ResultEntity();
        point.setX(x);

        DAOFactory.getInstance().getResultDAO().addNewResult(point);
    }
}
