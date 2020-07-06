package dk.apaq.dinero.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum UnitType {
    @JsonProperty("hours")
    Hours,

    @JsonProperty("parts")
    Parts,

    @JsonProperty("km")
    Km,

    @JsonProperty("day")
    Day,

    @JsonProperty("week")
    Week,

    @JsonProperty("month")
    Month,

    @JsonProperty("kilogram")
    Kilogram,

    @JsonProperty("cubicMetre")
    CubicMetre,

    @JsonProperty("set")
    Set,

    @JsonProperty("litre")
    Litre,

    @JsonProperty("box")
    Box,

    @JsonProperty("case")
    Case,

    @JsonProperty("carton")
    Carton,

    @JsonProperty("metre")
    Metre,

    @JsonProperty("package")
    Package,

    @JsonProperty("shipment")
    Shipment,

    @JsonProperty("squareMetre")
    SquareMetre,

    @JsonProperty("session")
    Session,

    @JsonProperty("tonne")
    Tonne
}
