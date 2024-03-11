import com.sustain.cases.model.Case
import com.sustain.cases.model.Charge

import java.nio.file.Files;
import groovy.xml.XmlUtil
import com.sustain.document.model.DocDef;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import com.sustain.document.model.Document;
import com.sustain.DomainObject;
import com.sustain.expression.Where;

def String batch = "${_report_month}${_report_year}";
def String caseJudicialDistrictCode = "MISSISSIPPI";

def Where where = new Where()
        .addEquals("docDef.shortName", "NIBRSA")
        .addEquals("batch", batch)
        .addContainsAny("batchSource", ["NIBRSA", "NIBRSB"])

def ArrayList<Document> documents =  DomainObject.find(Document.class, where);
def ArrayList<File> files = documents.file;
def Case cse = Case.get(20490L);
if (!documents.isEmpty()) {
    Path allReportsPath = Files.createTempFile("NIBRS_All_Reports_MARCH_2024_", ".xml");
    def File allReports = allReportsPath.toFile(); ;
    def String declaration = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    def String header = """
                <nibrs:Submission xmlns:nibrs="http://fbi.gov/cjis/nibrs/4.2" xmlns:cjis="http://fbi.gov/cjis/1.0"
                                  xmlns:cjiscodes="http://fbi.gov/cjis/cjis-codes/1.0"
                                  xmlns:i="http://release.niem.gov/niem/appinfo/3.0/"
                                  xmlns:ucr="http://release.niem.gov/niem/codes/fbi_ucr/3.2/"
                                  xmlns:j="http://release.niem.gov/niem/domains/jxdm/5.2/"
                                  xmlns:term="http://release.niem.gov/niem/localTerminology/3.0/"
                                  xmlns:nc="http://release.niem.gov/niem/niem-core/3.0/"
                                  xmlns:niem-xsd="http://release.niem.gov/niem/proxy/xsd/3.0/"
                                  xmlns:s="http://release.niem.gov/niem/structures/3.0/"
                                  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema"
                                  xmlns:nibrscodes="http://fbi.gov/cjis/nibrs/nibrs-codes/4.2"
                                  xmlns:msibrs="http://www.beyond2020.com/msibrs/1.0"
                                  xsi:schemaLocation="http://www.beyond2020.com/msibrs/1.0 ../base-xsd/msibrs/1.0/msibrs.xsd">
                    <cjis:MessageMetadata>
                        <cjis:MessageDateTime>2024-03-10T17:11:30</cjis:MessageDateTime>
                        <cjis:MessageIdentification>
                            <nc:IdentificationID>Case:20490-Charge:1067</nc:IdentificationID>
                        </cjis:MessageIdentification>
                        <cjis:MessageImplementationVersion>2019.2</cjis:MessageImplementationVersion>
                        <cjis:MessageSubmittingOrganization>
                            <j:OrganizationAugmentation>
                                <j:OrganizationORIIdentification>
                                    <nc:IdentificationID>MS090017V</nc:IdentificationID>
                                </j:OrganizationORIIdentification>
                            </j:OrganizationAugmentation>
                        </cjis:MessageSubmittingOrganization>
                    </cjis:MessageMetadata>
                """;
    def String footer = """
                </nibrs:Submission>
                """;
    def String body = "";

    if (!files.isEmpty()) {
        for (File f : files) {
            def XmlParser xmlParser = new XmlParser();logger.debug("1")
            def groovy.util.Node node = (groovy.util.Node) xmlParser.parse(f);logger.debug("2")
            def groovy.util.Node reportNode = (groovy.util.Node) node.children().get(1);logger.debug("3")
            def String report = XmlUtil.serialize(reportNode);logger.debug("4")
            body += report.replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "");logger.debug("5")
        }

        Files.write(Paths.get(allReports.toURI()), (declaration + header + body + footer).getBytes(StandardCharsets.UTF_8));
        def Document allReportsDocument = createDocument( allReports, cse, batch, caseJudicialDistrictCode);
        cse.add(allReportsDocument);
        DomainObject.saveOrUpdate(allReportsDocument);
        DomainObject.saveOrUpdate(cse);

    } else {
        logger.debug("File does not exist");
    }
}

_output = "NIBRS_All_Reports_MARCH_2024_.xml created";


protected Document createDocument(File fileAttachment, Case cse, String batch, String caseJudicialDistrictCode) {
    Document reportDocument = new Document();
    reportDocument.case = cse;
    reportDocument.docDef = DomainObject.find(DocDef.class, "shortName", "NIBRSA").find({ it -> it != null });
    reportDocument.memo = "AllReports";
    reportDocument.reviewStatus = "PRIVILEGED";
    reportDocument.batchSource = "NIBRSA";
    reportDocument.batch = batch;
    reportDocument.filedByText = caseJudicialDistrictCode;
    reportDocument.saveOrUpdate();
    reportDocument.store(fileAttachment);
    return reportDocument;
}