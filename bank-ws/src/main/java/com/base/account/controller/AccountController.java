package com.base.account.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import com.base.account.service.IAccountService;
import com.base.vo.account.AccountVo;
import com.base.vo.common.BaseResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AccountController.
 *
 * @author Kruger on 4/8/2024.
 * @version 1.0
 */
@Validated
@Tag(name = "Account", description = "Account API")
@RestController
@RequestMapping("/api/v1/accounts")
@Lazy
public class AccountController {

    @Lazy
    @Autowired
    private IAccountService service;

    /**
     * Save Account.
     *
     * @param request AccountVo
     * @return AccountVo saved in db
     */
    @PostMapping
    @Operation(summary = "Save account")
    public ResponseEntity<BaseResponseVo> save(@Valid @RequestBody AccountVo request) {
        if (this.service.exist(request.getPersonId(), request.getType())) {
            return ResponseEntity.ok(BaseResponseVo.builder().code(1).build());
        }
        this.service.save(request);
        return ResponseEntity.ok(BaseResponseVo.builder().data(request).build());
    }

    /**
     * Get accounts.
     *
     * @return list accounts
     */
    @GetMapping(path = "/{personId}")
    @Operation(summary = "Get accounts")
    public ResponseEntity<BaseResponseVo> get(@PathVariable @NotBlank String personId) {
        return ResponseEntity.ok(BaseResponseVo.builder().data(this.service.get(personId)).build());
    }

}
