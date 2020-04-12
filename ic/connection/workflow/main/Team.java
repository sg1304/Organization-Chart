package ic.connection.workflow.main;

/** This class is intended to create a Team object which takes Manager ID and Team member ID as inputs
 * primary key: (manager, teamMember)
 * Assumption: Every teamMember has one Manager
  */
public class Team {
    
    private long manager;
    
    public long getManager() {
        return manager;
    }
    
    public void setManager(long manager) {
        this.manager = manager;
    }
    
    public long getTeamMember() {
        return teamMember;
    }
    
    public void setTeamMember(long teamMember) {
        this.teamMember = teamMember;
    }
    
    private long teamMember;
    
}
