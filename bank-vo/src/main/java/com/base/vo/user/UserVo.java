package com.base.vo.user;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {

    private String userId;
    private String personId;
    @NotBlank
    private String userName;
    @NotBlank
    private String password;
}
