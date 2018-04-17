package repository;

import exceptions.InvalidDataException;
import model.Community;
import model.Contribution;
import model.Entry;
import model.Member;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class MemberRepositoryTest {

    private MemberRepository memberRepository;

    private Community community;


    @Before
    public void init() {
        community = new Community();
        memberRepository = new MemberRepository(community);
    }

    @Test
    public void addValidMember() {
        int membersCount = memberRepository.getMembers().size();
        try {
            memberRepository.addMember(new Member("nume", " 1"));
        } catch (InvalidDataException e) {
            fail();
        }
        assertEquals(memberRepository.getMembers().size(), membersCount + 1);


    }

    //acest test pica inainte
    @Test
    public void addInvalidMember() {
        int membersCount = memberRepository.getMembers().size();
        try {
            memberRepository.addMember(null);
        } catch (InvalidDataException e) {
            assertTrue(true);
        }

    }

    @Test
    public void addMemberWithNoName() {
        int membersCount = memberRepository.getMembers().size();
        try {
            memberRepository.addMember(new Member(null, "id"));
        } catch (InvalidDataException e) {
            assertTrue(true);
        }

    }

    @Test
    public void addMemberWithNoId() {
        int membersCount = memberRepository.getMembers().size();
        try {
            memberRepository.addMember(new Member("nume", null));
        } catch (InvalidDataException e) {
            assertTrue(true);
        }

    }

    //check if lower case same as upper case
    @Test
    public void addMemberWithLowerCaseId() {
        int membersCount = memberRepository.getMembers().size();
        try {
            memberRepository.addMember(new Member("nume", "ASD"));
            memberRepository.addMember(new Member("nume", "asd"));
        } catch (InvalidDataException e) {
            fail();
        }
        int newCount = membersCount + 2;
        assertEquals(memberRepository.getMembers().size(), newCount);

    }

    @Test
    public void addMemberWithValidCosts() {
        try {
            community.addMember(new Member("asd", "321"), new Contribution(10));
        } catch (InvalidDataException e) {
            fail();
        }
    }

    @Test
    public void addMemberWithZeroCost() {
        try {
            community.addMember(new Member("name", "123"), new Contribution(0));
        } catch (InvalidDataException e) {
            assertTrue(true);
        }
    }

    @Test
    public void addMemberWithNegativeCost() {
        try {
            community.addMember(new Member("name", "123"), new Contribution(-1));
        } catch (InvalidDataException e) {
            assertTrue(true);
        }
    }

    @Test
    public void addMemberExceedingMaxCost() {
        try {
            community.addMember(new Member("name", "123"), new Contribution(Contribution.MAX_SUM + 1));
        } catch (InvalidDataException e) {
            assertTrue(true);
        }
    }

    @Test
    public void addNullEntryTest() {
        Entry e = null;
        try {
            memberRepository.addEntry(e);
            fail();
        } catch (InvalidDataException e1) {
            e1.printStackTrace();
        }
    }

    @Test
    public void addValidEntry() {
        int initialSize = memberRepository.getAllEntries().size();
        initialSize++;
        Member m = new Member("name", "1");
        Entry e = new Entry("cost", 200, "1");
        try {
            memberRepository.addEntry(e);
            int size = memberRepository.getAllEntries().size();
            assertEquals(size, initialSize);
        } catch (InvalidDataException e1) {
            e1.printStackTrace();
        }

    }
    @Test
    public void addEntryWithInvalidValue() {

        Member m = new Member("name", "1");
        Entry e = new Entry("cost", 0, "1");
        try {
            memberRepository.addEntry(e);
            fail();
        } catch (InvalidDataException e1) {
            e1.printStackTrace();
        }

    }
    @Test
    public void addEntryWithNoCost() {

        Member m = new Member("name", "1");
        Entry e = new Entry(null, 200, "1");
        try {
            memberRepository.addEntry(e);
            fail();
        } catch (InvalidDataException e1) {
            e1.printStackTrace();
        }

    }



}