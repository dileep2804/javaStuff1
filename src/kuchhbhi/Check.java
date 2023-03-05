package kuchhbhi;

import java.sql.Timestamp;

public class Check {
    public static void main(String[] args) {
        int decMidTime = 1672159800; // 27 December 2022 22:20:00 GMT+05:30
        int febBeginTime = 1675189800; // 1 February 2023 00:00:00 GMT+05:30
        int febMidTime = 1677153298; // 23 February 2023 11:54:58 GMT+05:30
        int febEndTime = 1677608999; // 28 February 2023 23:59:59 GMT+05:30
        int aprilBeginTime = 1680287400; // 1 April 2023 00:00:00 GMT+05:30
        int aprilEndTime = 1682879399; // 30 April 2023 23:59:59 GMT+05:30

        CampaignMetadataDataPoint campaignMetadataDataPoint1 = new CampaignMetadataDataPoint(1000,
                "campaign_1",
                "CPP-1",
                new Timestamp(decMidTime * 1000L),
                new Timestamp(febBeginTime * 1000L),
                new Timestamp(decMidTime * 1000L),
                0.0D);

        CampaignMetadataDataPoint campaignMetadataDataPoint2 = new CampaignMetadataDataPoint(1000,
                "campaign_1",
                "CPP-1",
                new Timestamp(febMidTime * 1000L),
                new Timestamp(febEndTime * 1000L),
                new Timestamp(decMidTime * 1000L),
                0.0D);

        CampaignMetadataDataPoint campaignMetadataDataPoint3 = new CampaignMetadataDataPoint(1000,
                "campaign_1",
                "CPP-1",
                new Timestamp(aprilBeginTime * 1000L),
                new Timestamp(aprilEndTime * 1000L),
                new Timestamp(decMidTime * 1000L),
                0.0D);

        CampaignStatus campaignStatus = null;
        campaignStatus = (campaignStatus == null || campaignStatus.equals(CampaignStatus.ALL)) ? getCampaignStatus(campaignMetadataDataPoint3) : campaignStatus;

        System.out.println(campaignStatus);
    }

    protected static CampaignStatus getCampaignStatus(CampaignMetadataDataPoint campaignMetadata) {
//        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone(DateUtils.UTC_TIMEZONE));
//        long nowTs = cal.getTimeInMillis();

        long nowTs = System.currentTimeMillis();
        if (campaignMetadata.getCampaignEndTimeStamp().getTime() < nowTs) {
            return CampaignStatus.COMPLETED;

        } else if (nowTs < (campaignMetadata.getCampaignStartTimeStamp().getTime()
                - campaignMetadata.getEarliestPreEventOffsetInHours() * 3600 * 1000L)) {
            return CampaignStatus.SCHEDULED;

        } else {
            return CampaignStatus.ONGOING;
        }
    }
}