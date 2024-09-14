package com.mycompany.app.utils.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mycompany.app.model.FaultDetails;

import java.util.List;

/**
 * JacksonMapper class.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class JacksonMapper {

    /**
     * Response code.
     */
    private int response_code;

    /**
     * Results.
     */
    private List<FaultDetails> results;

    /**
     * Get response code.
     */
    public int getResponseCode() {
        return response_code;
    }

    /**
     * Get results.
     */
    public List<FaultDetails> getResults() {
        return results;
    }
}
