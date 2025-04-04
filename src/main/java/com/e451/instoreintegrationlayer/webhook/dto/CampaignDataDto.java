package com.e451.instoreintegrationlayer.webhook.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CampaignDataDto {

    @NotBlank
    private String name;

    @NotBlank(message = "Account ID is required")
    private String accountId;

    @NotEmpty(message = "At least one brand ID is required")
    private List<@NotBlank String> brandIds;

    @NotNull(message = "isAgencyInvolved must not be null")
    // Not Using primitive type - can't tell if client omitted it or intentionally set it to false
    private Boolean isAgencyInvolved;

    @Valid
    private AgencyDto agency;

    @Valid
    @NotNull
    private FlightDatesDto flightDates;

    @NotNull
    @DecimalMin(value = "0.01", message = "Budget must be greater than 0")
    private BigDecimal budget;

    @NotNull(message = "optInCreative must not be null")
    // Not Using primitive type - can't tell if client omitted it or intentionally set it to false
    private Boolean optInCreative;
    private String creativeTier;

    private String insertionOrder;
    private String purchaseOrder;

    @NotEmpty(message = "Salesforce Project Number is required")
    private String sfPrjId;

    @NotNull
    @Size(min = 2, message = "At least two touch-points are required")
    private List<@Valid TouchpointDto> touchpoints;

    @NotBlank(message = "Status is required")
    private String status;

    /**
     * Conditional validations: These are class-level constraints and Bean validator looks for
     * @AssertTrue or @AssertFalse when validating the CampaignDto object
     */
    @AssertTrue(message = "Agency must be involved if isAgencyInvolved is true")
    public boolean validateAgencyPresence() {
        return !Boolean.TRUE.equals(isAgencyInvolved)
                || (agency != null && StringUtils.hasText(agency.getId()));
    }

    @AssertTrue(message = "CreativeTier must be provided if optInCreative is true")
    public boolean validateCreativeTier() {
        return !Boolean.TRUE.equals(optInCreative) || StringUtils.hasText(creativeTier);
    }
}
