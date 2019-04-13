package ru.fix.knightstepcounter.models;

import com.fasterxml.jackson.annotation.JsonProperty;

// mix-in annotation abstract class
// helps to deserialize a JSON
// containing Result class instance
public abstract class ResultMixIn {
    ResultMixIn(@JsonProperty("stepCount") int stepCount) {}
}
