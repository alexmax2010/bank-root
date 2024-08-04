package com.base.vo.account;

import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotBlank;
import com.base.vo.transaction.TransactionVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * AccountVo.
 *
 * @author alex on 3/8/2024.
 * @version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountVo {

    private Integer accountId;
    @NotBlank
    private String personId;
    @NotBlank
    private String type;
    private BigDecimal initialBalance;
    private List<TransactionVo> transactions;
}
