package entinties;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TREE")
@NamedQueries({
        @NamedQuery(name = "Tree.findAll", query = "select t from Tree as t")
})
@Getter
@Setter
public class Tree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "NAME", unique = true, nullable = false)
    private String name;

    @Column(name = "PRICE", nullable = true)
    private double price;

    @ManyToOne
    @JoinColumn(name = "TREE_SPECIES_ID")
    private TreeSpecies treeSpecies;

    @ManyToMany(mappedBy = "trees")
    private List<Order> orders = new ArrayList<>();

    public Tree() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tree tree = (Tree) o;
        return Objects.equals(id, tree.id) &&
                Objects.equals(name, tree.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

}
