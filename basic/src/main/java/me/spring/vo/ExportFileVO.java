package me.spring.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Value object for exported file download info.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExportFileVO {
    private String fileName;
    private String fileType;      // excel, pdf
    private byte[] fileData;
    private long fileSize;
}
