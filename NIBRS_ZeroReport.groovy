import java.nio.file.Files;
import java.time.LocalDate;
import java.time.LocalDateTime;
import static java.time.temporal.TemporalAdjusters.*;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.sql.Timestamp;
import java.nio.file.Path;
import java.io.FileWriter;
import java.io.PrintWriter;
import com.sustain.mail.Attachments;
import org.json.JSONArray;
import org.json.JSONObject;
import com.sustain.entities.custom.CtInterfaceTracking;
import com.sustain.entities.custom.CtInterfaceTrackingDetail;

// ZoneId is set to local value, America/Los_Angeles, for testing; the validation applicaiton xcota will fail a filing if the datatime is ahead of the local time

String internalTesting = SystemProperty.getValue("nibrs.email.testing");
internalTesting = internalTesting == null || internalTesting.isEmpty() ? "true" : internalTesting;
String ucrstatEmailAddress = internalTesting == "true" ? SystemProperty.getValue("nibrs.email.inbox.test") : SystemProperty.getValue("nibrs.email.inbox");
logger.debug("internalTesting:${internalTesting}; ucrstatEmailAddress:${ucrstatEmailAddress}");
String ucrstatEmailAddressCC = SystemProperty.getValue("nibrs.email.inbox.cc");

LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("America/Los_Angeles")).minusDays(1L);
LocalDate localDate = localDateTime.toLocalDate();
LocalDateTime localDateTimeStart = localDateTime.with(firstDayOfMonth()).withHour(0).withMinute(0).withSecond(0).withNano(0);
LocalDateTime localDateTimeEnd = localDateTime.with(lastDayOfMonth()).withHour(23).withMinute(59).withSecond(58).withNano(999999999);
logger.debug("report date range: localDateTimeStart:${localDateTimeStart}; localDateTimeEnd:${localDateTimeEnd}");

DateTimeFormatter yearMonthFomatter = DateTimeFormatter.ofPattern("yyyy-MM");
String reportType = "ZeroReport";
String rootPath = "\\\\edc-isilon-smb\\ags2docsuat\\NIBRS";
LocalDate reportDate = LocalDate.now();
String reportFileNamePrefix = "EAttorney_${reportType}_${reportDate.getMonth()}_${reportDate.getDayOfMonth()}_${reportDate.getYear()}_".toString();
String reportFileNameSuffix = ".xml";

File rootDir = new File(rootPath);
String nIBRSReportCategoryCode = "ZERO REPORT";

Path reportPath = Files.createTempFile(rootDir.toPath(), "${reportFileNamePrefix}".toString(), reportFileNameSuffix);
File reportFile = reportPath.toFile();
PrintWriter fileWriter = new PrintWriter(reportFile);

try {
    if (!Files.exists(rootDir?.toPath())) {
        rootDir.mkdir();
    }
    fileWriter.println("""<?xml version="1.0" encoding="UTF-8"?>
<nibrs:Submission xmlns:nibrs="http://fbi.gov/cjis/nibrs/2019.2"
	xmlns:cjis="http://fbi.gov/cjis/2.1" 
	xmlns:s="http://release.niem.gov/niem/structures/3.0/"
	xmlns:j="http://release.niem.gov/niem/domains/jxdm/5.2/" 
	xmlns:nc="http://release.niem.gov/niem/niem-core/3.0/">""");
    fileWriter.println("<cjis:MessageMetadata>");
    //<!-- Message Timestamp -->
    fileWriter.println("<cjis:MessageDateTime>${localDateTime}</cjis:MessageDateTime>");
    //<!-- Message ID -->
    fileWriter.println("<cjis:MessageIdentification>");
    fileWriter.println("<nc:IdentificationID>${messageIdentifier}</nc:IdentificationID>");
    fileWriter.println("</cjis:MessageIdentification>");
    //<!-- NIBRS IEPD Version -->
    fileWriter.println("<cjis:MessageImplementationVersion>2019.2</cjis:MessageImplementationVersion>");
    fileWriter.println("<cjis:MessageSubmittingOrganization>");
    fileWriter.println("<j:OrganizationAugmentation>");
    fileWriter.println("<j:OrganizationORIIdentification>");
    //<!-- Submitting Agency ORI -->
    fileWriter.println("<nc:IdentificationID>${submittingAgencyORINumber}</nc:IdentificationID>");
    fileWriter.println("</j:OrganizationORIIdentification>");
    fileWriter.println("</j:OrganizationAugmentation>");
    fileWriter.println("</cjis:MessageSubmittingOrganization>");
    fileWriter.println("</cjis:MessageMetadata>");
    fileWriter.println("<nibrs:Report>");
    fileWriter.println("<nibrs:ReportHeader>");
    //<!-- Submission Type -->
    fileWriter.println("<nibrs:NIBRSReportCategoryCode>${nIBRSReportCategoryCode}</nibrs:NIBRSReportCategoryCode>");
    //<!-- Submission Action Type -->
    fileWriter.println("<nibrs:ReportActionCategoryCode>${reportActionCategoryCode}</nibrs:ReportActionCategoryCode>");
    //<!-- Year/Month Of Report -->
    fileWriter.println("<nibrs:ReportDate>");
    fileWriter.println("<nc:YearMonthDate>${localDate.format(yearMonthFomatter)}</nc:YearMonthDate>");
    fileWriter.println("</nibrs:ReportDate>");
    fileWriter.println("<nibrs:ReportingAgency>");
    fileWriter.println("<j:OrganizationAugmentation>");
    fileWriter.println("<j:OrganizationORIIdentification>");
    //<!-- Element 1, ORI Code, Owning Agency ORI -->
    fileWriter.println("<nc:IdentificationID>${owningAgencyORINumber}</nc:IdentificationID>");
    fileWriter.println("</j:OrganizationORIIdentification>");
    fileWriter.println("</j:OrganizationAugmentation>");
    fileWriter.println("</nibrs:ReportingAgency>");
    fileWriter.println("</nibrs:ReportHeader>");
    fileWriter.println("</nibrs:Report>");
    fileWriter.println("</nibrs:Submission>");

    fileWriter.flush();
    fileWriter.close();
    _fileOut = reportFile;
    Files.deleteIfExists(reportPath);
} catch (Exception ex) {
    logger.debug("ex: ${ex.getMessage()}");
}









