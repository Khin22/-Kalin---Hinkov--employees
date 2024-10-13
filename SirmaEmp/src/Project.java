import java.util.Date;


public class Project {
	private final Date dateFrom;
    private final Date dateTo;

    public Project(Date dateFrom, Date dateTo) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo != null ? dateTo : new Date();
    }
    
    public int getOverlap(Project otherProject) {
        Date thisStart = dateFrom;
        Date thisEnd = dateTo;
        Date otherStart = otherProject.dateFrom;
        Date otherEnd = otherProject.dateTo;

        
        if (thisStart.after(thisEnd)) {
            Date temp = thisStart;
            thisStart = thisEnd;
            thisEnd = temp;
        }

        
        if (otherStart.after(otherEnd)) {
            Date temp = otherStart;
            otherStart = otherEnd;
            otherEnd = temp;
        }

        
        if (thisEnd.before(otherStart) || thisStart.after(otherEnd)) {
            return 0; 
        } else {
            
            long overlapMillis = Math.min(thisEnd.getTime(), otherEnd.getTime()) - Math.max(thisStart.getTime(), otherStart.getTime());
            return (int) (overlapMillis / (24 * 60 * 60 * 1000));
        }
    }
}
