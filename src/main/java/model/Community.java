package model;

import exceptions.InvalidDataException;

import java.util.HashMap;
import java.util.Map;

public class Community {

    private Map<Member, Contribution> membersContributionMap;


    public Community() {
        membersContributionMap = new HashMap<>();
    }


    //default contribution should be 0 not null
    public void addMember(Member member)
            throws InvalidDataException {
        membersContributionMap.put(member, new Contribution(0));
    }

    public void addMember(Member member, Contribution contribution)
            throws InvalidDataException {


        if (contribution == null) {
            throw new InvalidDataException("contribution or sum must not be null");

        } else if (contribution.getSum() < 1) {
            throw new InvalidDataException("Contribution must greater or equal to 1");

        }
        membersContributionMap.put(member, contribution);

    }

    public Integer getNrMembers() {
        return membersContributionMap.size();
    }


}
