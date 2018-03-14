package repository;

import exceptions.InvalidDataException;
import model.Member;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MemberRepositoryTest {

    private MemberRepository memberRepository;

    @Before
    public void init() {
        memberRepository = new MemberRepository();
    }

    @org.junit.Test
    public void addValidMember() {
        int membersCount = memberRepository.getMembers().size();
        memberRepository.addMember(new Member("nume", " 1"));
        assertEquals(memberRepository.getMembers().size(), membersCount + 1);




    }
    /*@Test(expected = InvalidDataException.class)
    public void  addInvalidMember() {
        int membersCount = memberRepository.getMembers().size();
        memberRepository.addMember(new Member("nume", null));

    }*/
}