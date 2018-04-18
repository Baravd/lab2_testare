package controller;

import exceptions.InvalidDataException;
import model.Entry;
import model.Member;
import repository.MemberRepository;

import java.util.ArrayList;
import java.util.List;

public class MemberController {

    private MemberRepository mr;

    public MemberController(MemberRepository newMr) {
        this.mr = newMr;
    }

    public void addMember(Member aMemebr) {
        try {
            mr.addMember(aMemebr);
        } catch (InvalidDataException e) {
            e.printStackTrace();
        }
    }

    public void addEntry(Entry oneEntry)
            throws InvalidDataException {
        mr.addEntry(oneEntry);
    }

    public List<Entry> allEntries() {


        List<Entry> allE = new ArrayList<>();
        allE = this.mr.getAllEntries();
        return allE;
    }
} 