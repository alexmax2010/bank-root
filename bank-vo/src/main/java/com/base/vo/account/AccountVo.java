package com.base.vo.account;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * AccountVo.
 *
 * @author Kruger on 3/8/2024.
 * @version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountVo {

    private String accountId;
    private String personId;
    @NotBlank
    private String type;
}
