package codegym.nguyenhoangduy_c0324_m4_finalexam.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int price;
    private String status;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
