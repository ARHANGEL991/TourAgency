package com.tour.model;

import com.tour.model.interfaces.ITourist;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@DiscriminatorValue(value = "TOURIST")
public class Tourist extends BaseUser implements ITourist {


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "group_user",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )

    private Set<Group> groups;

    public Tourist(String userName, String password, String firstName, String lastName, boolean active, String email, String confirmPassword, Set<Role> roles, Set<Group> groups) {
        super(userName, password, firstName, lastName, active, email, confirmPassword, roles);
        this.groups = groups;
    }

    public Tourist() {
        super();
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void addGroup(Group group){
        if (groups == null){
            groups = new HashSet<>();

        }
        groups.add(group);
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }


}
