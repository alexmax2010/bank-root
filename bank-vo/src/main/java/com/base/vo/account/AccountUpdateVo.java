package com.base.vo.account;

import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * AccountUpdateVo.
 *
 * @author Kruger on 4/8/2024.
 * @version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountUpdateVo {

    @NotNull
    private Integer accountId;
    @NotBlank
    private String personId;
    @NotBlank
    private String type;
    @NotNull
    private BigDecimal initialBalance;
}
