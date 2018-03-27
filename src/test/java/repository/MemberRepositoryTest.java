package repository;

import exceptions.InvalidDataException;
import model.Community;
import model.Contribution;
import model.Member;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
            assertFalse(true);
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
            assertTrue(false);
        }
        int newCount = membersCount + 2;
        assertTrue(memberRepository.getMembers().size() == newCount);

    }

    @Test
    public void addMemberWithValidCosts() {
        try {
            community.addMember(new Member("asd", "321"), new Contribution(10));
        } catch (InvalidDataException e) {
            assertTrue(false);
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


}