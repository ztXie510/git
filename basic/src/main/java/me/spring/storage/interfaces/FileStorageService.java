package me.spring.storage;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * 文件存储服务接口
 */
public interface FileStorageService {

    /**
     * 上传文件
     */
    FileMetadata uploadFile(String fileName, InputStream inputStream, Map<String, String> metadata);

    /**
     * 下载文件
     */
    InputStream downloadFile(String fileId);

    /**
     * 删除文件
     */
    boolean deleteFile(String fileId);

    /**
     * 获取文件信息
     */
    FileMetadata getFileMetadata(String fileId);

    /**
     * 更新文件元数据
     */
    boolean updateFileMetadata(String fileId, Map<String, String> metadata);

    /**
     * 获取文件URL
     */
    String getFileUrl(String fileId, long expireSeconds);

    /**
     * 复制文件
     */
    String copyFile(String sourceFileId, String newFileName);

    /**
     * 移动文件
     */
    boolean moveFile(String sourceFileId, String targetFolderId);

    /**
     * 列出文件
     */
    List<FileMetadata> listFiles(String folderId, FileFilter filter);
}

/**
 * 文件预览服务接口
 */
public interface FilePreviewService {

    /**
     * 生成图片预览
     */
    byte[] generateImagePreview(String fileId, PreviewConfig config);

    /**
     * 生成PDF预览
     */
    byte[] generatePdfPreview(String fileId, PreviewConfig config);

    /**
     * 生成文档预览
     */
    byte[] generateDocumentPreview(String fileId, PreviewConfig config);

    /**
     * 生成视频预览图
     */
    byte[] generateVideoPreview(String fileId, PreviewConfig config);

    /**
     * 获取预览URL
     */
    String getPreviewUrl(String fileId, PreviewType type);
}

/**
 * 文件分享服务接口
 */
public interface FileShareService {

    /**
     * 创建分享链接
     */
    ShareLink createShareLink(String fileId, ShareConfig config);

    /**
     * 获取分享链接信息
     */
    ShareInfo getShareInfo(String shareId);

    /**
     * 访问分享文件
     */
    SharedFile accessSharedFile(String shareId, String password);

    /**
     * 撤销分享
     */
    boolean revokeShare(String shareId);

    /**
     * 设置分享密码
     */
    boolean setSharePassword(String shareId, String password);

    /**
     * 获取分享统计
     */
    ShareStats getShareStats(String shareId, LocalDateTime startTime, LocalDateTime endTime);
}