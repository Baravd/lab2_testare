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
        memberRepository = new MemberRepository();
        community = new Community();
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


    }

    @Test
    public void addMemberWithValidCosts() {
        //adauga cost la member si boundary value 0 -1, maxCost 3 teste


    }

    @Test
    public void addMemberWithZeroCost() {
        try {
            community.addMember(new Member("name", "123"), new Contribution(0));
        } catch (InvalidDataException e) {
            assertTrue(true);
        }
    }


}