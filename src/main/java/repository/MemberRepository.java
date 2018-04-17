package repository;

import exceptions.InvalidDataException;
import model.Community;
import model.Entry;
import model.Member;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MemberRepository {

    private List<Member> members = new ArrayList<Member>();

    private List<Entry> entries = new ArrayList<Entry>();

    private final static String filenameMember = "membersF.txt";

    private final static String filenameBudget = "budgetF.txt";

    private Community community;

    public MemberRepository(Community community) {
        this.community = community;
        init();
    }

    @SuppressWarnings("resource")
    public MemberRepository() {

        init();
    }

    private void init() {
        try {
            FileReader fileReader = null;
            BufferedReader bufferedReader = null;
            String currentLine = null;

            fileReader = new FileReader(filenameMember);
            bufferedReader = new BufferedReader(fileReader);

            while ((currentLine = bufferedReader.readLine()) != null) {
                String line[] = currentLine.split(";");
                Member m = new Member(line[0], line[1]);
                this.members.add(m);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        try {
            FileReader fileReaderEntry = null;
            BufferedReader bufferedReaderEntry = null;
            String currentLineEntry = null;

            fileReaderEntry = new FileReader(filenameMember);
            bufferedReaderEntry = new BufferedReader(fileReaderEntry);

            while ((currentLineEntry = bufferedReaderEntry.readLine()) != null) {
                String line[] = currentLineEntry.split(";");
                int valueEntry = Integer.parseInt(line[1]);
                String idEntryMember = line[2];
                Entry e = new Entry(line[0], valueEntry, idEntryMember);
                this.entries.add(e);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void addMember(Member m)
            throws InvalidDataException {
        if (m == null) {
            throw new InvalidDataException("Memeber must not be null");

        }
        members.add(m);
    }

    public void addEntry(Entry e)
            throws InvalidDataException {
        if (e == null) {//1
            throw new InvalidDataException("Entry must not be null");//2
        }
        if (e.getIdMember() == null) {
            throw new InvalidDataException("IdMember must not be null");//3
        }
        if (e.getValue() == null) {//4
            throw new InvalidDataException("Value must not be null");//5

        } else if (e.getValue() <= 0) {
            throw new InvalidDataException("Value must be greater than 0");//6

        }
        entries.add(e);//7
    }

    public List<Entry> getAllEntries() {

        return entries;
    }

    List<Member> getMembers() {
        return members;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public static String getFilenameMember() {
        return filenameMember;
    }

    public static String getFilenameBudget() {
        return filenameBudget;
    }
}
