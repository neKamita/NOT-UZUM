package uz.pdp.notuzum.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.notuzum.Enums.Delivery;
import uz.pdp.notuzum.Enums.Payment;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "basket")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long user_id;
    private Boolean is_active;
    private Integer price;
    private Integer branch_id;
    private Integer address_id;
    private Delivery delivery_type;
    private Payment payment_type;
}
