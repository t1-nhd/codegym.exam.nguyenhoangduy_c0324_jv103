package codegym.nguyenhoangduy_c0324_m4_finalexam.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;
    private String name;

    @OneToMany(mappedBy = "category")
    List<Product> products = new ArrayList<Product>();
}
