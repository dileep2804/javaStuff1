package kuchhbhi;

import java.sql.Timestamp;

public class CampaignMetadataDataPoint {

    private final int pilotId;
    private final String campaignId;
    private final String campaignName;
    private final Timestamp campaignStartTimeStamp;
    private final Timestamp campaignEndTimeStamp;
    private final Timestamp creationTime;
    private final Double earliestPreEventOffsetInHours;

    public CampaignMetadataDataPoint(int pilotId, String campaignId, String campaignName, Timestamp campaignStartTimeStamp, Timestamp campaignEndTimeStamp, Timestamp creationTime, Double earliestOffset) {
        this.pilotId = pilotId;
        this.campaignId = campaignId;
        this.campaignName = campaignName;
        this.campaignStartTimeStamp = campaignStartTimeStamp;
        this.campaignEndTimeStamp = campaignEndTimeStamp;
        this.creationTime = creationTime;
        this.earliestPreEventOffsetInHours = earliestOffset;
    }


    public int getPilotId() {
        return pilotId;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public Timestamp getCampaignStartTimeStamp() {
        return campaignStartTimeStamp;
    }

    public Timestamp getCampaignEndTimeStamp() {
        return campaignEndTimeStamp;
    }

    public Double getEarliestPreEventOffsetInHours() {
        return earliestPreEventOffsetInHours;
    }


    public Timestamp getCreationTime() {
        return creationTime;
    }

    @Override
    public String toString() {
        return "CampaignMetadataDataPoint{" +
                "pilotId=" + pilotId +
                ", campaignId='" + campaignId + '\'' +
                ", campaignName='" + campaignName + '\'' +
                ", campaignStartTimeStamp=" + campaignStartTimeStamp +
                ", campaignEndTimeStamp=" + campaignEndTimeStamp +
                ", creationTime=" + creationTime +
                ", earliestPreEventOffsetInHours=" + earliestPreEventOffsetInHours +
                '}';
    }
}

