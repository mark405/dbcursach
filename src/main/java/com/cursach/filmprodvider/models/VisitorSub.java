package com.cursach.filmprodvider.models;

/**
 * @author mark
 */
public class VisitorSub {
    private String sub;
    private String visitor;
    private String start;
    private String end;
    private String status;

    public void setSub(String sub) {
        this.sub = sub;
    }

    public void setVisitor(String visitor) {
        this.visitor = visitor;
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

    public String getSub() {
        return sub;
    }

    public String getVisitor() {
        return visitor;
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
