package com.base.vo.transaction;

import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TransactionRegVo.
 *
 * @author Kruger on 4/8/2024.
 * @version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRegVo {

    private String transactionId;
    @NotNull
    private Integer accountId;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT-5")
    private Date date;
    @NotNull
    @Positive
    private BigDecimal movement;
    @NotBlank
    private String type;
}
