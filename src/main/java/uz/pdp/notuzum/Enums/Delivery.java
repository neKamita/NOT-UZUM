package uz.pdp.notuzum.Enums;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Table(name = "delivery")
public enum Delivery {
    BY_COURIER,
    TO_BRANCH,
}
