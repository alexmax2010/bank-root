package com.base.vo.person;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * PersonUpdateVo.
 *
 * @author alex on 3/8/2024.
 * @version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonUpdateVo {

    @NotBlank
    private String personId;
    @NotBlank
    private String address;
    @NotBlank
    private String phone;
    @NotBlank
    private String gender;
}
