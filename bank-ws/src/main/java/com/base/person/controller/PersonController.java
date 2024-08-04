package com.base.person.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import com.base.person.service.IPersonService;
import com.base.vo.common.BaseResponseVo;
import com.base.vo.person.PersonUpdateVo;
import com.base.vo.person.PersonVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PersonController.
 *
 * @author alex on 8/9/2022.
 * @version 1.0
 */
@Validated
@Tag(name = "Person", description = "The Persons API")
@RestController
@RequestMapping("/api/v1/persons")
@Lazy
public class PersonController {

    @Lazy
    @Autowired
    private IPersonService service;

    /**
     * Save Person.
     *
     * @param request person
     * @return PersonVo saved in db
     */
    @PutMapping
    @Operation(summary = "Save Person")
    public ResponseEntity<BaseResponseVo> save(@Valid @RequestBody PersonVo request) {
        if (this.service.exist(request.getPersonId())) {
            return ResponseEntity.ok(BaseResponseVo.builder().code(1).build());
        }
        this.service.save(request);
        return ResponseEntity.ok(BaseResponseVo.builder().build());
    }

    /**
     * Get person.
     *
     * @return personVo
     */
    @GetMapping(path = "/{personId}")
    @Operation(summary = "Get person")
    public ResponseEntity<BaseResponseVo> get(@PathVariable @NotBlank String personId) {
        return ResponseEntity.ok(BaseResponseVo.builder().data(this.service.get(personId)).build());
    }

    /**
     * Update person values.
     *
     * @return personVo
     */
    @PatchMapping(path = "")
    @Operation(summary = "Update person values")
    public ResponseEntity<BaseResponseVo> updateValues(@Valid @RequestBody PersonUpdateVo request) {
        this.service.updateValues(request);
        return ResponseEntity.ok(BaseResponseVo.builder().build());
    }

    /**
     * Update person values.
     *
     * @return personVo
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete person")
    public ResponseEntity<BaseResponseVo> delete(@PathVariable("id") @NotBlank String id) {
        this.service.delete(id);
        return ResponseEntity.ok(BaseResponseVo.builder().build());
    }
}
