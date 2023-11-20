package co.empresa.banco.modelo;

package co.empresa.banco.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable {
    private Long id;
    private Date dateBill;
    private Integer userId;
    private BigDecimal value;
    private Integer type;
    private String observation;



    
    
}

