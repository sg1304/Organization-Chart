package ic.connection.workflow.main;

/** This class is intended to create an Organization Object which takes title, organization and personID as inputs
 * Assumptions:
 * Primary key: personID i.e Each person corresponds to one organization
 * Each personID should be present in Person table
 */

public class Organization {
    private String title;
    private String organization;
    private long personId;
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getOrganization() {
        return organization;
    }
    
    public void setOrganization(String organization) {
        this.organization = organization;
    }
    
    public long getPersonId() {
        return personId;
    }
    
    public void setPersonId(long personId) {
        this.personId = personId;
    }
}
