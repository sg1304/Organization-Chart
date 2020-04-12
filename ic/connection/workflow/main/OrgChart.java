package ic.connection.workflow.main;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class OrgChart {

    private static List<Person> personList;
    private static Map<Long, Person> personMap;
    private static Map<Long, List<Long>> teamMap;
    private static List<Team> teamList;
    private static Map<Long, Organization> organizationMap;

    /** This method takes the the Employee, Team and Organization text files as input and reads it line
     * by line
     */
    public static void readFileInList() {

        try {
            populatePersonal(Files.readAllLines(Paths.get("./Personal.txt"), StandardCharsets.UTF_8));
            populateTeam(Files.readAllLines(Paths.get("./Team.txt"), StandardCharsets.UTF_8));
            populateOrganization(Files.readAllLines(Paths.get("./Organization.txt"), StandardCharsets.UTF_8));
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    /** This method takes each line of text as input and uses "|" as delimiter to populate the
     * personList and personMap
     */
    public static void populatePersonal(List<String> line) {
        personList = new ArrayList<>();
        personMap = new HashMap<>();
        try{
        line.forEach(
                l -> {
                    String s[] = l.split("\\|");
                    Person person = new ic.connection.workflow.main.Person();
                    person.setFirstName(s[0]);
                    person.setLastName(s[1]);
                    person.setPhoneNumber(s[2]);
                    person.setAddress(s[3]);
                    person.setPersonId(Long.valueOf(s[4]));
                    personList.add(person);
                    personMap.put(person.getPersonId(), person);
                }
        );} catch (NullPointerException e){};
    }

    /** This method takes each line of text as input and uses "|" as delimiter to populate the
     * teamList and teamMap
     */
    public static void populateTeam(List<String> line) {
        teamList = new ArrayList<>();
        teamMap = new HashMap<>();
        try {
            line.forEach(
                    l -> {
                        String s[] = l.split("\\|");
                        Team team = new Team();
                        team.setManager(Long.valueOf(s[0]));
                        team.setTeamMember(Long.valueOf(s[1]));
                        teamList.add(team);
                        Long x = Long.valueOf(s[0]);
                        Long y = Long.valueOf(s[1]);
                        if (teamMap.containsKey(x)) {
                            teamMap.get(x).add(y);

                        } else {
                            teamMap.put(x, new ArrayList<>());
                            teamMap.get(x).add(y);
                        }
                    }
            );
        } catch (NullPointerException e) {
        }
    }

    /** This method takes each line of text as input and uses "|" as delimiter to populate the
     * organizationMap
     */
    public static void populateOrganization(List<String> line) {
        organizationMap = new HashMap<>();
        try {
            line.forEach(
                    l -> {
                        String s[] = l.split("\\|");
                        Organization org = new Organization();
                        org.setTitle(s[0]);
                        org.setOrganization(s[1]);
                        org.setPersonId(Long.valueOf(s[2]));
                        organizationMap.put(org.getPersonId(), org);
                    }
            );
        } catch (NullPointerException e) {
        }
    }
    /** This method takes Team and Person objects as inputs and prints the teamMember details
     */
    public static void populateTeamMember(Team team, Person person) {
        try {

            if (team.getManager() == person.getPersonId()) {
                personList.stream().forEach(personal -> {
                    if (personal.getPersonId() == team.getTeamMember()) {
                        System.out.println(personal.getFirstName() + " " + personal.getLastName() +
                                " " + organizationMap.get(personal.getPersonId()).getOrganization()
                                + " " + organizationMap.get(personal.getPersonId()).getTitle()
                                + " " + personal.getPhoneNumber());
                    }
                });
            }
        } catch (NullPointerException e) {
        }
    }


    public static void main(String[] args) {
        readFileInList();

        /** Printing all person's details of input taken from Console which is a person's name
         */
        Optional<Person> person = personList.stream().filter(personal -> {
            if (personal.getFirstName().equalsIgnoreCase(args[0]) ||
                    personal.getLastName().equalsIgnoreCase(args[0])) {
                return true;
            }
            return false;
        }).findFirst();
        System.out.println(person.get().getFirstName() + " " + person.get().getLastName() +
                " " + organizationMap.get(person.get().getPersonId()).getOrganization()
                + " " + organizationMap.get(person.get().getPersonId()).getTitle()
                + " " + person.get().getPhoneNumber()
        );

        /** Printing all details when level is mentioned as 2nd argument which can be when level=1 or level>1
         * else, print details of all levels
          */
        if (args.length > 1) {
            int level = Integer.parseInt(args[1]);
            if (level == 1) {
                teamList.stream().forEach(
                        team -> {
                            populateTeamMember(team, person.get());
                        }
                );
            } else if (level > 1) {
                Long x = person.get().getPersonId();
                Queue<Long> q = new LinkedList<>();
                q.add(x);

                while (!q.isEmpty() && level != 0) {
                    int size = q.size();
                    for (int i = 0; i < size; i++) {
                        Long curr = q.poll();
                        try {
                            for (Long neighbor : teamMap.get(curr)) {
                                System.out.println(personMap.get(neighbor).getFirstName() + " " +
                                        personMap.get(neighbor).getLastName() + " " +
                                        organizationMap.get(neighbor).getTitle() + " " +
                                        organizationMap.get(neighbor).getOrganization() + " " +
                                        personMap.get(neighbor).getPhoneNumber());
                                q.add(neighbor);
                            }
                        } catch (NullPointerException e) {
                        }
                    }
                    level--;
                }
            }
        }
        else {
            Long x = person.get().getPersonId();
            Queue<Long> q = new LinkedList<>();
            q.add(x);
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    Long curr = q.poll();
                    try {
                        for (Long neighbor : teamMap.get(curr)) {
                            System.out.println(personMap.get(neighbor).getFirstName() + " " +
                                    personMap.get(neighbor).getLastName() + " " +
                                    organizationMap.get(neighbor).getTitle() + " " +
                                    organizationMap.get(neighbor).getOrganization() + " " +
                                    personMap.get(neighbor).getPhoneNumber());
                            q.add(neighbor);
                        }
                    } catch (NullPointerException e) {

                    }
                }
            }
        }
    }
}

