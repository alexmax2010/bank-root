package com.base.account.controller;

import javax.validation.constraints.NotBlank;
import com.base.account.service.IAccountService;
import com.base.vo.common.BaseResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ReportController.
 *
 * @author Kruger on 4/8/2024.
 * @version 1.0
 */
@Validated
@Tag(name = "Account", description = "Account API")
@RestController
@RequestMapping("/api/v1/reports")
@Lazy
public class ReportController {

    @Lazy
    @Autowired
    private IAccountService accountService;


    /**
     * Get report accounts.
     *
     * @return report accounts
     */
    @GetMapping(path = "")
    @Operation(summary = "Get accounts")
    public ResponseEntity<BaseResponseVo> get(@RequestParam @NotBlank String personId) {
        return ResponseEntity.ok(
            BaseResponseVo.builder().data(this.accountService.getReport(personId)).build());
    }

}
