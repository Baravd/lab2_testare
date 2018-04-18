package repository;

import exceptions.InvalidDataException;
import model.Community;
import model.Entry;
import model.Member;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

public class MemberRepositoryTopDownTest {

    private MemberRepository memberRepository;

    private Community community;

    @Before
    public void setUp()
            throws Exception {
        community = new Community();
        memberRepository = new MemberRepository(community);
    }

    @Test
    public void addMember() {
        int membersCount = memberRepository.getMembers().size();
        try {
            memberRepository.addMember(new Member("nume", " 1"));
        } catch (InvalidDataException e) {
            fail();
        }
        assertEquals(memberRepository.getMembers().size(), membersCount + 1);


    }

    @Test
    public void addMemberEntry() {

        Entry e = new Entry("cost", 200, "1");
        Member member = new Member("nume", " 1");

        int membersCount = memberRepository.getMembers().size();
        int initialEntrySize = memberRepository.getAllEntries().size();
        int size = -1;
        try {
            memberRepository.addMember(member);
            initialEntrySize++;
            memberRepository.addEntry(e);
            size = memberRepository.getAllEntries().size();
        } catch (InvalidDataException exp) {
            fail();
        }
        assertEquals(memberRepository.getMembers().size(), membersCount + 1);


        assertEquals(size, initialEntrySize);


    }

    @Test
    public void addMemberEntryGet() {

        String id = "1";
        Entry e = new Entry("cost", 200, id);
        Member member = new Member("nume", " 1");
        List<Entry> entryForMember = null;

        int membersCount = memberRepository.getMembers().size();
        int initialEntrySize = memberRepository.getAllEntries().size();
        int size = -1;
        try {
            memberRepository.addMember(member);
            initialEntrySize++;
            memberRepository.addEntry(e);
            size = memberRepository.getAllEntries().size();
            entryForMember = memberRepository.getEntryForMember(id);

        } catch (InvalidDataException exp) {
            fail();
        }
        assertEquals(memberRepository.getMembers().size(), membersCount + 1);
        assertEquals(size, initialEntrySize);
        assertSame(entryForMember.get(0), e);


    }
}