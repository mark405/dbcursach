package com.cursach.filmprodvider.models;

/**
 * @author mark
 */
public class VisitorSub {
    private int SubID;
    private int VisitorID;
    private String start;
    private String end;
    private String status;

    public void setSubID(int subID) {
        SubID = subID;
    }

    public void setVisitorID(int visitorID) {
        VisitorID = visitorID;
    }

    public void setStart(final String start) {
        this.start = start;
    }

    public void setEnd(final String end) {
        this.end = end;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public int getSubID() {
        return SubID;
    }

    public int getVisitorID() {
        return VisitorID;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public String getStatus() {
        return status;
    }
}
