package uz.pdp.notuzum.Enums;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Table(name = "payment")
public enum Payment {
    CASH,
    CARD,
    INSTALLMENT
}
