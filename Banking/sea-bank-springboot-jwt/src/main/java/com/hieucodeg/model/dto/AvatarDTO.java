package com.hieucodeg.model.dto;

import org.springframework.web.multipart.MultipartFile;

public class AvatarDTO {

    private String id;
    private String name;
    private String description;
    private String fileName;
    private String fileFolder;
    private String fileUrl;
    private String cloudId;
    private String fileProductId;
    private String fileType;
    private MultipartFile file;
}
