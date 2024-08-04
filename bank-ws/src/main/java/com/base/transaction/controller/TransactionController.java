package com.base.transaction.controller;

import javax.validation.Valid;
import com.base.transaction.service.ITransactionService;
import com.base.vo.common.BaseResponseVo;
import com.base.vo.transaction.TransactionRegVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TransactionController.
 *
 * @author Kruger on 4/8/2024.
 * @version 1.0
 */
@Validated
@Tag(name = "Transaction", description = "Transaction API")
@RestController
@RequestMapping("/api/v1/transactions")
@Lazy
public class TransactionController {

    @Lazy
    @Autowired
    private ITransactionService service;

    /**
     * Save Transaction.
     *
     * @param request Transaction
     * @return Transaction saved in db
     */
    @PostMapping
    @Operation(summary = "Save transaction")
    public ResponseEntity<BaseResponseVo> save(@Valid @RequestBody TransactionRegVo request) {
        return ResponseEntity.ok(this.service.save(request));
    }
}
