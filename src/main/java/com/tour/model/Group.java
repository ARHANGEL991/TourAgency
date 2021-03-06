package com.tour.model;

import com.tour.model.interfaces.IGroup;
import com.tour.model.interfaces.IGuide;
import com.tour.model.interfaces.ITour;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "group_tour")
public class Group implements IGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @ManyToOne
    private Guide guide;

    @ManyToOne
    private Tour tour;

    @JoinTable(
            name = "group_user",
            joinColumns = @JoinColumn(
                    name = "group_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "users_id",
                    referencedColumnName = "id"
            )
    )
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Tourist> tourists;


    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }

    @Override
    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    @Override
    public Set<Tourist> getTourists() {
        return tourists;
    }

    public void setTourists(Set<Tourist> tourists) {
        this.tourists = tourists;
    }
}
