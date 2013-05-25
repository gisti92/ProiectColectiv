/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.director;

import java.util.Date;

/**
 *
 * @author Artiom.Casapu
 */
public class TimeInterval {

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
    
    private Date start;
    private Date end;
    
    
    
}
