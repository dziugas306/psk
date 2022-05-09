package entinties;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "TreeSpecies.findAll", query = "select s from TreeSpecies as s")
})
@Table(name = "TREE_SPECIES")
@Getter
@Setter
public class TreeSpecies implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "NAME", unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "treeSpecies", cascade = CascadeType.REMOVE)
    private List<Tree> trees = new ArrayList<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeSpecies treeSpecies = (TreeSpecies) o;
        return Objects.equals(id, treeSpecies.id) &&
                Objects.equals(name, treeSpecies.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

}
