package ic.connection.workflow.test;

import ic.connection.workflow.main.OrgChart;
import ic.connection.workflow.main.Person;
import ic.connection.workflow.main.Team;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class OrgChartTest extends TestCase {

    private static List<Person> personList;
    private static List<Team> teamList;

    @Test
    /** TestCase for populatePersonal() to check for inputs
     */
    public void testPopulatePersonal() throws IOException {
        OrgChart orgChart = mock(OrgChart.class);
        List<String> testList = new ArrayList<>();
        testList.add("John|Doe|111-111-1111|1 main|1000");
        orgChart.populatePersonal(testList);

        verify(orgChart).populatePersonal(eq(testList));
    }
    @Test
    /** TestCase for populatePersonal() to check for null-valued inputs
     */
    public void testPopulatePersonalWithNullValues() {
        OrgChart orgChart = mock(OrgChart.class);
        List<String> testList = new ArrayList<>();
        testList.add(null);
        orgChart.populatePersonal(testList);

        verify(orgChart).populatePersonal(eq(testList));
    }

    @Test
    /** TestCase for populateTeam() to check for inputs
     */
    public void testPopulateTeam() {
        OrgChart orgChart = mock(OrgChart.class);
        List<String> testList = new ArrayList<>();
        testList.add("999|1000");
        orgChart.populateTeam(testList);

        verify(orgChart).populateTeam(eq(testList));
    }
    @Test
    /** TestCase for populateTeam() to check for null-values inputs
     */
    public void testPopulateTeamWithNullValues() {
        OrgChart orgChart = mock(OrgChart.class);
        List<String> testList = new ArrayList<>();
        testList.add(null);
        orgChart.populateTeam(testList);

        verify(orgChart).populateTeam(eq(testList));
    }

    @Test
    /** TestCase for populateOrganization() to check for inputs
     */
    public void testPopulateOrganization() {
        OrgChart orgChart = mock(OrgChart.class);
        List<String> testList = new ArrayList<>();
        testList.add("Manager|PE|1000");
        orgChart.populateOrganization(testList);

        verify(orgChart).populateOrganization(eq(testList));
    }

    @Test
    /** TestCase for populateOrganization() to check for null-valued inputs
     */
    public void testPopulateOrganizationWithNullValues() {
        OrgChart orgChart = mock(OrgChart.class);
        List<String> testList = new ArrayList<>();
        testList.add(null);
        orgChart.populateOrganization(testList);

        verify(orgChart).populateOrganization(eq(testList));
    }

    @Test
    /** TestCase for populateTeamMember() to check if the expected and actual printed values match
     */
    public void testPopulateTeamMember() throws IOException {
        OrgChart orgChart = new OrgChart();
        Team team = new Team();
        List<String> testList = new ArrayList<>();
        testList.add("John|Doe|111-111-1111|1 main|1000");
        List<String> testOrganization = new ArrayList<>();
        testOrganization.add("Manager|PE|1000");
        personList = new ArrayList<>();
        teamList = new ArrayList<>();
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setPhoneNumber("111-111-1111");
        person.setAddress("1 main");
        person.setPersonId(1000);
        personList.add(person);
        team.setManager(1000);
        team.setTeamMember(1000);
        teamList.add(team);
        orgChart.populatePersonal(testList);
        orgChart.populateOrganization(testOrganization);
        if (team.getManager() == person.getPersonId()) {
           if (personList.get(0).getPersonId() == team.getTeamMember()) {
                ByteArrayOutputStream outContent = new ByteArrayOutputStream();
                System.setOut(new PrintStream(outContent));
                orgChart.populateTeamMember(team, person);
                assertEquals("John Doe PE Manager 111-111-1111 ".trim(), outContent.toString().trim());
            }
        }}}


