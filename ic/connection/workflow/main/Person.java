
package ic.connection.workflow.main;

/** This class is intended to create a person object
 * Assumption: personID is unique
 * primary key : personID
 */
public class Person {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private long personId;
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public long getPersonId() {
        return personId;
    }
    
    public void setPersonId(long personId) {
        this.personId = personId;
    }
}
