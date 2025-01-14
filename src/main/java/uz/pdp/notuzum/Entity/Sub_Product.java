package uz.pdp.notuzum.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sub_product")
@Entity
public class Sub_Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double price;
    private Integer count;
    private Integer available_amount;
    private Integer sold;
    private Integer sold_by_week;
    private Boolean sale;
    private Double sale_price;
    private LocalDate sale_end_date;
    private Integer temp_sale;


}
