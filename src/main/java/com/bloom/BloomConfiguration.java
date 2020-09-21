package com.bloom;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotEmpty;

public class BloomConfiguration extends Configuration {
    @NotEmpty
    private String defaultName;

    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String name) {
        this.defaultName = name;
    }
}
