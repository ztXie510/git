package me.spring.utils;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.UnitValue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * PDF export utility using iText 7.
 * Used by ReportService to export statistical reports as PDF.
 */
public class PdfExportUtils {

    /**
     * Export data to PDF byte array.
     * @param title    report title
     * @param headers  column headers
     * @param data     list of rows (each row is a map of column -> value)
     * @return PDF file as byte array
     */
    public static byte[] export(String title, String[] headers, List<Map<String, Object>> data)
            throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(baos);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        document.add(new Paragraph(title).setFontSize(18).setBold());

        Table table = new Table(UnitValue.createPercentArray(headers.length));
        table.setWidth(UnitValue.createPercentValue(100));

        for (String header : headers) {
            table.addHeaderCell(new Paragraph(header).setBold());
        }

        for (Map<String, Object> rowData : data) {
            for (String header : headers) {
                Object value = rowData.get(header);
                table.addCell(value != null ? value.toString() : "");
            }
        }

        document.add(table);
        document.close();
        return baos.toByteArray();
    }
}
