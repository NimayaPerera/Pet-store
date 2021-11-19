package com.example.petstore;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

@Schema(name = "PetType")
public class PetType {

    @Schema(required = true, description = "PetType id")
    @JsonProperty("PetType_id")
    private Integer PetTypeId;

    @Schema(required = true, description = "PetType type")
    @JsonProperty("PetType_name")
    private String PetTypeName;

    public Integer getPetTypeId() {
        return PetTypeId;
    }

    public void setPetTypeId(Integer PetTypeId) {
        this.PetTypeId = PetTypeId;
    }


    public String getPetTypeName() {
        return PetTypeName;
    }

    public void setPetTypeName(String PetTypeName) {
        this.PetTypeName = PetTypeName;
    }


}
