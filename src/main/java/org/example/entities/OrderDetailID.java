package org.example.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable //= id composite
@Data
public class OrderDetailID implements Serializable {

    private static final long serialVersionID = 1L;
    private long orderId;
    private long productId;
}
