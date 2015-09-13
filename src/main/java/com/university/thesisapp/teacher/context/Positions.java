package com.university.thesisapp.teacher.context;

import java.util.Map;

/**
 * Created by Gábor on 2015.09.13..
 */
public class Positions {
    private long maxPositions;
    private long appointedPositions;
    private long openPositions;
    private Map<String, Long> openStudentPositions;

    public long getMaxPositions() {
        return maxPositions;
    }

    public void setMaxPositions(long maxPositions) {
        this.maxPositions = maxPositions;
    }

    public long getAppointedPositions() {
        return appointedPositions;
    }

    public void setAppointedPositions(long appointedPositions) {
        this.appointedPositions = appointedPositions;
    }

    public long getOpenPositions() {
        return openPositions;
    }

    public void setOpenPositions(long openPositions) {
        this.openPositions = openPositions;
    }

    public Map<String, Long> getOpenStudentPositions() {
        return openStudentPositions;
    }

    public void setOpenStudentPositions(Map<String, Long> openStudentPositions) {
        this.openStudentPositions = openStudentPositions;
    }
}
