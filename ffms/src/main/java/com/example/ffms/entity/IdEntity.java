package com.example.ffms.entity;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

/**
 * Base entity with auto-generated Integer ID.
 * All business entities extend this.
 */
@Getter
@Setter
public abstract class IdEntity implements Serializable {

    private Integer id;
}
