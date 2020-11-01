package com.example.entreprise.dto;

public class FileResponse {
    private String name;
    private String url;
    private String type;
    private long size;
    private Long candidatId;

    public FileResponse(String name, String url, String type, long size, Long candidatId) {
        this.name = name;
        this.url = url;
        this.type = type;
        this.size = size;
        this.candidatId=candidatId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getSize() {
        return size;
    }

    public Long getCandidatId() {
        return candidatId;
    }

    public void setCandidatId(Long candidatId) {
        this.candidatId = candidatId;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
