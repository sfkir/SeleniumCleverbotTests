package com.example.SeleniumCleverbotTests.Utils.Model;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "mail_id",
        "mail_address_id",
        "mail_from",
        "mail_subject",
        "mail_preview",
        "mail_text_only",
        "mail_text",
        "mail_html",
        "mail_timestamp",
        "mail_attachments_count",
})

public class Email {
    @JsonProperty("mail_id")
    private String mailId;
    @JsonProperty("mail_address_id")
    private String mailAddressId;
    @JsonProperty("mail_from")
    private String mailFrom;
    @JsonProperty("mail_subject")
    private String mailSubject;
    @JsonProperty("mail_preview")
    private String mailPreview;
    @JsonProperty("mail_text_only")
    private String mailTextOnly;
    @JsonProperty("mail_text")
    private String mailText;
    @JsonProperty("mail_html")
    private String mailHtml;
    @JsonProperty("mail_timestamp")
    private Double mailTimestamp;
    @JsonProperty("mail_attachments_count")
    private Integer mailAttachmentsCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("mail_id")
    public String getMailId() {
        return mailId;
    }

    @JsonProperty("mail_id")
    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    @JsonProperty("mail_address_id")
    public String getMailAddressId() {
        return mailAddressId;
    }

    @JsonProperty("mail_address_id")
    public void setMailAddressId(String mailAddressId) {
        this.mailAddressId = mailAddressId;
    }

    @JsonProperty("mail_from")
    public String getMailFrom() {
        return mailFrom;
    }

    @JsonProperty("mail_from")
    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
    }

    @JsonProperty("mail_subject")
    public String getMailSubject() {
        return mailSubject;
    }

    @JsonProperty("mail_subject")
    public void setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
    }

    @JsonProperty("mail_preview")
    public String getMailPreview() {
        return mailPreview;
    }

    @JsonProperty("mail_preview")
    public void setMailPreview(String mailPreview) {
        this.mailPreview = mailPreview;
    }

    @JsonProperty("mail_text_only")
    public String getMailTextOnly() {
        return mailTextOnly;
    }

    @JsonProperty("mail_text_only")
    public void setMailTextOnly(String mailTextOnly) {
        this.mailTextOnly = mailTextOnly;
    }

    @JsonProperty("mail_text")
    public Object getMailText() {
        return mailText;
    }

    @JsonProperty("mail_html")
    public String getMailHtml() {
        return mailHtml;
    }

    @JsonProperty("mail_html")
    public void setMailHtml(String mailHtml) {
        this.mailHtml = mailHtml;
    }

    @JsonProperty("mail_timestamp")
    public Double getMailTimestamp() {
        return mailTimestamp;
    }

    @JsonProperty("mail_timestamp")
    public void setMailTimestamp(Double mailTimestamp) {
        this.mailTimestamp = mailTimestamp;
    }

    @JsonProperty("mail_attachments_count")
    public Integer getMailAttachmentsCount() {
        return mailAttachmentsCount;
    }

    @JsonProperty("mail_attachments_count")
    public void setMailAttachmentsCount(Integer mailAttachmentsCount) {
        this.mailAttachmentsCount = mailAttachmentsCount;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}