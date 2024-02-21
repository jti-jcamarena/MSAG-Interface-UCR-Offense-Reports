import com.sustain.DomainObject;
import com.sustain.document.model.Document;
import com.sustain.expression.Where;
import com.sustain.util.ZipUtil

import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.ZoneId;


def LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("America/Chicago")).withNano(0);
def Where where = new Where()
        .addEquals("docDef.shortName", "NIBRSA")
        .addEquals("batch", "${_report_month}${_report_year}")
        .addEquals("batchSource", "NIBRSA")
//        .addEquals("filedByText", _jurisdiction);

if (_jurisdiction) {
    where.addEquals("filedByText", _jurisdiction);
}
//if (_county) {
//    where.addEquals("case.county", _county);
//}

def ArrayList<Document> nibrsReportDocuments = DomainObject.find(Document.class, where);
_outputMessage = "Month:${_report_month} Year:${_report_year} Jurisdiction:${_jurisdiction} reports:${nibrsReportDocuments.size()}";

if (!nibrsReportDocuments.isEmpty()) {
    def ArrayList<File> reportFiles = nibrsReportDocuments.findAll({ Document document -> document.file != null }).file;
    def String filePrefix = "${_report_month}${_report_year}_";
    def String fileSuffix = ".zip";

    def File zipFile = File.createTempFile(filePrefix, fileSuffix);

    zipFilesWithUtility(zipFile, reportFiles);

    _nibrsReport = zipFile;
    _tempFilePath = zipFile.getPath();


    //Files.delete(zipFile.toPath());
} else {
    _outputMessage = "NIBRS report not found for search criteria: " + _outputMessage;
}

private void zipFilesWithUtility(File zipFile, ArrayList<File> filesToZip) {
    ZipUtil.zipFiles(zipFile, filesToZip);
}